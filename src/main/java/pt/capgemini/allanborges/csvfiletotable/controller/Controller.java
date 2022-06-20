package pt.capgemini.allanborges.csvfiletotable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.capgemini.allanborges.csvfiletotable.model.Record;
import pt.capgemini.allanborges.csvfiletotable.model.ResponseRecord;
import pt.capgemini.allanborges.csvfiletotable.service.RecordServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private RecordServiceImpl rs;

    @GetMapping(path = "/feedTable")
    public void setDataToDB(){
        rs.parseCsvRecordFileToTable();
    }

    @GetMapping(path = "/getAllData")
    public ResponseEntity<ResponseRecord> getAllData(){
        ResponseRecord responseRecord = new ResponseRecord();
        responseRecord.setSentOn(rs.generateDate());
        responseRecord.setTransactionId(UUID.randomUUID().toString());
        try{
            List<Record> list = rs.getAllData();
            responseRecord.setStatus("OK");
            responseRecord.setStatusCode("200");
            responseRecord.setMsg("Method getAllData Success!");
            responseRecord.setResValues(list);
        } catch (Exception e) {
            responseRecord.setStatus("NOK");
            responseRecord.setStatusCode("500");
            responseRecord.setMsg("Method getAllData Error: " + e.getMessage());
            responseRecord.setResValues(new ArrayList<>());
        }
        return new ResponseEntity<>(responseRecord, HttpStatus.OK);
    }

    @PostMapping(path = "/getByDate")
    public ResponseEntity<ResponseRecord> getByDate(@RequestBody Record record){
        ResponseRecord responseRecord = new ResponseRecord();
        responseRecord.setSentOn(rs.generateDate());
        responseRecord.setTransactionId(UUID.randomUUID().toString());
        try{
            List<Record> list = rs.getByDate(record.getDate());
            responseRecord.setStatus("OK");
            responseRecord.setStatusCode("200");
            responseRecord.setMsg("Method getByDate Success!");
            responseRecord.setResValues(list);
        } catch (Exception e) {
            responseRecord.setStatus("NOK");
            responseRecord.setStatusCode("500");
            responseRecord.setMsg("Method getByDate Error: " + e.getMessage());
            responseRecord.setResValues(new ArrayList<>());
        }
        return new ResponseEntity<>(responseRecord, HttpStatus.OK);
    }

    @PostMapping(path = "/getByDistrictsAndDate")
    public ResponseEntity<ResponseRecord> getByDistrictsAndDate(@RequestBody Record record){
        ResponseRecord responseRecord = new ResponseRecord();
        responseRecord.setSentOn(rs.generateDate());
        responseRecord.setTransactionId(UUID.randomUUID().toString());
        try{
            List<Record> list = rs.getByDistrictsAndDate(record.getDistricts(), record.getDate());
            responseRecord.setStatus("OK");
            responseRecord.setStatusCode("200");
            responseRecord.setMsg("Method getByDistrictsAndDate Success!");
            responseRecord.setResValues(list);
        } catch (Exception e) {
            responseRecord.setStatus("NOK");
            responseRecord.setStatusCode("500");
            responseRecord.setMsg("Method getByDistrictsAndDate Error: " + e.getMessage());
            responseRecord.setResValues(new ArrayList<>());
        }
        return new ResponseEntity<>(responseRecord, HttpStatus.OK);
    }

    @GetMapping(path = "/getNewCasesSumByDistricts")
    public ResponseEntity<ResponseRecord> getNewCasesSumByDistricts(){
        ResponseRecord responseRecord = new ResponseRecord();
        responseRecord.setSentOn(rs.generateDate());
        responseRecord.setTransactionId(UUID.randomUUID().toString());
        try{
            List<Record> list = rs.getNewCasesSumByDistricts();
            responseRecord.setStatus("OK");
            responseRecord.setStatusCode("200");
            responseRecord.setMsg("Method getNewCasesSumByDistricts Success!");
            responseRecord.setResValues(list);
        } catch (Exception e) {
            responseRecord.setStatus("NOK");
            responseRecord.setStatusCode("500");
            responseRecord.setMsg("Method getNewCasesSumByDistricts Error: " + e.getMessage());
            responseRecord.setResValues(new ArrayList<>());
        }
        return new ResponseEntity<>(responseRecord, HttpStatus.OK);
    }
}

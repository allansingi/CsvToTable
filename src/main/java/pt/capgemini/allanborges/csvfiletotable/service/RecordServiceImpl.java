package pt.capgemini.allanborges.csvfiletotable.service;

import pt.capgemini.allanborges.csvfiletotable.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.capgemini.allanborges.csvfiletotable.repository.RecordDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordDTO rdto;

    public void parseCsvRecordFileToTable() {
        try {

            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/aborges/Downloads/data_concelhos.csv"));

            //header array creation
            String headerLine = br.readLine();
            List<String> headers = new ArrayList<>(List.of(headerLine.split(",")));
            headers.remove(0);

            while((line = br.readLine()) != null) {

                List<String> data = new ArrayList<>(List.of(line.split(",")));

                if(data.size() == 307) {
                    data.add("");
                    data.add("");
                    for (int i = 0; i < headers.size(); i++) {
                        Record record = new Record();
                        record.setDistricts(headers.get(i));
                        record.setDate(data.get(0));
                        record.setInfections(data.get(i + 1));
                        rdto.save(record);
                    }
                } else if(data.size() == 308) {
                    data.add("");
                    for (int i = 0; i < headers.size(); i++) {
                        Record record = new Record();
                        record.setDistricts(headers.get(i));
                        record.setDate(data.get(0));
                        record.setInfections(data.get(i + 1));
                        rdto.save(record);
                    }
                } else if(data.size() == 309) {
                    for (int i = 0; i < headers.size(); i++) {
                        Record record = new Record();
                        record.setDistricts(headers.get(i));
                        record.setDate(data.get(0));
                        record.setInfections(data.get(i + 1));
                        rdto.save(record);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

    @Override
    public List<Record> getAllData() {
        return rdto.findAll();
    }

    @Override
    public List<Record> getByDate(String date) {
        return rdto.findByDate(date);
    }

    @Override
    public List<Record> getByDistrictsAndDate(String district, String date) {
        return rdto.findByDistrictsAndDate(district, date);
    }

    @Override
    public List<Record> getNewCasesSumByDistricts() {
        return rdto.findNewCasesSumByDistricts();
    }

}
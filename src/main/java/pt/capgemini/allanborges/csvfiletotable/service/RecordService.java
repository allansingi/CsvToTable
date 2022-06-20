package pt.capgemini.allanborges.csvfiletotable.service;

import pt.capgemini.allanborges.csvfiletotable.model.Record;

import java.util.List;

public interface RecordService {
    void parseCsvRecordFileToTable();
    String generateDate();
    List<Record> getAllData();
    List<Record> getByDate(String date);
    List<Record> getByDistrictsAndDate(String district, String date);
    List<Record> getNewCasesSumByDistricts();
}

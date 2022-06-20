package pt.capgemini.allanborges.csvfiletotable.repository;

import org.springframework.data.jpa.repository.Query;
import pt.capgemini.allanborges.csvfiletotable.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordDTO extends JpaRepository<Record, Integer>{

    List<Record> findByDate(String date);
    List<Record> findByDistrictsAndDate(String district, String date);

    //@Query("SELECT r.districts, SUM(r.infections) FROM Record AS r GROUP BY r.districts")
    @Query("SELECT new Record(r.districts, SUM(r.infections)) FROM Record AS r GROUP BY r.districts")
    List<Record> findNewCasesSumByDistricts();
}
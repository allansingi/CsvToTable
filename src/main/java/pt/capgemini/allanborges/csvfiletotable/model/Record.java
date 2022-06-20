package pt.capgemini.allanborges.csvfiletotable.model;

import javax.persistence.*;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "districts")
    private String districts;

    @Column(name = "infections")
    private String infections;

    public Record() {
    }

    public Record(int id, String date, String districts, String infections) {
        this.id = id;
        this.date = date;
        this.districts = districts;
        this.infections = infections;
    }

    public Record(String districts, String infections) {
        this.districts = districts;
        this.infections = infections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getInfections() {
        return infections;
    }

    public void setInfections(String infections) {
        this.infections = infections;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", districts='" + districts + '\'' +
                ", infections='" + infections + '\'' +
                '}';
    }
}

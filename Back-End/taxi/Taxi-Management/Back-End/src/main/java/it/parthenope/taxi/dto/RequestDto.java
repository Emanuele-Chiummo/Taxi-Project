package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Taxi;

import java.sql.Date;

public class RequestDto {

    private Integer id;
    private Course course;
    private Taxi taxi;
    private Date date;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

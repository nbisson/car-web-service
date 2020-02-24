package fr.nicolasbisson.carWebService.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Dates {

    @org.springframework.data.annotation.Id
    @javax.persistence.Id
    private int id;
    private Date begin = null;
    private Date end = null;

    public Dates() {
    }

    public Dates(Date begin, Date end) {
        this.begin = begin;
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}

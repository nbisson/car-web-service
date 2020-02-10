package fr.nicolasbisson.carWebService.models;

import java.util.Date;

public class Dates {

    private Date begin;
    private Date end;

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

package fr.nicolasbisson.carWebService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CarSQL {

    @javax.persistence.Id
    private String plateNumber;
    private String brand;
    private int price;
    @OneToOne
    private Dates dates = null;

    public CarSQL() {
        super();
    }

    public CarSQL(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public CarSQL(String plateNumber, String brand, int price, Dates dates) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.dates = dates;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonIgnore
    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

}

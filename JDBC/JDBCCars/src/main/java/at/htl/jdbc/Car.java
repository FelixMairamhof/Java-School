package at.htl.jdbc;

import java.time.LocalDate;

public class Car {
    private int id;
    private String brand;
    private Double price;
    private int power;
    private LocalDate registration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Car(int id, String brand, Double price, int power, Date registration) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.power = power;
        this.registration = registration;
    }
}

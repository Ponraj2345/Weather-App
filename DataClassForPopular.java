package com.example.apitest;

public class DataClassForPopular {
    private double degree;
    private String city;
    private String climateCondition;

    public DataClassForPopular(double degree, String city,String climateCondition) {
        this.degree = degree;
        this.city = city;
        this.climateCondition=climateCondition;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClimateCondition() {
        return climateCondition;
    }

    public void setClimateCondition(String climateCondition) {
        this.climateCondition = climateCondition;
    }
}

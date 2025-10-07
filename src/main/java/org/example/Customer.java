package org.example;

public class Customer {
    private  String name;
    private  String city;
    private  int orderValue;


    public Customer(String name, String city, int orderValue) {
        this.name = name;
        this.city = city;
        this.orderValue = orderValue;
    }

    public int getOrderValue() {
        return orderValue;
    }

    @Override
    public String toString() {
        return name + " (" + city + "): amount " + orderValue;
    }
}

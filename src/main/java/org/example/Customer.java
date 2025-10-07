package org.example;

public class Customer {
    private  String name;
    private  String city;
    private  int order_value;


    public Customer(String name, String city, int order_value) {
        this.name = name;
        this.city = city;
        this.order_value = order_value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOrder_value() {
        return order_value;
    }

    public void setOrder_value(int order_value) {
        this.order_value = order_value;
    }

    @Override
    public String toString() {
        return name + " (" + city + "): amount " + order_value;
    }
}

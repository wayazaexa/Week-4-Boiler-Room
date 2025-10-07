package org.example;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> data = new ArrayList<>();
        fileReader(data);

        List<Customer> highValueCustomers = data.stream()
                .filter(customer -> customer.getOrderValue() >= 1000)
                .sorted(Comparator.comparingInt(Customer::getOrderValue).reversed())
                .limit(10)
                .toList();

        highValueCustomers.forEach(System.out::println);
        fileWriter(data);
    }

    private static void fileReader(List<Customer> data) {
        Path filepath = Paths.get("data/boilerroom.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(filepath.toAbsolutePath().toString()))) {
            String line;
            boolean firstRow = true;

            while ((line = br.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                String[] values = line.split(",");
                data.add(new Customer(values[0], values[1], Integer.parseInt(values[2])));
            }
        }
        catch (IOException | NumberFormatException e) {
            System.out.println("Exception: " + e);
        }
    }

    private static void fileWriter(List<Customer> data) {
        Path filepath = Paths.get("data/report.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath.toAbsolutePath().toString()))) {
            for (Customer c : data) {
                bw.write(c + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
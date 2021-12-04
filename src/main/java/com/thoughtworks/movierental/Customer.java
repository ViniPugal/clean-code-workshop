package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new Statement(name, rentals, totalAmount(), frequentRenterPoints()).generate();
    }

    private int frequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    public String htmlStatement() {
        return new HTMLStatement(name, rentals, totalAmount(), frequentRenterPoints()).generate();
    }

}

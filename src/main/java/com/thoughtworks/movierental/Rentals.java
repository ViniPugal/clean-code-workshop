package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    private List<Rental> rentals;

    public Rentals() {
        rentals = new ArrayList<Rental>();
    }

    public void add(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public double totalAmount() {
        return getRentals().stream().mapToDouble(Rental::amount).sum();
    }

    public int frequentRenterPoints() {
        return getRentals().stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}

package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    private final List<Rental> rentals;

    public Rentals() {
        rentals = new ArrayList<>();
    }

    public void add(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> get() {
        return rentals;
    }

    public double totalAmount() {
        return get().stream().mapToDouble(Rental::amount).sum();
    }

    public int frequentRenterPoints() {
        return get().stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}

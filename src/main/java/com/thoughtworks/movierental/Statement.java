package com.thoughtworks.movierental;

import java.util.List;

class Statement {

    private final String customerName;
    private final List<Rental> customerRentals;
    private final double totalAmount;
    private final int frequentRenterPoints;

    public Statement(String customerName, List<Rental> customerRentals, double totalAmount, int frequentRenterPoints) {
        this.customerName = customerName;
        this.customerRentals = customerRentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        String body = "";
        for (Rental rental : customerRentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return body;
    }

    private String footer() {
        String footer = "";
        footer += "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return footer;
    }
}

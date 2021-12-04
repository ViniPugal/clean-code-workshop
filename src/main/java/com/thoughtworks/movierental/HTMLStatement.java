package com.thoughtworks.movierental;

import java.util.List;

class HTMLStatement {

    private final String customerName;
    private final List<Rental> customerRentals;
    private final double totalAmount;
    private final int frequentRenterPoints;

    public HTMLStatement(String customerName, List<Rental> customerRentals, double totalAmount, int frequentRenterPoints) {
        this.customerName = customerName;
        this.customerRentals = customerRentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + customerName + "</b></h1><br>";
    }

    private String htmlBody() {
        String body = "";
        for (Rental rental : customerRentals) {
            body += "&emsp; " + rental.getMovie().getTitle() + " &emsp; " +
                    rental.amount() + "<br>";
        }
        return body;
    }

    private String htmlFooter() {
        String footer = "";
        footer += "Amount owed is <b>" + totalAmount + "</b><br>";
        footer += "You earned <b>" + frequentRenterPoints
                + "</b> frequent renter points";
        return footer;
    }
}

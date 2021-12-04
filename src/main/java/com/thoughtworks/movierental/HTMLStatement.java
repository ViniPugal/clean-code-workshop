package com.thoughtworks.movierental;

class HTMLStatement {

    private final String customerName;
    private final Rentals customerRentals;

    public HTMLStatement(String customerName, Rentals customerRentals) {
        this.customerName = customerName;
        this.customerRentals = customerRentals;
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
        footer += "Amount owed is <b>" + customerRentals.totalAmount() + "</b><br>";
        footer += "You earned <b>" + customerRentals.frequentRenterPoints()
                + "</b> frequent renter points";
        return footer;
    }
}

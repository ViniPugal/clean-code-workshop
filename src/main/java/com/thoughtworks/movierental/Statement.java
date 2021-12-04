package com.thoughtworks.movierental;

class Statement {

    private final String customerName;
    private final Rentals customerRentals;

    public Statement(String customerName, Rentals customerRentals) {
        this.customerName = customerName;
        this.customerRentals = customerRentals;
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
        footer += "Amount owed is " + customerRentals.totalAmount() + "\n";
        footer += "You earned " + customerRentals.frequentRenterPoints()
                + " frequent renter points";
        return footer;
    }
}

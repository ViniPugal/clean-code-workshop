package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CustomerTest {

    @Test
    public void testShouldCheckStatement() {
        Customer customer = new Customer("some name");
        customer.addRental(new Rental(new Movie("children movie", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("new release movie", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("regular movie", Movie.REGULAR), 4));

        String expectedStatement = "Rental Record for some name\n" +
                "\tchildren movie\t1.5\n" +
                "\tnew release movie\t6.0\n" +
                "\tregular movie\t5.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";

        Assertions.assertEquals(expectedStatement, customer.statement());
    }
}
package com.binance.reactive01;

/**
 * @author daiyu
 */
public class S02ObservableSample {

    public static void main(String[] args) {

        Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");

        EndUser user1 = new EndUser("Bob", book);
        EndUser user2 = new EndUser("Rob", book);

        System.out.println(book.getInStock());
        book.setInStock("In Stock");

        System.out.println();

        book.unsubscribeObserver(user1);
        book.setInStock("In Stock");
    }
}

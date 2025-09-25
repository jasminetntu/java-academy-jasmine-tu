package com.pluralsight;

//exercise 1
public class Receipt {
    public static void main(String[] args) {
        String itemName = "Nee Doh Nice Cube";
        double itemPrice = 14.99;
        int numItems = 10;

        double totalPrice = numItems * itemPrice;

        System.out.printf("You bought " + numItems + " " + itemName + "s for $%.2f! "
                + "Are you giving them away as gifts?", totalPrice);
    }
}

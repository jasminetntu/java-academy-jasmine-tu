package com.pluralsight;

public class PalindromeProduct {
    public static void main(String[] args) {
        System.out.println("*** Palindrome Product ***");

        int maxPalindrome = 0;
        String product;
        StringBuilder sbReversed = new StringBuilder();

        System.out.println("Let's find the largest palindrome made from the product of two 3-digit numbers!");

        //find max palindrome
        for (int i = 1; i < 1000; ++i) {
            for (int j = 1; j < 1000; ++j) {
                //get product & reversed product
                product = String.valueOf(i * j);
                sbReversed.append(product).reverse();

                //check if palindrome & update if new max
                if (product.contentEquals(sbReversed) && Integer.parseInt(product) > maxPalindrome) {
                    maxPalindrome = Integer.parseInt(product);
                }

                //clear sb
                sbReversed.setLength(0);
            }
        }

        //print max
        System.out.println("Max palindrome: " + maxPalindrome);
    }
}
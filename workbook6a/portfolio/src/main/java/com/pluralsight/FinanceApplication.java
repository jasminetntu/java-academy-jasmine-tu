package com.pluralsight;

import com.pluralsight.finance.*;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        Valuable account2 = new BankAccount("Gary", "456", 1500);

        // try to deposit money into both accounts
        account1.deposit(100); //works bc it's a bank account
        //account2.deposit(100); //doesn't work bc it's a valuable -> can't access bank account methods
    }
}

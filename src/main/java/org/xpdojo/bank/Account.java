package org.xpdojo.bank;

public class Account {
    private int balance = 0;

    private Account() {
    }

    public static Account createEmptyAccount() {
        return new Account();
    }

    public int balance() {
        return balance;
    }

    public void deposit(int depositAmount) {
        balance += depositAmount;
    }
}

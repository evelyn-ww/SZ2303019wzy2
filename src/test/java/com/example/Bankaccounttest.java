package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialBalance() {
        new BankAccount("12345", -100);
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("12345", 500);
        account.deposit(200);
        assertEquals(700, account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawExceedingBalance() {
        BankAccount account = new BankAccount("12345", 500);
        account.withdraw(600);
    }
    
    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("12345", 500);
        account.withdraw(300);
        assertEquals(200, account.getBalance(), 0.01);
    }
}

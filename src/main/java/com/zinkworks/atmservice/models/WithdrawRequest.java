package com.zinkworks.atmservice.models;

public class WithdrawRequest {

    private int pin, amount;

    public WithdrawRequest() {}

    public WithdrawRequest(int balance, int fiftyEuroNotes) {
        this.pin = balance;
        this.amount = fiftyEuroNotes;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WithdrawRequest{" +
                "pin=" + pin +
                ", amount=" + amount +
                '}';
    }
}

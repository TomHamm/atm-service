package com.zinkworks.atmservice.models;

public class Atm {

    private int balance, fiftyEuroNotes, twentyEuroNotes, tenEuroNotes, fiveEuroNotes;

    public Atm() {}

    public Atm(int balance, int fiftyEuroNotes, int twentyEuroNotes, int tenEuroNotes, int fiveEuroNotes) {
        this.balance = balance;
        this.fiftyEuroNotes = fiftyEuroNotes;
        this.twentyEuroNotes = twentyEuroNotes;
        this.tenEuroNotes = tenEuroNotes;
        this.fiveEuroNotes = fiveEuroNotes;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getFiftyEuroNotes() {
        return fiftyEuroNotes;
    }

    public void setFiftyEuroNotes(int fiftyEuroNotes) {
        this.fiftyEuroNotes = fiftyEuroNotes;
    }

    public int getTwentyEuroNotes() {
        return twentyEuroNotes;
    }

    public void setTwentyEuroNotes(int twentyEuroNotes) {
        this.twentyEuroNotes = twentyEuroNotes;
    }

    public int getTenEuroNotes() {
        return tenEuroNotes;
    }

    public void setTenEuroNotes(int tenEuroNotes) {
        this.tenEuroNotes = tenEuroNotes;
    }

    public int getFiveEuroNotes() {
        return fiveEuroNotes;
    }

    public void setFiveEuroNotes(int fiveEuroNotes) {
        this.fiveEuroNotes = fiveEuroNotes;
    }

    @Override
    public String toString() {
        return "Atm{" +
                ", balance=" + balance +
                ", fiftyEuroNotes=" + fiftyEuroNotes +
                ", twentyEuroNotes=" + twentyEuroNotes +
                ", tenEuroNotes=" + tenEuroNotes +
                ", fiveEuroNotes=" + fiveEuroNotes +
                '}';
    }

}

package com.zinkworks.atmservice.models;

public class WithdrawResponse {

    private int withdrawAmount, accountNumber, currentBalance;
    private String message;

    public WithdrawResponse() {}

    public WithdrawResponse(int withdrawAmount, int accountNumber, int currentBalance, String message) {
        this.withdrawAmount = withdrawAmount;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.message = message;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WithdrawResponse{" +
                "withdrawAmount=" + withdrawAmount +
                ", accountNumber=" + accountNumber +
                ", currentBalance=" + currentBalance +
                ", message='" + message + '\'' +
                '}';
    }
}

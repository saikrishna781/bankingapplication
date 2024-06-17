package com.banking.application.model;

public class PasswordChangeRequest {

    private String username;
    private String newLoginPassword;
    private String newTransactionPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewLoginPassword() {
        return newLoginPassword;
    }

    public void setNewLoginPassword(String newLoginPassword) {
        this.newLoginPassword = newLoginPassword;
    }

    public String getNewTransactionPassword() {
        return newTransactionPassword;
    }

    public void setNewTransactionPassword(String newTransactionPassword) {
        this.newTransactionPassword = newTransactionPassword;
    }
}

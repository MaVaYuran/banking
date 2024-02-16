package by.mariayun.data.dto;

import by.mariayun.data.entity.Account;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class CustomerDto implements Serializable {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Getters and Setters
    // (Omitted for brevity)

    // Additional Methods (can include other methods like deposit, withdraw, etc.)
//    public void deposit(double amount) {
//        if (amount > 0) {
//            this.accountBalance += amount;
//            System.out.println("Deposit of $" + amount + " successful. New balance: $" + this.accountBalance);
//        } else {
//            System.out.println("Invalid deposit amount. Please enter a positive value.");
//        }
//    }
//
//    public void withdraw(double amount) {
//        if (amount > 0 && amount <= this.accountBalance) {
//            this.accountBalance -= amount;
//            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + this.accountBalance);
//        } else {
//            System.out.println("Invalid withdrawal amount or insufficient funds.");
//        }
//    }

}



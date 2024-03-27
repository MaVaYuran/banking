package by.mariayun.data.dto;


import java.io.Serializable;


public final class AccountDto implements Serializable {

    private int id;
    private Integer balance;
    private int customerId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}


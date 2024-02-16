package by.mariayun.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "t_role_id")
    private Role role;

    @OneToMany(mappedBy = "customer")
    List<Account> accounts;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!Objects.equals(username, customer.username)) return false;
        if (!Objects.equals(password, customer.password)) return false;
        if (!Objects.equals(firstName, customer.firstName)) return false;
        if (!Objects.equals(lastName, customer.lastName)) return false;
        if (!Objects.equals(email, customer.email)) return false;
        if (!Objects.equals(role, customer.role)) return false;
        return Objects.equals(accounts, customer.accounts);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
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



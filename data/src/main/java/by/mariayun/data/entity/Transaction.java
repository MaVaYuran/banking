package by.mariayun.data.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="payment")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="value")
    private BigDecimal value;

}

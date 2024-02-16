package by.mariayun.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String type;
}

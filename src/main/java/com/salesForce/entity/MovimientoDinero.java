package com.salesForce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transaction")
public class MovimientoDinero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;

    @Column(name = "amount")
    private float amount;

    @Column(name = "concept")
    private String concept;

    @Column(name = "id_employee")
    private Long id_employee;

    @Column(name = "id_enterprise")
    private Long id_enterprise;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

}

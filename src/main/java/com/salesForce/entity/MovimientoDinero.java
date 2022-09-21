package com.salesForce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transaction")
public class MovimientoDinero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id_transaction;

    @Column(name = "mount")
    private float mount;

    @Column(name = "concept")
    private String concept;

    @ManyToOne
    @JoinColumn
    Employee employee;

    @ManyToOne
    @JoinColumn
    Enterprise enterprise;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

}

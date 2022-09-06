package com.salesForce.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity

@Table(name="transacction")

public class MovimientoDinero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;

    @Column(name = "mount")
    private float montoMovimiento;

    @Column(name = "concept")
    private String conceptoMovimiento;

    @Column(name = "id_employee")
    private Long usuarioMovimiento;

    @Column(name = "id_enterprise")
    private Long enterprise;


}

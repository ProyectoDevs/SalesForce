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
@Table(name = "transaction", indexes = {
        @Index(name = "idx_movimientodinero", columnList = "enterprise_id_enterprise")
})
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
    @JoinColumn(name = "employee_id_employee")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "enterprise_id_enterprise")
    Enterprise enterprise;

    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "created_at")
    private Date created_at;

}

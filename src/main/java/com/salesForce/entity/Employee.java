package com.salesForce.entity;

import com.salesForce.Enums.RolName;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee", nullable = false)
    private Long id_employee;

    @Column(name = "name")
    private String nombreEmpleado;

    @Column(name = "emailEmpleado")
    private String emailEmpleado;

    @Column (name = "id_enterprise")
    private Long id_enterprise;

    @Column(name = "role")
    private RolName role;

    @Column(name = "password")
    private String password;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}

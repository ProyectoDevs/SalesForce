package com.salesForce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table (name = "Enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enterprise", nullable = false)
    private Long id_enterprise;

    @Column (name="name")
    private String name;

    @Column (name="document")
    private String document;

    @Column (name="phone")
    private String phone;

    @Column (name="address")
    private String address;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}

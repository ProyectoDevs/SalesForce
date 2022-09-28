package com.salesForce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_profile", nullable = false)
    private Long id_profile;

    @Column (name = "name", unique=true)
    private String name;

    @Column (name = "email", unique=true)
    private String email;

    @Column (name = "image")
    private String image;

    @Column (name = "auth0Id", unique=true)
    private String auth0Id;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    public Profile(String name, String email, String image, String auth0Id) {
    }
}

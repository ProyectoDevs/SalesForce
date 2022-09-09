package com.salesForce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table (name = "Empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa", nullable = false)
    private Long id_empresa;

    @Column (name="nombreEmpresa")
    private String nombreEmpresa;

    @Column (name="direccionEmpresa")
    private String direccionEmpresa;

    @Column (name="telefonoEmpresa")
    private String telefonoEmpresa;

    @Column (name="nitEmpresa")
    private String nitEmpresa;
}

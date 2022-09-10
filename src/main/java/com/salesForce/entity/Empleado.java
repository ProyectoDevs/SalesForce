package com.salesForce.entity;

import com.salesForce.Enums.TipoEmpleado;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado", nullable = false)
    private Long id_empleado;

    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;

    @Column(name = "emailEmpleado")
    private String emailEmpleado;

    @Column(name = "empresaEmpleado")
    private String empresaEmpleado;

    @Column(name = "rolEmpleado")
    private TipoEmpleado rolEmpleado;

    @Column(name = "password")
    private String password;
}

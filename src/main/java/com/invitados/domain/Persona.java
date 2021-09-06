package com.invitados.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;


@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty // el nombre no puede ser vacio, ni nill
    private String nombre;
    
    @NotEmpty
    @Email
    private String email;
    
    // getters and setters
}

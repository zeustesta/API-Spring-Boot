package com.example.demo.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder

public class ClientDto implements Serializable {
    private Integer id_cliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fecha_registro;
}

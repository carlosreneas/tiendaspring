package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="categoria")
@Data
public class Categoria implements Serializable {

    @Id
    @SequenceGenerator(name="categoria_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_id_seq")
    private Integer id;

    private String descripcion;

}

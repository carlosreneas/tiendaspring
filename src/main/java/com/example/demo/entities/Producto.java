package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="producto2")
@Data
public class Producto implements Serializable {
	
	@Id
	@SequenceGenerator(name="producto2_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="producto2_id_seq")
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
}

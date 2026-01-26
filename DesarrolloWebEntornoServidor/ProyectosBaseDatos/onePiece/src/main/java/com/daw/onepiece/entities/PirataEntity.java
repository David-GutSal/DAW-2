package com.daw.onepiece.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pirata")
public class PirataEntity {
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "frutabelDiablo")
    private String frutabelDiablo;
    
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "estaActivo")
    private boolean estaActivo;
    
    @ManyToOne
    @JoinColumn(name = "isla_id")
    private IslaEntity isla;
    
    public PirataEntity() {
    }
    
    public PirataEntity(int id, String nombre, String frutabelDiablo, LocalDate fechaNacimiento, 
                       boolean estaActivo, IslaEntity isla) {
        this.id = id;
        this.nombre = nombre;
        this.frutabelDiablo = frutabelDiablo;
        this.fechaNacimiento = fechaNacimiento;
        this.estaActivo = estaActivo;
        this.isla = isla;
    }
}
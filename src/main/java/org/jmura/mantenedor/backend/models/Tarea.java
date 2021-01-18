package org.jmura.mantenedor.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "TAREA")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    Long identificador;

    @Column(name = "descripcion")
    String descripcion;

    /*@Column(name = "fechaCreacion")
    String fechaCreacion;*/

    @Column(name = "vigente")
    Boolean vigente;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
}

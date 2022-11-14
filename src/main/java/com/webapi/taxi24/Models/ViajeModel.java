
package com.webapi.taxi24.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ADISON
 */
@Entity
@Table(name = "viaje")
public class ViajeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @OneToOne()
    @JoinColumn(name="id_conductor", referencedColumnName = "id")
    private ConductorModel conductor;
    @OneToOne()
    @JoinColumn(name="id_pasajero", referencedColumnName = "id")
    private PasajeroModel pasajero;
    private String origen;
    private String destino;
    private String estado;
    private Date fecha;

    public ViajeModel() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ViajeModel other = (ViajeModel) obj;
        return Objects.equals(this.id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConductorModel getConductor() {
        return conductor;
    }

    public void setConductor(ConductorModel conductor) {
        this.conductor = conductor;
    }

    public PasajeroModel getPasajero() {
        return pasajero;
    }

    public void setPasajero(PasajeroModel pasajero) {
        this.pasajero = pasajero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}

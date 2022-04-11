/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itson.accesojpa.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "detalleoferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleoferta.findAll", query = "SELECT d FROM Detalleoferta d")
    , @NamedQuery(name = "Detalleoferta.findByIdDetalleOferta", query = "SELECT d FROM Detalleoferta d WHERE d.idDetalleOferta = :idDetalleOferta")})
public class Detalleoferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleOferta")
    private Integer idDetalleOferta;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false)
    private Oferta idOferta;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Detalleoferta() {
    }

    public Detalleoferta(Integer idDetalleOferta) {
        this.idDetalleOferta = idDetalleOferta;
    }

    public Integer getIdDetalleOferta() {
        return idDetalleOferta;
    }

    public void setIdDetalleOferta(Integer idDetalleOferta) {
        this.idDetalleOferta = idDetalleOferta;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleOferta != null ? idDetalleOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleoferta)) {
            return false;
        }
        Detalleoferta other = (Detalleoferta) object;
        if ((this.idDetalleOferta == null && other.idDetalleOferta != null) || (this.idDetalleOferta != null && !this.idDetalleOferta.equals(other.idDetalleOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.accesojpa.entidades.Detalleoferta[ idDetalleOferta=" + idDetalleOferta + " ]";
    }
    
}

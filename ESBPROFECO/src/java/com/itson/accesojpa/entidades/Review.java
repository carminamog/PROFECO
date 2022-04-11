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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
    , @NamedQuery(name = "Review.findByIdReview", query = "SELECT r FROM Review r WHERE r.idReview = :idReview")
    , @NamedQuery(name = "Review.findByContenido", query = "SELECT r FROM Review r WHERE r.contenido = :contenido")
    , @NamedQuery(name = "Review.findByCalificacion", query = "SELECT r FROM Review r WHERE r.calificacion = :calificacion")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReview")
    private Integer idReview;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @JoinColumn(name = "idConsumidor", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idConsumidor;
    @JoinColumn(name = "idMercado", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idMercado;

    public Review() {
    }

    public Review(Integer idReview) {
        this.idReview = idReview;
    }

    public Review(Integer idReview, String contenido, int calificacion) {
        this.idReview = idReview;
        this.contenido = contenido;
        this.calificacion = calificacion;
    }

    public Integer getIdReview() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(Usuario idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public Usuario getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Usuario idMercado) {
        this.idMercado = idMercado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReview != null ? idReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.idReview == null && other.idReview != null) || (this.idReview != null && !this.idReview.equals(other.idReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.accesojpa.entidades.Review[ idReview=" + idReview + " ]";
    }
    
}

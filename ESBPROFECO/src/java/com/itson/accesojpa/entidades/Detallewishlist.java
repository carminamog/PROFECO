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
@Table(name = "detallewishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallewishlist.findAll", query = "SELECT d FROM Detallewishlist d")
    , @NamedQuery(name = "Detallewishlist.findByIdDetalleWishlist", query = "SELECT d FROM Detallewishlist d WHERE d.idDetalleWishlist = :idDetalleWishlist")})
public class Detallewishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleWishlist")
    private Integer idDetalleWishlist;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "idWishlist", referencedColumnName = "idWishlist")
    @ManyToOne(optional = false)
    private Wishlist idWishlist;

    public Detallewishlist() {
    }

    public Detallewishlist(Integer idDetalleWishlist) {
        this.idDetalleWishlist = idDetalleWishlist;
    }

    public Integer getIdDetalleWishlist() {
        return idDetalleWishlist;
    }

    public void setIdDetalleWishlist(Integer idDetalleWishlist) {
        this.idDetalleWishlist = idDetalleWishlist;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Wishlist getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Wishlist idWishlist) {
        this.idWishlist = idWishlist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleWishlist != null ? idDetalleWishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallewishlist)) {
            return false;
        }
        Detallewishlist other = (Detallewishlist) object;
        if ((this.idDetalleWishlist == null && other.idDetalleWishlist != null) || (this.idDetalleWishlist != null && !this.idDetalleWishlist.equals(other.idDetalleWishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.accesojpa.entidades.Detallewishlist[ idDetalleWishlist=" + idDetalleWishlist + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itson.accesojpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "wishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w")
    , @NamedQuery(name = "Wishlist.findByIdWishlist", query = "SELECT w FROM Wishlist w WHERE w.idWishlist = :idWishlist")})
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWishlist")
    private Integer idWishlist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWishlist")
    private Collection<Detallewishlist> detallewishlistCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Wishlist() {
    }

    public Wishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public Integer getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    @XmlTransient
    public Collection<Detallewishlist> getDetallewishlistCollection() {
        return detallewishlistCollection;
    }

    public void setDetallewishlistCollection(Collection<Detallewishlist> detallewishlistCollection) {
        this.detallewishlistCollection = detallewishlistCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWishlist != null ? idWishlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.idWishlist == null && other.idWishlist != null) || (this.idWishlist != null && !this.idWishlist.equals(other.idWishlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.accesojpa.entidades.Wishlist[ idWishlist=" + idWishlist + " ]";
    }
    
}

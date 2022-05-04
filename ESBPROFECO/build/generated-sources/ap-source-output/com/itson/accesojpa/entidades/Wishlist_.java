package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Detallewishlist;
import com.itson.accesojpa.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Wishlist.class)
public class Wishlist_ { 

    public static volatile SingularAttribute<Wishlist, Usuario> idUsuario;
    public static volatile SingularAttribute<Wishlist, Integer> idWishlist;
    public static volatile CollectionAttribute<Wishlist, Detallewishlist> detallewishlistCollection;

}
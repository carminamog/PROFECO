package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Oferta;
import com.itson.accesojpa.entidades.Producto;
import com.itson.accesojpa.entidades.Review;
import com.itson.accesojpa.entidades.Wishlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Review> reviewCollection1;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile CollectionAttribute<Usuario, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<Usuario, String> tipoUsuario;
    public static volatile SingularAttribute<Usuario, String> contrasenia;
    public static volatile CollectionAttribute<Usuario, Producto> productoCollection;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile CollectionAttribute<Usuario, Oferta> ofertaCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile CollectionAttribute<Usuario, Review> reviewCollection;
    public static volatile SingularAttribute<Usuario, String> email;

}
package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Detalleoferta;
import com.itson.accesojpa.entidades.Detallewishlist;
import com.itson.accesojpa.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, Integer> categoria;
    public static volatile SingularAttribute<Producto, byte[]> imagen;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile CollectionAttribute<Producto, Detallewishlist> detallewishlistCollection;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Usuario> idMercado;
    public static volatile CollectionAttribute<Producto, Detalleoferta> detalleofertaCollection;

}
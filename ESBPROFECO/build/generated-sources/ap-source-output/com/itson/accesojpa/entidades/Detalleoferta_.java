package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Oferta;
import com.itson.accesojpa.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Detalleoferta.class)
public class Detalleoferta_ { 

    public static volatile SingularAttribute<Detalleoferta, Integer> idDetalleOferta;
    public static volatile SingularAttribute<Detalleoferta, Oferta> idOferta;
    public static volatile SingularAttribute<Detalleoferta, Producto> idProducto;

}
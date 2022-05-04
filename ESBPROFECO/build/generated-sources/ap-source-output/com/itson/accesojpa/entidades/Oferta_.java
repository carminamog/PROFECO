package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Detalleoferta;
import com.itson.accesojpa.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, String> descripcion;
    public static volatile SingularAttribute<Oferta, Float> descuento;
    public static volatile SingularAttribute<Oferta, Integer> duracion;
    public static volatile SingularAttribute<Oferta, Integer> idOferta;
    public static volatile SingularAttribute<Oferta, Usuario> idMercado;
    public static volatile CollectionAttribute<Oferta, Detalleoferta> detalleofertaCollection;

}
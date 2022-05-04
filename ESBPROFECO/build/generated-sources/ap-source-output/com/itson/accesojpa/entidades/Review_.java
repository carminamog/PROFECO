package com.itson.accesojpa.entidades;

import com.itson.accesojpa.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-04T12:13:08")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, String> contenido;
    public static volatile SingularAttribute<Review, Integer> calificacion;
    public static volatile SingularAttribute<Review, Integer> idReview;
    public static volatile SingularAttribute<Review, Usuario> idMercado;
    public static volatile SingularAttribute<Review, Usuario> idConsumidor;

}
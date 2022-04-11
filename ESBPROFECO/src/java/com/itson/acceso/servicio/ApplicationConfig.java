/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itson.acceso.servicio;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Juan Pablo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.itson.acceso.servicio.DetalleofertaFacadeREST.class);
        resources.add(com.itson.acceso.servicio.DetallewishlistFacadeREST.class);
        resources.add(com.itson.acceso.servicio.OfertaFacadeREST.class);
        resources.add(com.itson.acceso.servicio.ProductoFacadeREST.class);
        resources.add(com.itson.acceso.servicio.ReviewFacadeREST.class);
        resources.add(com.itson.acceso.servicio.UsuarioFacadeREST.class);
        resources.add(com.itson.acceso.servicio.WishlistFacadeREST.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itson.acceso.servicio;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.itson.accesojpa.entidades.Usuario;
import com.itson.rabbitmq.rpc.LoginRPC;
import com.itson.rabbitmq.rpc.NotificacionRPC;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juan Pablo
 */
@Stateless
@Path("/usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "AccesoDatosJPAPU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
        this.em = Persistence.createEntityManagerFactory("AccesoDatosJPAPU").createEntityManager();

    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/{id}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("/count/")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean login(@FormParam("email") String email, @FormParam("psw") String psw) throws IOException, InterruptedException {
        String token = null;
        if (comprobarLogin(email, psw)) {
            return true;
//            try {
//                Algorithm alg = Algorithm.HMAC256("tiburoncin");
//                token = JWT.create().withIssuer("auth0").withClaim("usr", usr).sign(alg);
//            } catch (JWTCreationException e) {
//
//            }
//            return Response.ok().entity(token).build();
        }
        return false;
    }

    private boolean comprobarLogin(String email, String psw) {
        ;
             for (int i=0;i<super.findAll().size();i++) {
                 if (super.findAll().get(i).getEmail().equalsIgnoreCase(email) && super.findAll().get(i).getContrasenia().equals(psw)) {
                     return true;
                 }
        }
             return false;
        
    }

}

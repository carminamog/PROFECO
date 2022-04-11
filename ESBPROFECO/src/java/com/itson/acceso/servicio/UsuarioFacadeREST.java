/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itson.acceso.servicio;

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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    
    
        @GET
    @Path("/login/{email}/{contrasenia}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario login(@PathParam("email") String email, @PathParam("contrasenia") String contrasenia) throws IOException, InterruptedException {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(this.findAll());
//        Usuario usuario = null;
//        usuario.setEmail(email);
//        usuario.setContrasenia(contrasenia);
//        jsonArray.put(usuario);
        try {
            LoginRPC loginRPC = new LoginRPC();
            String response  = loginRPC.call(jsonArray.toString());
            System.out.println("Respuesta RPC recibida: "+response);
            NotificacionRPC notificacionRPC = new NotificacionRPC();
            notificacionRPC.notificacionLogin(response);
//            usuario = null;
//            usuario.setIdUsuario(json.getInt("idUsuario"));
//            usuario.setEmail(json.getString("email"));
//            usuario.setNombre(json.getString("nombre"));
//            usuario.setTelefono(json.getString("telefono"));
//            usuario.setTipoUsuario(json.getString("tipoUsuario"));
//            usuario.setContrasenia(json.getString("contrasenia"));
            
        } catch (TimeoutException ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return this.find(1);
    }

}

package com.likewaze.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mortbay.log.Log;
import org.restlet.resource.ServerResource;

import com.likewaze.model.User;


public class UserController extends ServerResource {

	 protected EntityManagerFactory emf;
     protected EntityManager em;

     public UserController() {
    	 
    	     Log.warn(" Inside UserController logger  ! ");
             emf = Persistence.createEntityManagerFactory("transactions-optional");
             em = emf.createEntityManager();
     }
    
     

     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces({ MediaType.APPLICATION_JSON })
     public User createUser(User obj) {
    	 UserDao dataManager = new UserDao(em);
         //obj.setId(0);
         System.out.println(" registering user how nickname :"+ obj.getPseudo()+" and email is :"+obj.getEmail());
         
         User uschek1=null ; User uschek2=null;
         uschek1 = dataManager.getUserByEmail(obj.getEmail());
         if(uschek1 != null) {
                 System.out.println(" email already exist "); return null;
         }
         uschek2 = dataManager.getUserByPseudo(obj.getPseudo());
         if(uschek2 != null) {
                 System.out.println(" nickname already exist "); return null;
         }
         
         dataManager.create(obj);

         return obj;
    	 
     }
	
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON })
	public User getUserById(@PathParam("id") int iduser) {

        User res = new UserDao(em).getUserById(iduser);

        return res;
		
	}
     
	


}

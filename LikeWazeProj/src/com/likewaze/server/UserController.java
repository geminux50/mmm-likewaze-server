package com.likewaze.server;

import java.util.ArrayList;
import java.util.Collection;

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

import com.likewaze.model.User;
import com.likewaze.server.dao.UserDao;


/**
 * 
 *   User conttroller 
 * 
 * @author 
 *
 */
@Path("/user")
public class UserController {

	 protected EntityManagerFactory emf;
     protected EntityManager em;

     private ArrayList<User> userlist=new ArrayList<User>();
     
     public UserController() {
    	 
    	   //  Log.warn(" Inside UserController logger  ! ");
          emf = Persistence.createEntityManagerFactory("transactions-optional");
          em = emf.createEntityManager();
    	  
     }
      /**
       * Create a user 
       * @param obj
       * @return
       */
    
     @POST
     @Path("/create")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces({ MediaType.APPLICATION_JSON })
     public User createUser(User obj) {
    	 
    	 UserDao dataManager = new UserDao(em);
         System.out.println("Received data from post : User :");
    	 System.out.println(" pseudo :"+obj.getPseudo()+" passwd : "+obj.getPasswd()+ "email :"+obj.getEmail());         
         User us =dataManager.create(obj);
         return us;
     }
	
     /**
      *   Login  operation 
      * @param pseudo_usr
      * @param pass_usr
      * @return
      */
    
    @GET
    @Path("login/{pseudo}/{passwd}")
    @Produces({MediaType.APPLICATION_JSON })
	public  User getUserByIdObj(@PathParam("pseudo") String  pseudo_usr,@PathParam("passwd") String  pass_usr ) {

    	  for(User u:userlist){
    		  if(u.getPseudo().equals(pseudo_usr) && u.getPasswd().equals(pass_usr)){
    			  return u;
    		  }
    		  
    	  }
    	 
         return new User();
    	
	
	}
    /**
     * 
     * @return  List of all the users 
     */
    @GET
    @Path("List")
    @Produces({MediaType.APPLICATION_JSON })
	public  Collection<User> getAllUsers() {

         // retrieve the list of all users
    	 UserDao usrdao = new UserDao(em);
    	 return  usrdao.getAllUsers();
	
    }
    
    /**
     *   Log In operation 
     *  
     * @param pseudo_usr  : pseudo of the user 
     * @param pass_usr  : password  of user 
     * @return  : an instance of user 
     */
    @GET
    @Path("oplogin/{pseudo}/{passwd}")
    @Produces({MediaType.APPLICATION_JSON })
    public  User getUserByPseudovsPasswd(@PathParam("pseudo") String  pseudo_usr,@PathParam("passwd") String  pass_usr ) {

    	UserDao usrdao = new UserDao(em);
    	User u= usrdao.getUserByPseudoAndPass(pseudo_usr, pass_usr);
    	if(u==null)   return new User();	
    	// if not 
    	return u;
	}
       
}

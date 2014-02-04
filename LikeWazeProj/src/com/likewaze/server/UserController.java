package com.likewaze.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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


import com.likewaze.data.UserData;
import com.likewaze.model.User;
import com.likewaze.server.dao.UserDao;

@Path("/user")
public class UserController {

	 protected EntityManagerFactory emf;
     protected EntityManager em;

     private ArrayList<User> userlist=new ArrayList<User>();
     
     public UserController() {
    	 
    	   //  Log.warn(" Inside UserController logger  ! ");
          emf = Persistence.createEntityManagerFactory("transactions-optional");
          em = emf.createEntityManager();
    	  
   /*       userlist = new ArrayList<User>();
    	   
    	 User  us1 = new User(); 
    	 us1.setUserId(0);us1.setEmail("email1@yahoo.fr");us1.setPseudo("user1"); us1.setPasswd("pass1");
    	 User  us2 = new User(); 
    	 us2.setUserId(2); us2.setEmail("email2@yahoo.fr");us2.setPseudo("user2"); us2.setPasswd("pass2");
    	 User  us3 = new User(); 
    	 us3.setUserId(3); us3.setEmail("email3@yahoo.fr");us3.setPseudo("user3"); us3.setPasswd("pass3");
    	 
    	 userlist.add(us1);  userlist.add(us2);  userlist.add(us3);
    	 System.out.println(" *******   User Controller  constructor was  called ! ");
    	
       */
     }
    
    
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
    
    @GET
    @Path("List")
    @Produces({MediaType.APPLICATION_JSON })
	public  Collection<User> getAllUsers() {

         // retrieve the list of all users
    	 UserDao usrdao = new UserDao(em);
    	 return  usrdao.getAllUsers();
	
    }
    
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
    
    
    
    
    
    // To delete 
    @POST
    @Path("adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    public boolean addUser(User obj) {
    	
    	UserData.saveUser(obj);
    	return true;
    }
    
}

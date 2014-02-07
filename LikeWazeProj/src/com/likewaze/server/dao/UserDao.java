package com.likewaze.server.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.likewaze.model.User;

/***
 * 
 *   User data acces Object 
 * @author 
 *
 */
public class UserDao  extends DataDao {

	
	public UserDao(EntityManager entman) {
        super(entman);
    }
	
	/**
	 * 
	 * @param obj  : object of type User 
	 * @return     : the persited object 
	 */
	 public User create(User obj) {

		 //---   We create ad object only if it does not exist 
		 if(getUserByPseudoAndPass(obj.getPseudo(),obj.getPasswd() )!= null){
			 System.out.println("  can't create such user because duplicate pseudo/password ");
			 return new User();
		 }
		 
		 
		 
         tx = null;
         try {
                 tx = em.getTransaction();
                 tx.begin();
                 em.persist(obj);
                 tx.commit();
                 tx = null;

         } catch (RuntimeException e) {
                 System.out.println(e.toString());
                 return null;
         }

         return obj;
    }
	 
	 /**
	  * 
	  * @param _pseud  : pseudo 
	  * @param _pass   : password 
	  * @return    : the user having the pseudo and the password 
	  */
	 public User getUserByPseudoAndPass(String _pseud, String _pass){
		 
		 System.out.println("get User by pseudo :"+_pseud+ "  , pass"+_pass);
		 String queryString1 = "SELECT usr FROM User AS usr where usr.pseudo=:pseud and usr.passwd=:pass";

         try {
                 
        	     Query query1 = em.createQuery(queryString1);
                 query1.setParameter("pseud",_pseud);
                 query1.setParameter("pass",_pass);
                 User usr = (User) query1.getSingleResult();
         
                 return usr;

         } catch (Exception e) {
                 System.out.println(e);
         }

         return null;
	 }
	 
	 /**
	  * 
	  * @param iduser   the id of the user 
	  * @return  the users which have the given id as the parameter 
	  */
	  public User getUserById(int iduser) {

          String queryString1 = "SELECT usr FROM User AS usr where usr.id=:idf ";

          try {
                  Query query1 = em.createQuery(queryString1).setParameter("idf",
                                  iduser);
                  User usr = (User) query1.getSingleResult();
                  return usr;

          } catch (Exception e) {
                  System.out.println(e);
          }

          return null;
    }
	  
     /**
      *   
      * @return   all the resgistered users in the system 
      * 
      */
	  public Collection<User> getAllUsers(){
				  try {
		
		              String queryString = "SELECT us FROM User as us ";
		              Query query = em.createQuery(queryString);
		              // get the list of all the users
		              Collection<User> results =  query.getResultList();                        
		               return results;
		
		      } catch (RuntimeException e) {
		              System.out.println(e.toString());
		      }
		      return null;
	  }
	  
}

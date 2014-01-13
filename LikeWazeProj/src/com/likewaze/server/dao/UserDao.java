package com.likewaze.server.dao;

import javax.persistence.EntityManager;

import com.likewaze.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UserDao  extends DataDao {

	
	public UserDao(EntityManager entman) {
        super(entman);
    }
	
	
	 public boolean create(User obj) {

         tx = null;
         try {
                 tx = em.getTransaction();
                 tx.begin();
                 em.persist(obj);
                 tx.commit();
                 tx = null;

         } catch (RuntimeException e) {
                 System.out.println(e.toString());
                 return false;
         }

         return true;
    }
	 
	  public User getUserById(int iduser) {

          String queryString1 = "SELECT usr FROM User AS usr where usr.id=:idf ";

          try {
                  Query query1 = em.createQuery(queryString1).setParameter("idf",
                                  iduser);
                  User usr = (User) query1.getSingleResult();
           // clear plans and friends
                  //clearFriendsPlans(usr);
                  
                  return usr;

          } catch (Exception e) {
                  System.out.println(e);
          }

          return null;
  }
	  
	  public User getUserByEmail( String arg0) {

          User res = new UserDao(em).getUserByEmail(arg0);

          return res;
    }

	  public User getUserByPseudo( String arg0) {

          User res = new UserDao(em).getUserByEmail(arg0);

          return res;
    }
	  
	  
}

package com.likewaze.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.likewaze.model.User;

public class TestPersite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		  // Use The persistence.xml configuration
        EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("endomondo");
        // Retrieve an entity manager
        EntityManager em = emf.createEntityManager();
        // work with entity manager

        EntityTransaction tx = null;
        try {

                tx = em.getTransaction();
                tx.begin();
                
                User u = new User();
                u.setEmail("K@gmail.com");
                u.setPasswd("pawws word");
                
                em.persist(u);

                tx.commit();

        } catch (RuntimeException e) {

                if (tx != null && tx.isActive())
                        tx.rollback();
                throw e;
        } finally {
                em.close();
        }
        emf.close();



	}

}

package com.likewaze.server.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.likewaze.model.Poi;

/**
 *   Poi data acces object 
 *   
 * @author 
 *
 */
public class PoiDao    extends DataDao {

	public PoiDao(EntityManager em) {
		super(em);
	
	}

	/**
	 * 
	 * @param obj  : the Poi object to persist 
	 * @return    : the persisted Poi object
	 */
	 public Poi create(Poi obj) {

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
	  * @param _idpoi  : id of poi
	  * @return   The poi that was found 
	  */
	 public Poi getPoiById(Long _idpoi) {

         String queryString1 = "SELECT po FROM Poi AS po where po.idpoi=:idf ";

         try {
                 Query query1 = em.createQuery(queryString1).setParameter("idf",
                                 _idpoi);
                 Poi mypoi = (Poi) query1.getSingleResult();
                 return mypoi;

         } catch (Exception e) {
                 System.out.println(e);
         }

         return null;
   }
	 
	 /**
	  * 
	  * @return return the collection of all Poi(s)
	  */
	 public Collection<Poi> getAllPois(){
				  try {
		
		             String queryString = "SELECT po FROM Poi as po ";
		             Query query = em.createQuery(queryString);
		             // get the list of all poi in the data store
		             Collection<Poi> results =  query.getResultList();                        
		              return results;
		
		     } catch (RuntimeException e) {
		             System.out.println(e.toString());
		     }
		     return null;
     }
	 
	 /**
	  * 
	  * @param obj  : The poi to be updated 
	  * @return   : The new poi updated
	  */
      public Poi update(Poi obj) {
    	       
    	        
		         tx = null;
		         try {
		
		                 tx = em.getTransaction();
		                 tx.begin();
		                 Poi  p = em.merge(obj);
		                 tx.commit();
		                 tx = null;
		                 return p;
		
		         } catch (RuntimeException e) {
		                 System.out.println(e.toString());
		                 return new Poi();
		         }
		
		       
		 }
      
      /**
       * 
       * @param idobj : the id of the poi
       * @return  : true if poi was deleted , false if not 
       */
      public Poi supprimer(Long idobj){
    	    Poi savedPoi;
    	  
    		tx = null;
    		try {

    		tx = em.getTransaction();
    		tx.begin();
    		//  get an instance of the object to delete
    		Poi poitodel= getPoiById(idobj);
    		savedPoi = poitodel;
    		em.remove(poitodel);
    		tx.commit();
    		tx = null;

    		} catch (RuntimeException e) {
    		System.out.println(e.toString());
    		return new Poi();
    		}

    		return savedPoi;  
      }
}

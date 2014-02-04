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
import com.likewaze.model.Poi;
import com.likewaze.model.TypePoi;
import com.likewaze.model.User;
import com.likewaze.server.dao.PoiDao;
import com.likewaze.server.dao.UserDao;


@Path("/poi")
public class PoiController {
	
	
	//private ArrayList<Poi> _poilist;
	 protected EntityManagerFactory emf;
     protected EntityManager em;
     
	public PoiController(){
		
		System.out.print(" Call Poi Controller !  ");
		 emf = Persistence.createEntityManagerFactory("transactions-optional");
         em = emf.createEntityManager();
      
	}
	
	//  Create  a  new Poi
	 @POST
     @Path("/create")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces({ MediaType.APPLICATION_JSON })
     public Poi createPoi(Poi obj) {
    	 
    	 PoiDao podao = new PoiDao(em);
         System.out.println("Received data from post : User :");
    	 System.out.println(" Lat :"+obj.getCurLat()+" Long : "+obj.getCurLong()+ "Lab:"+obj.getLabel());         
         Poi mypoi = podao.create(obj);
         return mypoi;
     }
	
	   /**
	    * 
	    * @return  list of pois 
	    */
	    @GET
	    @Path("List")
	    @Produces({MediaType.APPLICATION_JSON })
		public  Collection<Poi> getAllPois() {

	         // retrieve the list of all poi
	    	 PoiDao podao = new PoiDao(em);
	    	 return  podao.getAllPois();
		
	    }
	
	   /**
	    *  
	    * @param poi_id  : id of the poi
	    * @return   : return the poi if found 
	    */
	   @GET
	   @Path("opget/{idpoi}")   
	   @Produces({MediaType.APPLICATION_JSON })
	   public Poi retrieveAPoi(@PathParam("idpoi") Long  poi_id){
		    PoiDao podao = new PoiDao(em);
	    	Poi po = podao.getPoiById(poi_id);
	    	if(po==null)   return new Poi();	
	    	// if not 
	    	return po;
	   }
	    
	   
	   /**
	    * 
	    * @param poi_id  : id of the poi
	    * @param poi_lat :  new latitude of poi
	    * @param poi_long : new longitude of poi
	    * @return  : return the poi updated 
	    */
	   @GET
	   @Path("updatePoi/{idpoi}/{newLat}/{newLong}")   
	   @Produces({MediaType.APPLICATION_JSON })
	   public Poi updateAPoi(@PathParam("idpoi") Long  poi_id,@PathParam("newLat") double  poi_lat,@PathParam("newLong") double  poi_long){
		   
		    System.out.println(" updating a pi id:"+poi_id+"   new lat"+poi_lat+",  new long"+poi_long);
		    PoiDao podao = new PoiDao(em);
	    	Poi po = podao.getPoiById(poi_id);
	    	if(po==null)   return new Poi();	
	    	
	    	po.setCurLat(poi_lat);
	    	po.setCurLong(poi_long);
	    	return podao.update(po);
	    	
	   }
	    
	   /**
	    * 
	    * @param poi_id : the id of the poi 
	    * @return  the deleted Poi 
	    */
	   @GET
	   @Path("deletePoi/{idpoi}")   
	   @Produces({MediaType.APPLICATION_JSON })
	   public Poi deleteAPoi(@PathParam("idpoi") Long  poi_id){
		   
		    System.out.println(" deleting a poi id:"+poi_id);
		    PoiDao podao = new PoiDao(em);
	    	Poi po = podao.supprimer(poi_id);
	    	return po;
	   }


}



/* private void initializePoi(Poi po, int idpoi, double lat, double longit,TypePoi typePoi,String lab ){
	
	po.setIdGpsPts(idpoi);
	po.setCurLat(lat);
	po.setCurLong(longit);
	po.setType(typePoi);
	po.setLabel(lab);
	
}*/

// Initialize some Pois .... 

/* _poilist=  new ArrayList<Poi>();
	 
	Poi poi1 = new Poi(); Poi poi2 = new Poi(); Poi poi3 = new Poi();
	Poi poi4 = new Poi();Poi poi5 = new Poi();Poi poi6 = new Poi();
	
	initializePoi(poi1,0,48.119030, -1.677856, TypePoi.POLICE,"Rennes centre police");
	initializePoi(poi2,1,48.121781, -1.654510, TypePoi.ACCIDENT,"Maurepas accident");	
	initializePoi(poi3,2,48.120864, -1.595459, TypePoi.FLOOD,"Sesson Flood");
	
	initializePoi(poi4,3, 48.091749, -1.618118, TypePoi.FIRE,"Chantepie fire");
	
	initializePoi(poi5,4,48.084410,-1.691246, TypePoi.POLICE,"Brequigny Jam traffic");
	initializePoi(poi6,5,48.108715,-1.644211, TypePoi.USER,"Beaulieu un utilisateur");

	
	_poilist.add(poi1); _poilist.add(poi2);_poilist.add(poi3);
	_poilist.add(poi4);_poilist.add(poi5);_poilist.add(poi6);*/

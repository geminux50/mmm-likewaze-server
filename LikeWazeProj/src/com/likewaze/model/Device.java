package  com.likewaze.model;

import java.io.Serializable;
import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.persistence.*;

@Entity
public class Device implements Serializable  {
    @Id
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int deviceId; 
	
	/*@OneToOne
	private GpsPoint currentPosition;
	*/
    
	@OneToMany
	private Collection<Poi> poiList;
	@ManyToOne
	private Map map;
	@OneToOne
	private Speed myspeed;
    @OneToOne
	private User user;
    
    
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	/*public GpsPoint getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(GpsPoint currentPosition) {
		this.currentPosition = currentPosition;
	}*/
	public Collection<Poi> getPoiList() {
		return poiList;
	}
	public void setPoiList(Collection<Poi> poiList) {
		this.poiList = poiList;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Speed getMyspeed() {
		return myspeed;
	}
	public void setMyspeed(Speed myspeed) {
		this.myspeed = myspeed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
  
	
}
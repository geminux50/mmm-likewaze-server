package  com.likewaze.model;
import java.util.Collection;

import javax.persistence.*;


@Entity
public class  GpsPoint {
	 @Id
	 private  int idGpsPts; 
	 private  double curLat;
	 private  double curLong;
	 @OneToOne
	 private  Device device;
	 
	 
	public int getIdGpsPts() {
		return idGpsPts;
	}
	public void setIdGpsPts(int idGpsPts) {
		this.idGpsPts = idGpsPts;
	}
	public double getCurLat() {
		return curLat;
	}
	public void setCurLat(double curLat) {
		this.curLat = curLat;
	}
	public double getCurLong() {
		return curLong;
	}
	public void setCurLong(double curLong) {
		this.curLong = curLong;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	} 
	 
	 
} 
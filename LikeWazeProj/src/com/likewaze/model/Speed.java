package  com.likewaze.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Speed {
  
     @Id
	private int idSpd; 	
    private double curSpeed;
    private double speedlimite;
    @OneToOne
    private Device device;
	public int getIdSpd() {
		return idSpd;
	}
	public void setIdSpd(int idSpd) {
		this.idSpd = idSpd;
	}
	public double getCurSpeed() {
		return curSpeed;
	}
	public void setCurSpeed(double curSpeed) {
		this.curSpeed = curSpeed;
	}
	public double getSpeedlimite() {
		return speedlimite;
	}
	public void setSpeedlimite(double speedlimite) {
		this.speedlimite = speedlimite;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
    
    
	
}
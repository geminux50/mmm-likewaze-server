package  com.likewaze.model;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class User implements Serializable  {
   
   @Id
   private int userId; 	
   private String pseudo;
   private String email;
   private String passwd;
   @OneToOne
   private Device myDevice;
			   
			public int getUserId() {
				return userId;
			}
			public void setUserId(int userId) {
				this.userId = userId;
			}
			public String getPseudo() {
				return pseudo;
			}
			public void setPseudo(String pseudo) {
				this.pseudo = pseudo;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPasswd() {
				return passwd;
			}
			public void setPasswd(String passwd) {
				this.passwd = passwd;
			}
			public Device getMyDevice() {
				return myDevice;
			}
			public void setMyDevice(Device myDevice) {
				this.myDevice = myDevice;
			}
			  
}
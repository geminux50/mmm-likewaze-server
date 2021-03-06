package  com.likewaze.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *   Entity Client 
 *  
 * */

@Entity
public class User implements Serializable  {
   
  
	private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long userId; 	
   private String pseudo;
   private String email;
   private String passwd;
  
   
			public Long getUserId() {
				return userId;
			}
			public void setUserId(Long userId) {
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
			
			
			  
}
package com.likewaze.data;

import java.util.ArrayList;

import com.likewaze.model.User;

public class UserData {
	
	 private static ArrayList<User> _userlist=new ArrayList<User>();
	
	 
	 
	 public UserData(){
	   /* _userlist = new ArrayList<User>();
  	   
  	   // create the users 
     	 User  us1 = new User(); us1.setEmail("email1@yahoo.fr");us1.setPseudo("user1 ");
  	     User  us2 = new User(); us2.setEmail("email2@yahoo.fr");us2.setPseudo("user2 ");
  	     User  us3 = new User(); us3.setEmail("email3@yahoo.fr");us3.setPseudo("user3 ");
  	    _userlist.add(us1);  _userlist.add(us2);  _userlist.add(us3);*/
		 
	 }
	 
	 public static boolean saveUser(User us){
		   _userlist.add(us); 
		   return true;
	 }

	 public static ArrayList<User> getAllUsers(){
		   
		 return _userlist;  
	 }
}

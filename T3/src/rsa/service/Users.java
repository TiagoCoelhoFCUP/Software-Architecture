package rsa.service;

import java.io.File;
import java.util.LinkedList;

/**
 * A collection of players.
 * Contains methods for registration, authentication and retrieving players and their names.
 * @author Tiago Coelho e Vasco Soares;
 */

public class Users implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private static Users users = null;
	private static LinkedList<User> user_list;
	private static File manager;
	
	private Users() {
		user_list = new LinkedList<User>();
		manager = new File("manager.ser");
	}
	
	public static Users getInstance() { 
		if(users == null) {
			users = new Users(); 
		}
		return users; 
	} 
	
	void reset() {
		Users.user_list = new LinkedList<User>();
		Users.manager = new File("manager.ser");
	}
	
	/**
	 * Registers a non-repeated user that has a valid nickname.
	 * Valid nicknames must be a single word (no white characters) of letters, digits and underscores, starting with a letter
	 * @author Tiago Coelho e Vasco Soares;
	 */
	boolean register(String nick,String name,String password) {
		for(User u : user_list) {
			if(u.nick.equals(nick)){
				return false;
			}
		}
		if(Character.isLetter(nick.charAt(0))) {
			for(char c : nick.toCharArray()) {
				if(!Character.isLetter(c) && !Character.isDigit(c) && !(c == '_')) {
					return false;
				}
			}
			user_list.add(new User(nick,name,password));
			return true;
		}
		else {return false;}
	}
	
	boolean updatePassword(String nick,String oldPassword,String newPassword) {
		for(User u : user_list) {
			if(u.getPassword().equals(oldPassword)) {
				u.setPassword(newPassword);
				return true;
			}
		}
		return false;
	}

	boolean authenticate(String nick,String password) {
		for(User u : user_list) {
			if(u.getNick().equals(nick) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public User getUser(String nick) {
		for(User u : user_list) {
			if(u.getNick().equals(nick)) {
				return u;
			}
		}
		return null;
	}
	
	public static java.io.File getPlayersFile(){
		return manager;
	}
	
	public static void setPlayersFile(File managerFile) {
		manager = managerFile;
	}
}

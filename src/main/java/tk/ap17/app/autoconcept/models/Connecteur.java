package tk.ap17.app.autoconcept.models;

public class Connecteur {
	private String	uri;		//Uniform Resource Identifier
	private String	user;		//Identifiant utilisateur
	private String	password;	//Mot de passe
	private String	port;		//Port de connection

/* Accesseurs à l'attribut uri ******************************/
	public String getUri(){
		return uri;
	}
	void setUri(String newUri){
		uri = newUri;
	}

/* Accesseurs à l'attribut user *****************************/
	public String getUser(){
		return user;
	}
	void setUser(String newUser){
		user = newUser;
	}
	
/* Accesseurs à l'attribut password *************************/
	public String getPassword(){
		return password;
	}
	void setPassword(String newPassword){
		password = newPassword;
	}
	
/* Accesseurs à l'attribut port *****************************/
	public String getPort(){
		return port;
	}
	void setPort(String newPort){
		port = newPort;
	}
}

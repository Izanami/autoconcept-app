package tk.ap17.app.autoconcept.views;

import java.util.Scanner;

import tk.ap17.app.autoconcept.models.Connector;

public class Debug {

	Connector connector;
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		Connector connector = new Connector();
		
		
		connector.setUri("LocalHost");
		connector.setUser("Paf");
		connector.setPassword("edfg");
		connector.setPort("415.258.254");
		
		String con = "Uri";
		String con1 = "User";
		String con2 = "Password";
		String con3 = "Port";
		
		display(con, connector.getUri());
		display(con1, connector.getUser());
		display(con2, connector.getPassword());
		display(con3, connector.getPort());

	}

	public static void display(String nom, String message) {

		System.out.println(nom + ": " + message);

	}
}

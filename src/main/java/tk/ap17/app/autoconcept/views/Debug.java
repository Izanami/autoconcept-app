package tk.ap17.app.autoconcept.views;


import tk.ap17.app.autoconcept.models.Connector;
import java.util.Scanner;


public class Debug {

	Connector connector;

	public static void main(String[] args) {

		Connector connector = new Connector();
		
		connector.setUri("LocalHost");
		connector.setUser("Paf");
		connector.setPassword("edfg");
		connector.setPort("415.258.254");
		
		display(connector.getUri());
		display(connector.getUser());
		display(connector.getPassword());
		display(connector.getPort());

	}

	public static void display(String message) {

		System.out.println(message);
	}


	private Scanner scan = new Scanner(System.in);


	public static void display(String nom, String message) {

		System.out.println(nom + ": " + message);

	}
}

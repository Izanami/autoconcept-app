package tk.ap17.app.autoconcept.views;

import java.util.Scanner;
import tk.ap17.app.autoconcept.orm.Connector;

public class Debug {

	Connector connector;
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Connector connector = new Connector();

		connector.setHost("LocalHost");
		connector.setUser("Paf");
		connector.setPassword("edfg");
		connector.setPort("415.258.254");

		String con = "Host";
		String con1 = "User";
		String con2 = "Password";
		String con3 = "Port";

		display(con, connector.getHost());
		display(con1, connector.getUser());
		display(con2, connector.getPassword());
		display(con3, connector.getPort());

	}

	public static void display(String nom, String message) {

		System.out.println(nom + ": " + message);
	}
}

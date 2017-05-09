package tk.ap17.app.autoconcept.views;

<<<<<<< HEAD
import tk.ap17.app.autoconcept.models.Connector;
=======
import java.util.Scanner;
import tk.ap17.app.autoconcept.orm.Connector;
>>>>>>> 7b3b661116128e8a1ef69aa2679dfcbdc975ed7d

public class Debug {

	Connector connector;
<<<<<<< HEAD

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

=======
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		//Connector connector = new Connector();

		//connector.setHost("LocalHost");
		//connector.setUser("Paf");
		//connector.setPassword("edfg");
		//connector.setPort("415.258.254");

		//String con = "Host";
		//String con1 = "User";
		//String con2 = "Password";
		//String con3 = "Port";

		//display(con, connector.getHost());
		//display(con1, connector.getUser());
		//display(con2, connector.getPassword());
		//display(con3, connector.getPort());

	}

	public static void display(String nom, String message) {

		System.out.println(nom + ": " + message);
>>>>>>> 7b3b661116128e8a1ef69aa2679dfcbdc975ed7d
	}
}

package tk.ap17.app.autoconcept.views;

public class Debug {
	
	String uri;
	String user;
	String password;
	
	public static void main(String[] args) {
		
		Debug debug = new Debug();
		
		debug.uri = "BEAUREGARD";
		
		debug.user = "jack";
		debug.password = "classe";
		
		display(debug.uri);
		display(debug.user);
		display(debug.password);
		
		
		
		
		
	}

	
	
	public static void display(String message){
		
		System.out.println(message);
		
	}
}

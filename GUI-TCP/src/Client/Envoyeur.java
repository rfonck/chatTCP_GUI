package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Envoyeur {

	private String pseudo ;
	private String ip;
	private String port;
	private PrintStream socOut;
	private Socket echoSocket;
	private BufferedReader socIn ;
	private PrintStream socOutTemp;
	private BufferedReader stdIn ;
	
	
	
	  public Envoyeur(String pseudo, String ip, String port) {
		super();
		this.pseudo = pseudo;
		this.ip = ip;
		this.port = port;
	}
	  
	public Socket connecter() {
		System.out.println("là ça va 1");

		System.out.println("là ça va 2");
		try {
			this.echoSocket = new Socket(ip, Integer.parseInt(port));
			this.socIn = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			this.socOut = new PrintStream(echoSocket.getOutputStream());
			this.stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("là ça va 4");
			System.out.println("là ça va 5");
			} catch (UnknownHostException e) {
		      System.err.println("Don't know about host:" + ip);
		      System.exit(1);
		    } catch (IOException e) {
		      System.err.println("Couldn't get I/O for " + "the connection to:" + ip);
		      System.exit(1);
		    }
			System.out.println("là ça va 6");
			
			//ct.start();
			System.out.println("là ça va 7");
			return this.echoSocket;
	}
	
	public void envoyer(String ligne) {
		

        String message = "\n" + pseudo + " a écrit : \n	" + ligne + "\nà :" + new Date().toString();  
        

        socOut.println(message);
	}

	

}
package server;

/***
 * ClientThread
 * Example of a TCP server
 * Date: 14/12/08
 * Authors:
 */




import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Cette classe implémente un thread dédié à la communication avec un client
 * @author romain
 *
 */
public class ServeurThread extends Thread {
	private List<Socket> listeclient;
	private Socket clientSocket;
	private List<String> listeMessages;

	ServeurThread(Socket s) {
		this.clientSocket = s;
	}

	/**
	 * A l'arrivée d'un message, on l'envoie à tout les autres clients grâce à une liste synchronisée 
	 */
	public void run() {
    	  try {
              synchronized (listeclient) {
            	  listeclient.add(clientSocket);
              }
              
              synchronized(listeMessages) {
            	  for (String message : listeMessages) {
    					
            		  try {
      						// note pour JJ ici faut modifier 
      						PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
      						printWriter.println(message); 
      					} catch (IOException e) {
      						// TODO Auto-generated catch block
      						e.printStackTrace();
      					} 
            		  
            	  }
              }
        		
    		  
    		  BufferedReader socIn = null;
    		  socIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
    		  PrintStream socOut = new PrintStream(clientSocket.getOutputStream());
    		  while (true) {
    			  
    			  String line = socIn.readLine();
    			  
    			  if(line.equals("null")) {

    				  synchronized(listeclient) {
    					  listeclient.remove(clientSocket);
    				  }
    				  clientSocket.close();
    				  System.exit(1);
    			  }
    			  
	    		  synchronized(listeMessages){
	    			  listeMessages.add(line);	    			  
	    		  }
	    		  
    			  for(Socket soc : listeclient) {

    				  if(soc.equals(clientSocket)) {
    					  
    				  }else {
	        				System.out.println("j'écris à" + soc.toString());
	      					try {
 
	      						PrintWriter printWriter = new PrintWriter(soc.getOutputStream(), true);
	      						printWriter.println(line); 
	      					} catch (IOException e) {
	      						listeclient.remove(soc);
	      						e.printStackTrace();
	      					} 
    				  }

    			  }
	    		  

    		  
    		 
    		}
    	} catch (Exception e) {
        	System.err.println("Error in EchoServer:" + e); 
        }
       }

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}



	public ServeurThread(List<Socket> listeclient, Socket clientSocket) {
		super();
		this.listeclient = listeclient;
		this.clientSocket = clientSocket;
	}

	public ServeurThread(List<Socket> listeclient, Socket clientSocket, List<String> listeMessages) {
		super();
		this.listeclient = listeclient;
		this.clientSocket = clientSocket;
		this.listeMessages = listeMessages;
	}





	
  }

  

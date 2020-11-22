package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * EchoServer
 * Example of a TCP server
 * Date: 10/01/04
 * Authors:
 */


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Client.ViewClient;

public class EchoServerMultiThreaded  {
  
	private ViewServer view ;
	private List<Socket> listeSockets = Collections.synchronizedList(new ArrayList<Socket>());
	private List<ServeurThread> listeServeurThread = Collections.synchronizedList(new ArrayList<ServeurThread>());
	private ThreadGenerator threadGenerator; 
    public EchoServerMultiThreaded(ViewServer view) {
		super();
		
		this.view = view;
		this.view.addStrartListener(new StartListener());
		this.view.addStropListener(new StopListener());
	
    }
   

	
    public void start(String port){ 
        ServerSocket listenSocket;
		
		try {
			listenSocket = new ServerSocket(Integer.parseInt(port)); 
			System.out.println("Server ready..."); 

			this.threadGenerator = new ThreadGenerator(listenSocket, listeSockets, listeServeurThread);
			threadGenerator.start();

		}catch (Exception e) {
			System.err.println("Error in EchoServer:" + e);
		}
    }
       
    public void stop(){ 
        for(ServeurThread thread : this.listeServeurThread) {
        	thread.stop();
        }
        synchronized(listeSockets) {
        	for(Socket soc : listeSockets) {
        		try {
					soc.close();
				} catch (IOException e) {
					System.err.println("erreur dans la cloture d'un socket");
					e.printStackTrace();
				}
        	}
        }
        this.threadGenerator.stop();
        System.exit(1);
        
        
    }
    
   class StartListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           System.out.println("start");
           start(view.getPort());
       }
   }
       
   class StopListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           System.out.println("stop");
           stop();
       }
   }
   
   
}

  

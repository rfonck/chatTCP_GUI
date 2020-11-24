package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Classe implémentant un thread (qui gère les nouvelles connexions)
 * @author romain
 *
 */
public class ThreadGenerator  extends Thread {

	private ServerSocket listenSocket;
	private List<Socket> listeSockets = Collections.synchronizedList(new ArrayList<Socket>());
	private List<ServeurThread> listeServeurThread = Collections.synchronizedList(new ArrayList<ServeurThread>());
	private List<String> listeMessages = Collections.synchronizedList(new ArrayList<String>());
	
	public ThreadGenerator(ServerSocket listenSocket, List<Socket> listeSockets,
			List<ServeurThread> listeServeurThread) {
		super();
		this.listenSocket = listenSocket;
		this.listeSockets = listeSockets;
		this.listeServeurThread = listeServeurThread;
	}





	public void run() {
		
		while (true) {
			Socket clientSocket;
			try {
				clientSocket = listenSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			System.out.println("Connexion from:" + clientSocket.getInetAddress());
			ServeurThread ct = new ServeurThread(listeSockets, clientSocket, listeMessages);
			ct.start();
			listeServeurThread.add(ct);
		}
	
	}



}






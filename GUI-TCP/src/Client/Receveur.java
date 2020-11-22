package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receveur extends Thread {

	private Socket clientSocket;
	private MessageListener messageListener;
	Receveur(Socket s) {
		this.clientSocket = s;
	}

	@Override
	public void run() {
		try (BufferedReader socIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			while (!clientSocket.isClosed()) {
				String message = socIn.readLine();
				this.messageListener.nouveauMessage( message);
			}
		} catch (Exception e) {
			System.err.println("Error in EchoServer:" + e);
		}
	}
	
	public void addMessageListener(MessageListener listener) {
		this.messageListener = listener;
	}

	public void quitter() {
		try {
			this.clientSocket.close();
		} catch (IOException e) {
			System.out.println("erreur lors de la déconnexion R");
			e.printStackTrace();
		}
		
	}


}
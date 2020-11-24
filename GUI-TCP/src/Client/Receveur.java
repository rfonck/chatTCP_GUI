package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * Classe qui va écouter sur la socket de réception.
 * @author romain
 *
 */
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
				if(message.equals("null")) {
					break;
				}
				this.messageListener.nouveauMessage( message);
			}
		} catch (Exception e) {
			System.err.println("Error in EchoServer:" + e);
			
		}
		finally {
			System.exit(1);
		}
	}
	/**
	 * On ajoute un listener pour prévenir le modele, puis le controlleur de l'arrivée d'un message
	 * @param listener
	 */
	public void addMessageListener(MessageListener listener) {
		this.messageListener = listener;
	}
	/**
	 * On ferme le socket et on clot les communications
	 */
	public void quitter() {
		try {
			this.clientSocket.close();
		} catch (IOException e) {
			System.out.println("erreur lors de la déconnexion R");
			e.printStackTrace();
		}
		
	}


}
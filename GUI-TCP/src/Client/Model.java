package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Model {

	private Receveur receveur;
	private Envoyeur envoyeur;
	private Socket socket;
	private MessageListener messageListener;
	

	public void initEnvoyeur(String pseudo, String ip, String port) {
		envoyeur = new Envoyeur(pseudo, ip , port);
		socket = envoyeur.connecter();
		receveur = new Receveur(socket);
		receveur.addMessageListener(new RecevoirMessageListener(messageListener));
		receveur.start();
	}
	
	public void envoyer(String message) {
		envoyeur.envoyer(message);
	}
	
	public void addMessageListener(MessageListener listener) {
		this.messageListener = listener;
	}
	
    class RecevoirMessageListener implements MessageListener {
    	
    	private MessageListener messageListener;
    	
    	public RecevoirMessageListener(MessageListener messageListener) {
			super();
			this.messageListener = messageListener;
		}

		public void nouveauMessage(String message) {
    		this.messageListener.nouveauMessage(message);
    	}
    }
}

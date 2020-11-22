package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Model model ;
	private View view;
	
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		
		view.addConnexionListener(new ConnexionListener());
		view.addEnvoiListener(new EnvoyerMessageListener());
		model.addMessageListener(new RecevoirMessageListener());
	}
	
    class ConnexionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
            	String ip = view.getIp();
            	String port = view.getPort();
            	String pseudo = view.getPseudo();
            	
            	model.initEnvoyeur(pseudo, ip, port);
            } catch (NumberFormatException nfex) {
            }
        }
    }
    class EnvoyerMessageListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            try {
            	String message = view.getUserMessage();
            	model.envoyer(message);
            } catch (NumberFormatException nfex) {
            }
        }
    }
    
    class RecevoirMessageListener implements MessageListener {
    	public void nouveauMessage(String message) {
    		view.addMessageRecu(message);
    	}
    }
	
}

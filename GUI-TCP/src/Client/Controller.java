package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Controller {

	private Model model ;
	private ViewClient view;
	
	
	public Controller(Model model, ViewClient view) {
		super();
		this.model = model;
		this.view = view;
		
		view.addConnexionListener(new ConnexionListener());
		view.addEnvoiListener(new EnvoyerMessageListener());
		view.addQuitterListener(new QuitterListener());
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
            	view.setUserMessage("");
            	view.addMessageRecu("\n Vous avez écrit: \n	" + message + "\nà: " + new Date().toString());
            	model.envoyer(message);
            } catch (NumberFormatException nfex) {
            }
        }
    }
    
    class QuitterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.quitter();
            System.exit(1);

        }
    }
    
    class RecevoirMessageListener implements MessageListener {
    	public void nouveauMessage(String message) {
    		view.addMessageRecu(message);
    	}
    }
	
}

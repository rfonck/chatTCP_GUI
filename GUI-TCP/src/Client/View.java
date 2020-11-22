package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{

	private Model model ;


	
	private JButton envoyer = new JButton("Envoyer");
	private JButton connexion = new JButton("connexion");
	
	private JTextArea zoneMessagesRecus = new JTextArea();
	private JTextField zoneMessageEnvoye = new JTextField("Message à envoyer");
	private JTextField pseudo = new JTextField("pseudo");
	private JTextField ip = new JTextField("Adresse IP");
	private JTextField port = new JTextField("Port");
	
	private JPanel conteneur = new JPanel();
	

	public View(Model model) {
		
		
		this.model = model;
		
		
	    this.setSize(500,600);
	    this.setResizable(false);
	    this.setTitle("Client chat");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    conteneur.add(pseudo);
	    conteneur.add(ip);
	    conteneur.add(port);
	    conteneur.add(connexion);
	    
	    conteneur.add(zoneMessagesRecus);
	    
	    conteneur.add(zoneMessageEnvoye);
	    conteneur.add(envoyer);
	    
	    conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.PAGE_AXIS));
	    
	    this.setContentPane(conteneur);

	}
	
	//Méthodes pour que le controleur puisse ajouter ses listeners
	
    public void addConnexionListener(ActionListener co) {
        connexion.addActionListener(co);
    }
    
    public void addEnvoiListener(ActionListener envoi) {
    	envoyer.addActionListener(envoi);
    }
    
    public String getUserMessage() {
    	return zoneMessageEnvoye.getText();
    }
    
    public String getIp() {
    	return ip.getText();
    }
	
    public String getPort() {
    	return port.getText();
    }
    
    public String getPseudo() {
    	return pseudo.getText();
    }
    
    public void addMessageRecu(String nouveauMessage) {
    	String anciensMessages = zoneMessagesRecus.getText();
    	zoneMessagesRecus.setText(anciensMessages.concat(nouveauMessage));
    	
    }
}

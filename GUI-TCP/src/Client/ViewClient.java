package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ViewClient extends JFrame{

	private Model model ;


	
	private JButton envoyer = new JButton("Envoyer");
	private JButton connexion = new JButton("connexion");
	private JButton quitter = new JButton("quitter");
	
	private JTextArea zoneMessagesRecus = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(zoneMessagesRecus);
	private JTextField zoneMessageEnvoye = new JTextField("Message à envoyer");
	private JTextField pseudo = new JTextField("pseudo");
	private JTextField ip = new JTextField("127.0.0.1");
	private JTextField port = new JTextField("2048");

	

	public ViewClient(Model model) {
		
		
		this.model = model;
		
		
	    this.setSize(500,600);
	    this.setResizable(false);
	    this.setTitle("Client chat");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    
	    pseudo.setBounds(25, 20, 100, 20);
	    this.add(pseudo);
	    
	    ip.setBounds(150, 20, 100, 20);
	    this.add(ip);
	    
	    port.setBounds(275, 20, 40, 20);
	    this.add(port);
	    
	    connexion.setBounds(340, 20, 135, 20);
	    this.add(connexion);


	    scrollPane.setBounds(25, 80, 450, 340);
	    this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    this.add(scrollPane);
	    
	    zoneMessageEnvoye.setBounds(25, 460, 290, 60);
	    this.add(zoneMessageEnvoye);
	    
	    envoyer.setBounds(350, 460, 135, 20);
	    this.add(envoyer);
	    
	    quitter.setBounds(350, 500, 135, 20);
	    this.add(quitter);


	}
	
	//Méthodes pour que le controleur puisse ajouter ses listeners
	
    public void addConnexionListener(ActionListener co) {
        connexion.addActionListener(co);
    }
    
    public void addEnvoiListener(ActionListener envoi) {
    	envoyer.addActionListener(envoi);
    }
    
    public void addQuitterListener(ActionListener quitter) {
    	this.quitter.addActionListener(quitter);
    }
    
    public String getUserMessage() {
    	return zoneMessageEnvoye.getText();
    }
    
    public void setUserMessage(String ligne) {
    	zoneMessageEnvoye.setText(ligne);
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
    	zoneMessagesRecus.append(nouveauMessage + "\n");
    }
}

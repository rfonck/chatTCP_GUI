package server;

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


/**
 * IMH du serveur
 * @author romain
 *
 */
public class ViewServer extends JFrame{


	
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");
	private JTextField port = new JTextField("2048");

	

	public ViewServer() {
		
	    this.setSize(350,100);
	    this.setResizable(false);
	    this.setTitle("Serveur chat");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    
	    port.setBounds(25, 20, 50, 20);
	    this.add(port);
	    
	    start.setBounds(100, 20, 100, 20);
	    this.add(start);
	    
	    stop.setBounds(225, 20, 100, 20);
	    this.add(stop);
	}
	
    public void addStrartListener(ActionListener start) {
    	this.start.addActionListener(start);
    }
    
    public void addStropListener(ActionListener stop) {
    	this.stop.addActionListener(stop);
    }
	
    public String getPort() {
    	return port.getText();
    }
    
}

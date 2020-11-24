package server;

/**
 * Classe main du projet
 * @author romain
 *
 */
public class Main {

	public static void main(String[] args) {
		ViewServer view = new ViewServer();
		EchoServerMultiThreaded echoServerMultiThreaded = new EchoServerMultiThreaded(view);
		
		view.setVisible(true);
	}

}

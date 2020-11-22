package server;

public class Main {

	public static void main(String[] args) {
		ViewServer view = new ViewServer();
		EchoServerMultiThreaded echoServerMultiThreaded = new EchoServerMultiThreaded(view);
		
		view.setVisible(true);
	}

}

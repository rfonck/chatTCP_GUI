package Client;

/**
 * Classe main du projet
 * @author romain
 *
 */
public class Main {

	public static void main(String[] args) {
		Model      model      = new Model();
		ViewClient       view       = new ViewClient(model);
		Controller controller = new Controller(model, view);
        
        view.setVisible(true);
	}

}

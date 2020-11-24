package Client;
/**
 * Interface qui permet au Receveur de prévenir le controleur qu'un message est arrivé.
 * @author romain
 *
 */
public interface MessageListener {
	 void nouveauMessage(String message);
}

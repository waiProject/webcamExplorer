package exception;

public class UserNotSavedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotSavedException() {
		super("Benutzer konnte nicht gespeichert werden!");
	}
}

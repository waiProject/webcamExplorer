package exception;

import model.User;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(User user) {
		super("Benutzer: " + user.getName() + " wurde nicht gefunden oder das Passwort ist falsch!");
	}
	
	public UserNotFoundException(Long id) {
		super("Benutzer mit der ID: " + id + " wurde nicht gefunden!");
	}
	
	public UserNotFoundException() {
		super("Benutzer kann nicht gefunden werden oder das Passwort ist falsch!");
	}
}

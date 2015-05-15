package exception;

public class UserNotDeletedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNotDeletedException(Long id) {
		super("User mit der user_id " + id + " konnte nicht gelöscht werden!");
	}
}

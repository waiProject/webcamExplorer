package exception;

public class CamNotDeletedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CamNotDeletedException(Long id) {
		super("Cam mit der Id " + id + " konnte nicht geändert werden!");
	}
}

package exception;

public class CamNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CamNotFoundException(Long id) {
		super("Cam mit der Id " + id + " wurde nicht gefunden!");
	}
	
	public CamNotFoundException() {
		super("Cam können nicht aufgelistet werden!");
	}
}

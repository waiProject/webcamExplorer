package exception;

public class ImageNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException(Long id) {
		super("Image mit der id " + id + " wurde nicht gefunden!");
	}
	
	public ImageNotFoundException() {
		super("Images können nicht aufgelistet werden!");
	}
}

package exception;

public class ImageNotSavedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImageNotSavedException() {
		super("Image konnte nicht gespeichert werden!");
	}
}

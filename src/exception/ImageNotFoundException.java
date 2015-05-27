package exception;

public class ImageNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException(Long id) {
		super("Image mit der Id " + id + " wurde nicht gefunden!");
	}
	
	public ImageNotFoundException() {
		super("Image kann nicht ausgegeben werden!");
	}
}

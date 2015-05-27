package exception;

public class ImageNotDeletedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ImageNotDeletedException(Long id) {
		super("Image mit der img_id " + id + " konnte nicht gelöscht werden!");
	}
}

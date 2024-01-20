package in.nikamn.custom_exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}

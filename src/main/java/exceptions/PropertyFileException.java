package exceptions;


@SuppressWarnings("serial")
public class PropertyFileException extends FrameworkException{

		public PropertyFileException(String message) {
			super(message);
		}
		
		public PropertyFileException(String message, Throwable cause) {
			super(message, cause);
		}
}

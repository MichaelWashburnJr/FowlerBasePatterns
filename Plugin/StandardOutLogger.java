public class StandardOutLogger implements Logger {
	@Override
	public void logMessage(String message) {
		System.out.println("[INFO]  " + message);
	}

	@Override
	public void logError(String message) {
		System.err.println("[ERROR] " + message);
	}

	@Override
	public void logDebug(String message) {
		System.out.println("[DEBUG] " + message);
	}
}
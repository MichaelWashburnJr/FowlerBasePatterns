// sample interface for logging
public interface Logger {

	// standard logging
	public void logMessage(String message);

	// error logging
	public void logError(String message);

	// developer debug logging
	public void logDebug(String message);
}
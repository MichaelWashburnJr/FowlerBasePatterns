import java.io.*;
public class FileLogger implements Logger {
	
	private static void appendToFile(String message, String filename) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
			out.println(message);
		} catch (IOException e) {
			// this is just an example we don't need exception handling.
		}
		return;
	}

	@Override
	public void logMessage(String message) {
		appendToFile("[INFO]  " + message, "system.log");
	}

	@Override
	public void logError(String message) {
		// append to sys log and error log
		appendToFile("[ERROR] " + message, "system.log");
		appendToFile("[ERROR] " + message, "error.log");
	}

	@Override
	public void logDebug(String message) {
		// debug logs not used in production logger
		return;
	}
}
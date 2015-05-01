import java.util.*;
import java.io.*;

public class Example {
	public static Properties p;
	public static void main(String[] args) {
		// load the properties
		FileInputStream stream = null;
		p = new Properties();
		try {
			stream = new FileInputStream(new File("config.properties"));
			p.load(stream);
		} catch (IOException e) {
			System.out.println("Could not open config");
			System.exit(0);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}		
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		Logger l = (Logger)getPlugin(Logger.class);
		l.logMessage("Test");
		l.logError("Error");
		l.logDebug("Debug");
	}

	// get a plugin
	public static Object getPlugin(Class iface) {
		String implName = p.getProperty(iface.getName());
		if (implName == null) {
			throw new RuntimeException("implementation not specified for " + iface.getName() + " in config.properties.");
		}
		try {
			return Class.forName(implName).newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("factory unable to construct instance of " + iface.getName());
		}
	}
}
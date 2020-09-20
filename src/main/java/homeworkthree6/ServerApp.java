package homeworkthree6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerApp {
    private static final Logger LOGGER = LogManager.getLogger(ServerApp.class);

    public static void main(String[] args) {
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.warn("Warn");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
        LOGGER.info("String: {}.", "My message");

        //new ServerService();
    }
}

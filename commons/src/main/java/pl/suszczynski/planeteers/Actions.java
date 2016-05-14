package pl.suszczynski.planeteers;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.GameState;
import pl.suszczynski.planeteers.utility.ConsoleUtil;

/**
 * Created by daniel on 14.05.16.
 */
public class Actions {

    private static final Logger LOGGER = Logger.getLogger(Actions.class);

    private Actions() {
    }

    public static void exit(GameState gameState) {

        LOGGER.info("Action: EXIT");

        if (gameState != null && !gameState.isSaved()) {
            ConsoleUtil.writeGaia("Are you sure you want to leave us without saving game?");
            if (!ConsoleUtil.readYN()) {
                ConsoleUtil.readCommand(gameState);
            } else {
                ConsoleUtil.writeGaia("Have a nice day!");
            }
        } else {
            ConsoleUtil.writeGaia("Have a nice day!");
        }
    }
}

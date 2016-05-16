package pl.suszczynski.planeteers;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.helper.ConsoleHelper;

/**
 * Created by daniel on 14.05.16.
 */
public class Actions {

    private static final Logger LOGGER = Logger.getLogger(Actions.class);

    private Actions() {
    }

    public static void exit(Game game) {

        LOGGER.info("Action: EXIT");

        if (game != null && !game.isSaved()) {
            ConsoleHelper.writeGaia("Are you sure you want to leave us without saving game?");
            if (!ConsoleHelper.readYN()) {
                ConsoleHelper.readCommand(game);
            } else {
                ConsoleHelper.writeGaia("Have a nice day!");
            }
        } else {
            ConsoleHelper.writeGaia("Have a nice day!");
        }
    }
}

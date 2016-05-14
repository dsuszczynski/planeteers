package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.Player;

/**
 * {@link ConsoleUtil} is a utility class responsible for preparation a console output in perspicuous way.
 *
 * Created by daniel on 14.05.16.
 */
public class ConsoleUtil {

    private static final Logger LOGGER = Logger.getLogger(ConsoleUtil.class);

    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String FAINT = "\u001B[2m";
    private static final String ITALIC = "\u001B[3m";
    private static final String UNDERLINE = "\u001B[4m";

    private static final String PRIMARY = "\u001B[10m";


    /**
     * Java common practice to create kind of static class.
     */
    private ConsoleUtil() {
    }

    /**
     * This method write directly on CLI what Player wants to say.
     *
     * @param player
     * @param statement - sentence which Player wants to say
     */
    public static void write(Player player, String statement) {
        System.out.print(player.getCharacterType().getColorType() + (player.getName() != null ? player.getName() : player.getCharacterType().getName()) + ": ");
        System.out.println(RESET + statement);
    }

    /**
     * Write welcome on CLI to greet new Player.
     */
    public static void writeWelcome() {
        System.out.println(BOLD + "WELCOME IN " + UNDERLINE + "Captain Planet and the Planeteers" + RESET + " CLI game!");
    }

    public static void writeError(String message) {
        System.out.println(ColorType.RED + BOLD + "ERROR: " + PRIMARY + ColorType.RED + message + RESET);
    }

}

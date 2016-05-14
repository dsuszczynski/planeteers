package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.Player;

import static java.lang.System.out;

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
     * Gaia is a guide and narrator in a game.
     *
     * @param statement
     */
    public static void writeGaia(String statement) {
        out.println(ColorType.WHITE + BOLD + "Gaia: " + RESET + statement);
    }

    /**
     * This method write directly on CLI what Player wants to say.
     *
     * @param player
     * @param statement - sentence which Player wants to say
     */
    public static void write(Player player, String statement) {
        StringBuilder intro = new StringBuilder();
        intro.append(player.getCharacterType().getColorType())
                .append(player.getName() != null ? player.getName() : player.getCharacterType().getName());

        if (player.getCharacterType().getCliShortcut() != null) {
            intro.append(" (").append(player.getCharacterType().getCliShortcut()).append("): ");
        } else {
            intro.append(": ");
        }

        out.println(intro + RESET + statement);
    }

    /**
     * Write welcome on CLI to greet new Player.
     */
    public static void writeWelcome() {
        out.println(BOLD + "WELCOME IN " + UNDERLINE + "Captain Planet and the Planeteers" + RESET + " CLI game!");
    }

    public static void writeError(String message) {
        out.println(ColorType.RED + BOLD + "ERROR: " + PRIMARY + ColorType.RED + message + RESET);
    }

}

package pl.suszczynski.planeteers.utility;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.StreamUtils;
import pl.suszczynski.planeteers.Actions;
import pl.suszczynski.planeteers.ConsoleCommandType;
import pl.suszczynski.planeteers.data.Characterable;
import pl.suszczynski.planeteers.data.ColorType;
import pl.suszczynski.planeteers.data.GameState;
import pl.suszczynski.planeteers.data.player.Player;
import pl.suszczynski.planeteers.exception.ConsoleMessagesException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    private static final String RESOURCE_NAME = "ConsoleMessages";

    private static final List<String> CONFIRMATIONS = new ArrayList<>(Arrays.asList("Y", "N"));

    private static ConsoleUtil instance;
    private static ResourceBundle resourceBundle;

    /**
     * Use properties resource: ConsoleMessages.properties
     * @throws ConsoleMessagesException
     */
    private ConsoleUtil() throws ConsoleMessagesException {

        try {
            resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);

        } catch (MissingResourceException e) {
            LOGGER.error(e);
            throw new ConsoleMessagesException("ResourceBundle '" + RESOURCE_NAME + "' not found!", e);
        }
    }

    private static ConsoleUtil getInstance() throws ConsoleMessagesException {

        if (instance == null) {
            instance = new ConsoleUtil();
        }

        return instance;
    }

    /**
     * Gaia is a guide and narrator in a game.
     *
     * @param statement
     */
    public static void writeGaia(String statement) {
        out.println("\n" + ColorType.WHITE + BOLD + "Gaia: " + RESET + statement);
    }

    /**
     * This method write directly on CLI what Player wants to say.
     *
     * @param character - can be good {@link Player} or bad {@link pl.suszczynski.planeteers.data.enemy.Enemy}
     * @param statement - sentence which Player wants to say
     */
    public static void write(Characterable character, String statement) {
        StringBuilder intro = new StringBuilder();
        intro.append(character.getCharacterType().getColorType())
                .append(character.getName())
                .append(" (").append(character.getCharacterType().getCliShortcut()).append("): ");

        out.println(intro + RESET + statement);
    }

    /**
     * Write welcome on CLI to greet new Player.
     */
    public static void writeWelcome() throws ConsoleMessagesException {
        out.println(BOLD + "WELCOME IN " + UNDERLINE + getInstance().resourceBundle.getString("gameName") + RESET + " CLI game!\n");
    }

    public static void writeError(String message) {
        out.println(ColorType.RED + BOLD + "ERROR: " + PRIMARY + ColorType.RED + message + RESET);
    }

    /**
     * Read console commands from user. Method run recursively till it gets a proper command.
     *
     * @return
     */
    public static void readCommand(GameState gameState) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter command: ");

        try {
            ConsoleCommandType commandType = ConsoleCommandType.find(reader.readLine());

            if (commandType == null) {
                writeError("Command unknown :( Try again.");
                readCommand(gameState);

            } else {
                LOGGER.info("Recognized console command: " + commandType);

                switch (commandType) {
                    case DISPLAY_RANKING_PLAYERS:
                        break;
                    case DISPLAY_RANKING_ENEMIES:
                        break;
                    case DISPLAY_INFO_PLAYER:
                        break;
                    case DISPLAY_INFO_ENEMY:
                        break;
                    case DISPLAY_MAP:
                        break;
                    case GAME_LOAD:
                        break;
                    case GAME_NEW:
                        break;
                    case GAME_SAVE:
                        break;
                    case GAME_EXIT:
                        Actions.exit(gameState);
                        break;
                    case HELP:
                        break;
                    default:
                        readCommand(gameState);
                }
            }

        } catch (IOException e) {
            LOGGER.info("Problem with reading command!", e);
            writeError("Command could not be read :( Try again.");
            readCommand(gameState);
        }
    }

    /**
     * Read console Yes/No from user. Method run recursively till it gets a proper value.
     *
     * @return : true - when confirm YES, false / otherwise.
     */
    public static boolean readYN() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Y - yes, N - no: ");

        try {
            String confirmation = StringUtils.upperCase(reader.readLine());

            if (StringUtils.isNotBlank(confirmation) && CONFIRMATIONS.contains(confirmation)) {
                return "Y".equals(confirmation);

            } else {
                writeError("Uncorrect value :( Try again.");
                return readYN();
            }

        } catch (IOException e) {
            LOGGER.info("Problem with reading command!", e);
            writeError("Command could not be read :( Try again.");
            return readYN();
        }
    }

}

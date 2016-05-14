package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.DifficultyLevelType;
import pl.suszczynski.planeteers.data.Player;
import pl.suszczynski.planeteers.data.PositiveCharacterType;
import pl.suszczynski.planeteers.exception.PlayersDefaultValuesException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by daniel on 14.05.16.
 */
public class PlayerUtil {

    private static final Logger LOGGER = Logger.getLogger(PlayerUtil.class);
    private static final String RESOURCE_NAME = "PlayersDefaultValues";

    private static PlayerUtil instance;
    private static ResourceBundle resourceBundle;

    /**
     * Use properties resource: PlayersDefaultValues.properties
     * @throws PlayersDefaultValuesException
     */
    private PlayerUtil() throws PlayersDefaultValuesException {

        try {
            resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);

        } catch (MissingResourceException e) {
            LOGGER.error(e);
            throw new PlayersDefaultValuesException("ResourceBundle '" + RESOURCE_NAME + "' not found!", e);
        }
    }

    private static PlayerUtil getInstance() throws PlayersDefaultValuesException {

        if (instance == null) {
            instance = new PlayerUtil();
        }

        return instance;
    }

    /**
     * Creates a {@link Player} and configure.
     *
     * @param name - specific name for main Player
     * @param characterType
     * @param difficultyLevelType
     * @return
     */
    public static Player create(String name, PositiveCharacterType characterType, DifficultyLevelType difficultyLevelType) throws PlayersDefaultValuesException {
        Player player = new Player(name, characterType);

        getInstance().configure(player, difficultyLevelType);

        return player;
    }

    /**
     * Creates a {@link Player} and configure with default name.
     *
     * @param characterType
     * @param difficultyLevelType
     * @return
     */
    public static Player create(PositiveCharacterType characterType, DifficultyLevelType difficultyLevelType) throws PlayersDefaultValuesException {
        return create(null, characterType, difficultyLevelType);
    }

    /**
     * Fill-out missing information in Player object.
     * Those information are read from property file based on chosen difficulty level.
     *
     * @param player
     * @param difficultyLevelType
     */
    private void configure(Player player, DifficultyLevelType difficultyLevelType) throws PlayersDefaultValuesException {

        String resourceStrengthKey = "character.positive." + player.getCharacterType() + ".strength";
        try {
            String strength = resourceBundle.getString(resourceStrengthKey);
            player.setStrength(Integer.parseInt(strength));

        } catch (MissingResourceException e) {
            LOGGER.error("Resource key: '" + resourceStrengthKey + "' not found!", e);
            throw new PlayersDefaultValuesException("Resource key not found!");

        } catch (NumberFormatException e) {
            LOGGER.error(e);
            throw new PlayersDefaultValuesException("Resource format invalid!");
        }

        String resourceLifeKey = "character.positive." + player.getCharacterType() + ".life.difficulty." + difficultyLevelType;
        try {
            String life = resourceBundle.getString(resourceLifeKey);
            player.setLife(Integer.parseInt(life));

        } catch (MissingResourceException e) {
            LOGGER.error("Resource key: '" + resourceLifeKey + "' not found!", e);
            throw new PlayersDefaultValuesException("Resource key not found!");

        } catch (NumberFormatException e) {
            LOGGER.error(e);
            throw new PlayersDefaultValuesException("Resource format invalid!");
        }
    }

}

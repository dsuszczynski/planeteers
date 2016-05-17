package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.character.positive.Player;
import pl.suszczynski.planeteers.data.character.positive.PositiveCharacter;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.data.game.GameDifficultyType;
import pl.suszczynski.planeteers.exception.PositiveCharacterDefaultValuesException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by daniel on 14.05.16.
 */
public class PositiveCharacterUtils {

    private static final Logger LOGGER = Logger.getLogger(PositiveCharacterUtils.class);
    private static final String RESOURCE_NAME = "PlayersDefaultValues";

    private static PositiveCharacterUtils instance;
    private static ResourceBundle resourceBundle;

    /**
     * Use properties resource: PlayersDefaultValues.properties
     * @throws PositiveCharacterDefaultValuesException
     */
    protected PositiveCharacterUtils() throws PositiveCharacterDefaultValuesException {

        try {
            resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);

        } catch (MissingResourceException e) {
            LOGGER.error(e);
            throw new PositiveCharacterDefaultValuesException("ResourceBundle '" + RESOURCE_NAME + "' not found!", e);
        }
    }

    private static PositiveCharacterUtils getInstance() throws PositiveCharacterDefaultValuesException {

        if (instance == null) {
            instance = new PositiveCharacterUtils();
        }

        return instance;
    }

    /**
     * Fill-out missing information in PositiveCharacter object.
     * Those information are readCommand from property file based on chosen difficulty level.
     *
     * @param character
     * @param gameDifficultyType
     */
    public static void configure(PositiveCharacter character, GameDifficultyType gameDifficultyType) throws PositiveCharacterDefaultValuesException {

        String resourceLifeKey = "character.positive." + character.getCharacterType() + ".life.difficulty." + gameDifficultyType;

        try {
            String life = PositiveCharacterUtils.getInstance().resourceBundle.getString(resourceLifeKey);
            character.setLife(Integer.parseInt(life));

        } catch (MissingResourceException e) {
            LOGGER.error("Resource key: '" + resourceLifeKey + "' not found!", e);
            throw new PositiveCharacterDefaultValuesException("Resource key not found!");

        } catch (NumberFormatException e) {
            LOGGER.error(e);
            throw new PositiveCharacterDefaultValuesException("Resource format invalid!");
        }
    }

}

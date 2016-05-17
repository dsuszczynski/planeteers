package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.character.positive.*;
import pl.suszczynski.planeteers.data.game.GameDifficultyType;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.exception.PositiveCharacterDefaultValuesException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by daniel on 14.05.16.
 */
public class GameUtils {

    private static final Logger LOGGER = Logger.getLogger(GameUtils.class);

    protected GameUtils() {
    }

    public static Game configure(Game game, String playerName, PositiveCharacterType playerType, GameDifficultyType gameDifficultyType) throws PositiveCharacterDefaultValuesException {
        game.setDifficultyType(gameDifficultyType);

        // configure PositiveCharacters
        {
            // reset PositiveCharacters
            game.setPositiveCharacters(new LinkedHashMap<>());

            // configure positive characters - Player, Planeteers, and Captain Planet
            for (PositiveCharacterType characterType : PositiveCharacterType.values()) {
                PositiveCharacter positiveCharacter;

                if (characterType.equals(playerType)) {
                    positiveCharacter = new Player(playerName, characterType);
                } else if (characterType.equals(PositiveCharacterType.CAPTAIN_PLANET)) {
                    positiveCharacter = new CaptainPlanet();
                } else {
                    positiveCharacter = new Planeteer(characterType);
                }

                PositiveCharacterUtils.configure(positiveCharacter, gameDifficultyType);

                game.getPositiveCharacters().put(characterType, positiveCharacter);
            }

            // configure observers for planeteers
            for (Map.Entry<PositiveCharacterType, Planeteer> entry : game.getPlaneteers().entrySet()) {
                entry.getValue().addObserver(game.getCaptainPlanet());
                entry.getValue().addObserver(game);
            }

        }

        return game;
    }

}

package pl.suszczynski.planeteers.utility;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.DifficultyLevelType;
import pl.suszczynski.planeteers.data.GameState;
import pl.suszczynski.planeteers.data.Player;
import pl.suszczynski.planeteers.data.PositiveCharacterType;
import pl.suszczynski.planeteers.exception.PlayersDefaultValuesException;

/**
 * Created by daniel on 14.05.16.
 */
public class GameStateUtil {

    private static final Logger LOGGER = Logger.getLogger(GameStateUtil.class);

    private GameStateUtil() {
    }

    public static GameState create(String mainPlayerName, PositiveCharacterType mainCharacterType, DifficultyLevelType difficultyLevelType) throws PlayersDefaultValuesException {
        GameState gameState = new GameState();
        gameState.setDifficultyLevelType(difficultyLevelType);

        for (PositiveCharacterType characterType : PositiveCharacterType.values()) {
            if (characterType.equals(mainCharacterType)) {
                gameState.getPlayers().add(
                        PlayerUtil.create(mainPlayerName, characterType, difficultyLevelType)
                );
            } else {
                gameState.getPlayers().add(
                        PlayerUtil.create(characterType, difficultyLevelType)
                );
            }
        }

        return gameState;
    }

}

package pl.suszczynski.planeteers;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import pl.suszczynski.planeteers.data.DifficultyLevelType;
import pl.suszczynski.planeteers.data.GameState;
import pl.suszczynski.planeteers.data.PositiveCharacterType;
import pl.suszczynski.planeteers.data.Player;
import pl.suszczynski.planeteers.exception.PlayersDefaultValuesException;
import pl.suszczynski.planeteers.utility.ConsoleUtil;
import pl.suszczynski.planeteers.utility.GameStateUtil;
import pl.suszczynski.planeteers.utility.PlayerUtil;

/**
 * Created by daniel on 13.05.16.
 */
public class GameRunner {

    public static void main(String[] args) {
        GameState gameState = null;

        ConsoleUtil.writeWelcome();

        try {

            try {
                gameState = GameStateUtil.create("Hania", PositiveCharacterType.KWAME, DifficultyLevelType.MEDIUM);
            } catch (PlayersDefaultValuesException e) {
                ConsoleUtil.writeError(e.getMessage());
            }

            /* Gaia say hello :) */
            ConsoleUtil.writeGaia("Hello " + gameState.getMainPlayer().getName() + "! I am your guide :)");

            for (Player player : gameState.getPlayers()) {

                if (PositiveCharacterType.CAPTAIN_PLANET.equals(player.getCharacterType())) {
                    ConsoleUtil.write(player, "Hey " + gameState.getMainPlayer().getName()
                            + "! By your powers combined, I am Captain Planet! Always ready to save you :)");

                } else if (player != gameState.getMainPlayer()) {
                    ConsoleUtil.write(player, "Hi " + gameState.getMainPlayer().getName()
                            + "! My power is: " + player.getCharacterType().getPowerType());
                }
            }

        } catch (Exception e) {
            ConsoleUtil.writeError("Something went wrong, sorry for inconvenience!");
        }
    }

}

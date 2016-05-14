package pl.suszczynski.planeteers;

import pl.suszczynski.planeteers.data.DifficultyLevelType;
import pl.suszczynski.planeteers.data.GameState;
import pl.suszczynski.planeteers.data.player.PositiveCharacterType;
import pl.suszczynski.planeteers.data.player.Player;
import pl.suszczynski.planeteers.exception.ConsoleMessagesException;
import pl.suszczynski.planeteers.exception.PlayersDefaultValuesException;
import pl.suszczynski.planeteers.utility.ConsoleUtil;
import pl.suszczynski.planeteers.utility.GameStateUtil;

import java.util.Map;

/**
 * Created by daniel on 13.05.16.
 */
public class GameRunner {

    public static void main(String[] args) {
        GameState gameState = null;

        try {
            ConsoleUtil.writeWelcome();

            ConsoleUtil.readCommand(gameState);

            try {
                gameState = GameStateUtil.create("Hania", PositiveCharacterType.KWAME, DifficultyLevelType.MEDIUM);
            } catch (PlayersDefaultValuesException e) {
                ConsoleUtil.writeError(e.getMessage());
            }

            /* Gaia say hello :) */
            ConsoleUtil.writeGaia("Hello " + gameState.getMainPlayer().getName() + "! I am your guide :)\n");

            for (Map.Entry<String, Player> entry : gameState.getPlayers().entrySet()) {

                if (PositiveCharacterType.CAPTAIN_PLANET.equals(entry.getValue().getCharacterType())) {
                    ConsoleUtil.write(entry.getValue(), "Hey " + gameState.getMainPlayer().getName()
                            + "! By your powers combined, I am Captain Planet! Always ready to save you :)");

                } else if (entry.getValue() != gameState.getMainPlayer()) {
                    ConsoleUtil.write(entry.getValue(), "Hi " + gameState.getMainPlayer().getName()
                            + "! My power is: " + entry.getValue().getCharacterType().getPowerType());
                }
            }

            ConsoleUtil.writeGaia("As you know your power is: " + gameState.getMainPlayer().getCharacterType().getPowerType());
            ConsoleUtil.writeGaia("Let's start the game. Good luck!");

        } catch (ConsoleMessagesException e) {
            ConsoleUtil.writeError(e.getMessage());

        } catch (Exception e) {
            ConsoleUtil.writeError("Something went wrong, sorry for inconvenience!");
        }
    }

}

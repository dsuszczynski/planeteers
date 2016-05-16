package pl.suszczynski.planeteers;

import pl.suszczynski.planeteers.data.character.positive.PositiveCharacter;
import pl.suszczynski.planeteers.data.game.GameDifficultyType;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.data.character.positive.PositiveCharacterType;
import pl.suszczynski.planeteers.exception.ConsoleMessagesException;
import pl.suszczynski.planeteers.exception.PositiveCharacterDefaultValuesException;
import pl.suszczynski.planeteers.helper.ConsoleHelper;
import pl.suszczynski.planeteers.utility.GameUtils;

import java.util.Map;

/**
 * Created by daniel on 13.05.16.
 */
public class GameRunner {

    public static void main(String[] args) {
        Game game = null;

        try {
            ConsoleHelper.writeWelcome();

            ConsoleHelper.readCommand(game);

            try {
                game = new Game();
                game = GameUtils.configure(game, "Hania", PositiveCharacterType.KWAME, GameDifficultyType.MEDIUM);
            } catch (PositiveCharacterDefaultValuesException e) {
                ConsoleHelper.writeError(e.getMessage());
            }

            /* Gaia say hello :) */
            ConsoleHelper.writeGaia("Hello " + game.getPlayer().getName() + "! I am your guide :)\n");

            for (Map.Entry<PositiveCharacterType, PositiveCharacter> entry : game.getPositiveCharacters().entrySet()) {

                if (PositiveCharacterType.CAPTAIN_PLANET.equals(entry.getValue().getCharacterType())) {
                    ConsoleHelper.write(entry.getValue(), "Hey " + game.getPlayer().getName()
                            + "! By your powers combined, I am Captain Planet! Always ready to save you :)");

                } else if (entry.getValue() != game.getPlayer()) {
                    ConsoleHelper.write(entry.getValue(), "Hi " + game.getPlayer().getName()
                            + "! My power is: " + entry.getValue().getCharacterType().getPowerType());
                }
            }

            ConsoleHelper.writeGaia("As you know your power is: " + game.getPlayer().getCharacterType().getPowerType());
            ConsoleHelper.writeGaia("Let's start the game. Good luck!");

        } catch (ConsoleMessagesException e) {
            ConsoleHelper.writeError(e.getMessage());

        } catch (Exception e) {
            ConsoleHelper.writeError("Something went wrong, sorry for inconvenience!");
        }
    }

}

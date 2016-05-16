package pl.suszczynski.planeteers;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.character.negative.NegativeCharacter;
import pl.suszczynski.planeteers.data.character.positive.*;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.exception.GameOverException;

import java.util.Map;

/**
 * Fight class describing fight rules and states.
 *
 * Created by daniel on 16.05.16.
 */
public class Fight {

    private static final Logger LOGGER = Logger.getLogger(Fight.class);
    private static final int LIFE_DECREMENTATION_PER_CHARACTER = 1;

    private Game game;

    public Fight(Game game) {
        this.game = game;
    }

    /**
     * Decreasing {@link PositiveCharacter} life value.
     * Rules:
     * - {@link Planeteer} when life <= 0 than {@link Planeteer} is dead and removed from Game.
     * - {@link Player} when life <= 0 than Game is OVER!
     * - {@link CaptainPlanet} live is a SUM of all {@link Planeteer}s lifes.
     *      When {@link CaptainPlanet} gets hit life of each {@link Planeteer}s can go below 1,
     *      the exception is {@link Player} (when {@link Player}s life gets below 1 Game is OVER).
     *
     * @param character
     * @param units
     */
    public Integer hitPositiveCharacter(PositiveCharacter character, Integer units) throws GameOverException {

        character.setLife(character.getLife() - units);

        if (character instanceof Player) {

            if (character.getLife() <= 0) {
                throw new GameOverException();
            }

        } else if (character instanceof CaptainPlanet) {

            int unitsLeft = units;

            for (Map.Entry<PositiveCharacterType, Planeteer> planeteerEntry : game.getPlaneteers().entrySet()) {
                Planeteer planeteer = planeteerEntry.getValue();
                planeteer.setLife(planeteer.getLife() - LIFE_DECREMENTATION_PER_CHARACTER);
                unitsLeft--;
            }

            // hit Player as last one to increase chance to survive fight
            if (unitsLeft > 0) {
                hitPositiveCharacter(game.getPlayer(), LIFE_DECREMENTATION_PER_CHARACTER);
                unitsLeft--;
            }

            // hit Captain Planet recursively as next round
            if (unitsLeft > 0) {
                hitPositiveCharacter(character, unitsLeft);
            }
        }

        return character.getLife();
    }

    /**
     * Simple decrease of {@link NegativeCharacter} life value.
     *
     * @param character
     * @param units
     * @return
     */
    public Integer hitNegativeCharacter(NegativeCharacter character, Integer units) {

        character.setLife(character.getLife() - units);

        return character.getLife();
    }
}

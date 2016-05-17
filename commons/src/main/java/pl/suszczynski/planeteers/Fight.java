package pl.suszczynski.planeteers;

import org.apache.log4j.Logger;
import pl.suszczynski.planeteers.data.character.negative.NegativeCharacter;
import pl.suszczynski.planeteers.data.character.positive.*;
import pl.suszczynski.planeteers.data.game.Game;
import pl.suszczynski.planeteers.exception.CaptainPlanetDefeatedException;
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
     * - {@link CaptainPlanet} live is a SUM of all {@link Planeteer}s lifes. It works as a {@link java.util.Observer}
     *      When {@link CaptainPlanet} gets hit life of each {@link Planeteer}s can not go below 1,
     *      if {@link Planeteer}s lifes can not be reduced anymore, {@link CaptainPlanet} disappears and {@link Planeteer}s
     *          needs to fight without him.
     *
     * @param positiveCharacter
     * @param units
     */
    public Integer hitPositiveCharacter(PositiveCharacter positiveCharacter, NegativeCharacter negativeCharacter, Integer units)
            throws GameOverException, CaptainPlanetDefeatedException {

        if (positiveCharacter instanceof Player) {
            ((Player) positiveCharacter).gotHit(units);

            if (positiveCharacter.getLife() <= 0) {
                throw new GameOverException();
            }

        } else if (positiveCharacter instanceof CaptainPlanet) { // is an Observer
            int unitsLeft = units;

            int numberOfPlaneteers;
            do {
                Map<PositiveCharacterType, Planeteer> planeteers = game.getPlaneteers();
                numberOfPlaneteers = planeteers.size() + 1;

                // when any of Planeteers got hit the Captain Planet life gets reduce as well
                for (Map.Entry<PositiveCharacterType, Planeteer> planeteerEntry : game.getPlaneteers().entrySet()) {
                    Planeteer planeteer = planeteerEntry.getValue();

                    if (planeteer.getLife() > 1) {
                        planeteer.gotHit(LIFE_DECREMENTATION_PER_CHARACTER);
                        unitsLeft--;
                    }
                }

            } while (unitsLeft > 0 && positiveCharacter.getLife() > numberOfPlaneteers && game.getPlayer().getLife() > 1);

            if (unitsLeft > 0) {
                throw new CaptainPlanetDefeatedException();
            }

        } else {
            ((Planeteer) positiveCharacter).gotHit(units);
        }

        return positiveCharacter.getLife();
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

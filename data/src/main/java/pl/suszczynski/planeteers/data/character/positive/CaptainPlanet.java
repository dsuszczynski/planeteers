package pl.suszczynski.planeteers.data.character.positive;

import pl.suszczynski.planeteers.data.character.PowerType;
import pl.suszczynski.planeteers.data.game.Game;

import java.util.*;

/**
 * Created by daniel on 16.05.16.
 */
public class CaptainPlanet extends PositiveCharacter implements Observer {

    private static final int POWER_INCREMENT = 2;

    Map<PositiveCharacterType, Planeteer> planeteers = new LinkedHashMap<>();

    public CaptainPlanet() {
        super(PositiveCharacterType.CAPTAIN_PLANET);
    }

    /**
     * Captain Planet contain strengths of all Planeteers.
     * @param powerType
     * @return
     */
    public Integer getStrength(PowerType powerType) {
        Integer strength = 0;

        for (Map.Entry<PositiveCharacterType, Planeteer> entry : planeteers.entrySet()) {

            // special (chosen) power's strength is always incremented
            if (powerType != null && powerType.equals(entry.getValue().getCharacterType().getPowerType())) {
                strength += (entry.getValue().getStrength() * POWER_INCREMENT);
            } else {
                strength += entry.getValue().getStrength();
            }
        }

        return strength;
    }

    @Override
    public Integer getLife() {
        Integer life = 0;

        for (Map.Entry<PositiveCharacterType, Planeteer> entry : planeteers.entrySet()) {
            life += entry.getValue().getLife();
        }

        return life;
    }

    /**
     *
     * @param o {@link Planeteer}
     * @param force {@link Integer}
     */
    @Override
    public void update(Observable o, Object force) {
        if (o instanceof Planeteer && force instanceof Integer) {
            Planeteer planeteer = (Planeteer) o;

            planeteers.remove(planeteer.getCharacterType());

            if (planeteer.getLife() > 0) {
                planeteers.put(planeteer.getCharacterType(), planeteer);
            }
        }
    }

    public Map<PositiveCharacterType, Planeteer> getPlaneteers() {
        return planeteers;
    }

    public void setPlaneteers(Map<PositiveCharacterType, Planeteer> planeteers) {
        this.planeteers = planeteers;
    }
}

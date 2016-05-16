package pl.suszczynski.planeteers.data.character.positive;

import pl.suszczynski.planeteers.data.character.CharacterType;
import pl.suszczynski.planeteers.data.character.PowerType;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by daniel on 16.05.16.
 */
public class CaptainPlanet extends PositiveCharacter {

    private Map<PowerType, Integer> strenghts = new HashMap<>();

    public CaptainPlanet() {
        super(PositiveCharacterType.CAPTAIN_PLANET);
    }

    /**
     * Captain Planet contain strengths of all Planeteers.
     * @param powerType
     * @return
     */
    public Integer getStrength(PowerType powerType) {
        return strenghts.get(powerType);
    }
}

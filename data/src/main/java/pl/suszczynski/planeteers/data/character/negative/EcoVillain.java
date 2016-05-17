package pl.suszczynski.planeteers.data.character.negative;

import pl.suszczynski.planeteers.data.character.positive.PositiveCharacter;

/**
 * Created by daniel on 16.05.16.
 */
public class EcoVillain extends NegativeCharacter {

    public EcoVillain(NegativeCharacterType characterType) {
        super(characterType);
    }

    @Override
    public Integer gotHit(Integer force, PositiveCharacter character) {
        return null;
    }
}

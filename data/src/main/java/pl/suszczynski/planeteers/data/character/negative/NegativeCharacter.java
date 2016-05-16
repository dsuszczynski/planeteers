package pl.suszczynski.planeteers.data.character.negative;

import pl.suszczynski.planeteers.data.character.Characterable;
import pl.suszczynski.planeteers.data.character.ColorType;

import java.io.Serializable;

/**
 * Created by daniel on 14.05.16.
 */
public abstract class NegativeCharacter implements Serializable, Characterable {

    private NegativeCharacterType characterType;
    private Integer strength;
    private Integer life;

    public NegativeCharacter(NegativeCharacterType characterType) {
        this.characterType = characterType;
        this.strength = characterType.getStrength();
        this.life = characterType.getLife();
    }

    @Override
    public String getName() {
        return characterType.getName();
    }

    @Override
    public ColorType getColorType() {
        return characterType.getColorType();
    }

    @Override
    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    @Override
    public NegativeCharacterType getCharacterType() {
        return characterType;
    }

    public Integer getStrength() {
        return strength;
    }
}

package pl.suszczynski.planeteers.data.character.positive;

import pl.suszczynski.planeteers.data.character.Characterable;
import pl.suszczynski.planeteers.data.character.ColorType;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by daniel on 14.05.16.
 */
public abstract class PositiveCharacter extends Observable implements Serializable, Characterable {

    private PositiveCharacterType characterType;
    private Integer strength;
    private Integer life;

    protected PositiveCharacter(PositiveCharacterType characterType) {
        this.characterType = characterType;
        this.strength = characterType.getStrength();
    }

    PositiveCharacter() {}

    @Override
    public String getName() {
        return characterType.getName();
    }

    @Override
    public ColorType getColorType() {
        return characterType.getColorType();
    }

    @Override
    public PositiveCharacterType getCharacterType() {
        return characterType;
    }

    void setCharacterType(PositiveCharacterType characterType) {
        this.characterType = characterType;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }
}

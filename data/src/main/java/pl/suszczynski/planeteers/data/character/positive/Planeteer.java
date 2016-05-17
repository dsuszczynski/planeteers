package pl.suszczynski.planeteers.data.character.positive;

/**
 * Created by daniel on 16.05.16.
 */
public class Planeteer extends PositiveCharacter {

    public Planeteer(PositiveCharacterType characterType) {
        super(characterType);
    }

    Planeteer() {}

    /**
     * Every {@link pl.suszczynski.planeteers.data.character.positive.Planeteer} can got hit.
     * Depends of character who got hit and hit the implementation is different.
     *
     * @param force
     * @return
     */
    public Integer gotHit(Integer force) {
        setLife(getLife() - force);

        setChanged();
        notifyObservers(force);

        return getLife();
    }
}

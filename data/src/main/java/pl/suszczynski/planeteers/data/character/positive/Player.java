package pl.suszczynski.planeteers.data.character.positive;

/**
 * Created by daniel on 14.05.16.
 */
public class Player extends Planeteer {

    private String name;

    public Player(String name, PositiveCharacterType characterType) {
        super(characterType);

        this.name = name;
    }

    Player() {}

    @Override
    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

package pl.suszczynski.planeteers.data.character.positive;

import pl.suszczynski.planeteers.data.DataBuilder;

/**
 * Created by daniel on 16.05.16.
 */
public class PlayerDataBuilder extends DataBuilder<Player> {

    @Override
    protected Player createData() {
        return new Player();
    }

    public static PlayerDataBuilder builder() {
        return new PlayerDataBuilder();
    }

    public PlayerDataBuilder withData() {
        data = PlayerDataBuilder.builder().withData("Hanna", 3, 1, PositiveCharacterType.LINKA).build();

        return this;
    }

    public PlayerDataBuilder withData(String name, Integer life, Integer strength, PositiveCharacterType characterType) {
        Player player = new Player(name, characterType);
        player.setLife(life);
        player.setStrength(strength);

        return this;
    }

}

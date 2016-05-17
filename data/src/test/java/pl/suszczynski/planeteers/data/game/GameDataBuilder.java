package pl.suszczynski.planeteers.data.game;

import pl.suszczynski.planeteers.data.DataBuilder;
import pl.suszczynski.planeteers.data.character.positive.Player;
import pl.suszczynski.planeteers.data.character.positive.PositiveCharacter;
import pl.suszczynski.planeteers.data.character.positive.PositiveCharacterType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by daniel on 16.05.16.
 */
public class GameDataBuilder extends DataBuilder<Game> {

    @Override
    protected Game createData() {
        return new Game();
    }

    public static GameDataBuilder builder() {
        return new GameDataBuilder();
    }

    public GameDataBuilder withData() {
        data = GameDataBuilder.builder()
                .withData(1, 1, GameDifficultyType.EASY, true)
                .build();

        return this;
    }

    public GameDataBuilder withData(Integer level, Integer mission, GameDifficultyType difficultyType, boolean saved) {
        data.setLevel(level);
        data.setMission(mission);
        data.setDifficultyType(difficultyType);
        data.setSaved(saved);

        Map<PositiveCharacterType, PositiveCharacter> positiveCharacters = new LinkedHashMap<>();

        Player player = new Player("Hanna", PositiveCharacterType.LINKA);
        player.setLife();
        positiveCharacters.put(player.getCharacterType(), player);

        data.setPositiveCharacters(positiveCharacters);

        return this;
    }

}

package pl.suszczynski.planeteers;

import pl.suszczynski.planeteers.data.character.negative.EcoVillain;
import pl.suszczynski.planeteers.data.character.negative.NegativeCharacter;
import pl.suszczynski.planeteers.data.character.negative.NegativeCharacterType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Negative characters are collected in factory.
 * Create is initiated by first request.
 * Each character can be create only once, dead characters are not available again.
 *
 * Created by daniel on 16.05.16.
 */
public class NegativeCharacterFactory {

    private Map<NegativeCharacterType, NegativeCharacter> negativeCharacters = new LinkedHashMap<>();

    public NegativeCharacter getCharacter(NegativeCharacterType characterType) {

        NegativeCharacter character = negativeCharacters.get(characterType);

        if (character == null) {

            // create missing character
            character = new EcoVillain(characterType);
            negativeCharacters.put(characterType, character);

        } else if (character.getLife() == 0) {

            // exclude dead characters
            character =null;
        }

        return character;
    }

}

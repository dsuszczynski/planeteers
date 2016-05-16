package pl.suszczynski.planeteers.data.game;

import pl.suszczynski.planeteers.data.DataBuilder;

/**
 * Created by daniel on 16.05.16.
 */
public class GameDataBuilder extends DataBuilder {

    @Override
    protected Object createData() {
        return new Game();
    }
}

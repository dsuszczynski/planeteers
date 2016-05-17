package pl.suszczynski.planeteers.data.game;

import org.junit.Assert;
import org.junit.Test;

/**
 * @see Game
 *
 * Created by daniel on 16.05.16.
 */
public class GameTest {

    @Test
    public void getPlaneteers() throws Exception {
        Game game = GameDataBuilder.builder().withData().build();

        Assert.assertEquals(1, game.getPlaneteers().size());
    }

    @Test
    public void getPlayer() throws Exception {
        Game game = GameDataBuilder.builder().withData().build();

        Assert.assertNotNull(game.getPlayer());
    }

    @Test
    public void getCaptainPlanet() throws Exception {
        Game game = GameDataBuilder.builder().withData().build();

        Assert.assertNull(game.getCaptainPlanet());
    }

}
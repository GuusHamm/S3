package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.menu.GameScreen;

/**
 * @author Teun
 */
public class BackgroundRenderer {

    private GameScreen gameScreen;
    private Texture texture;

    public BackgroundRenderer(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        texture = new Texture("background.png");
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(texture, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
    }

}

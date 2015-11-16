package game;

import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;

/**
 * Created by guushamm on 9-11-15.
 */
public class GameTexture {
	private HashMap<String,Texture> textures;

	/**
	 * Define all gametextures to the game so they can be used.
	 * Default textures will be used
	 */
	public GameTexture(){
		textures = new HashMap<>();
		textures.put("playerTexture",new Texture("player.png"));
		textures.put("bulletTexture",new Texture("bullet.png"));
		textures.put("wallTexture",new Texture("wall.png"));
		textures.put("healthPickupTexture",new Texture("healthPickup.png"));
		textures.put("damagePickupTexture",new Texture("damagePickup.png"));
		textures.put("speedPickupTexture",new Texture("speedPickup.png"));
		textures.put("fireRatePickupTexture",new Texture("fireRatePickup.png"));
		textures.put("ammoPickupTexture",new Texture("bullet.png"));
		textures.put("aiTexture",new Texture("ai.png"));
		textures.put("bossTexture",new Texture("boss.png"));
	}

	/**
	 * Define all gametextures to the game so they can be used.
	 * @param texture : Enum of all textures that will be used
	 * @return The textures for the game
	 */
	public Texture getTexture(texturesEnum texture) {
		return textures.get(texture.toString());
	}
	public enum texturesEnum{
		playerTexture,
		bulletTexture,
		wallTexture,
		healthPickupTexture,
		damagePickupTexture,
		speedPickupTexture,
		fireRatePickupTexture,
		ammoPickupTexture,
		aiTexture,
		bossTexture
	}
}

package callofcactus;

import callofcactus.entities.HumanCharacter;
import callofcactus.role.Role;
import callofcactus.role.Soldier;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import testClasses.GameMockup;

/**
 * Created by xubuntu on 12-10-15.
 */
public class HumanCharacterTest extends TestCase {
	HumanCharacter humanCharacter;


	@Before
	public void setUp() throws Exception {
		Game game = new GameMockup();

		Vector2 location = new Vector2(1, 1);
		String name = "testplayer";
		Role role = new Soldier();
		Texture playerTexture = null;

		humanCharacter = new HumanCharacter(game, location, name, role, playerTexture, 64, 64);


	}

	@Test
	public void testGetScore() throws Exception {
		assertEquals(0, humanCharacter.getScore());

	}

	@Test
	public void testTakeDamage() throws Exception {
		int startHealth = humanCharacter.getHealth();

		humanCharacter.takeDamage(startHealth - 1);

		assertEquals(startHealth - (startHealth - 1), humanCharacter.getHealth());
		humanCharacter.takeDamage(startHealth - 1);
	}

	@Test
	public void testMove() throws Exception {
		Vector2 location = new Vector2(1, 1);

		humanCharacter.move(location);

		assertEquals(location, humanCharacter.getLocation());

		location = new Vector2(-1, 1);
		Vector2 properLocation = new Vector2(0, 1);

		humanCharacter.move(location);

		assertEquals(properLocation, humanCharacter.getLocation());

		location = new Vector2(1, -1);
		properLocation = new Vector2(1, 0);

		humanCharacter.move(location);

		assertEquals(properLocation, humanCharacter.getLocation());

		location = new Vector2(1, -1);
		properLocation = new Vector2(1, 0);

		humanCharacter.move(location);

		assertEquals(properLocation, humanCharacter.getLocation());


		location = new Vector2(801, 1);
		properLocation = new Vector2(800, 1);

		humanCharacter.setLocation(properLocation);

		humanCharacter.move(location);

		assertEquals(properLocation, humanCharacter.getLocation());

		location = new Vector2(1, 481);
		properLocation = new Vector2(1, 480);

		humanCharacter.setLocation(properLocation);

		humanCharacter.move(location);

		assertEquals(properLocation, humanCharacter.getLocation());


	}


}
package callofcactus.entities;

import callofcactus.GameTexture;
import callofcactus.IGame;
import callofcactus.multiplayer.Command;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;
import java.io.Serializable;


public abstract class MovingEntity extends Entity implements Serializable {
    protected double baseSpeed = 2;
    protected int damage = 1;
    protected int speed = 2;
    protected double angle;

    /**
     * Makes a new instance of the class MovingEntity
     *
     * @param game          : The callofcactus of which the entity belongs to
     * @param location      : Coordinates of the entity
     * @param spriteHeight  The height of characters sprite
     * @param spriteTexture callofcactus.Texture to use for this AI
     * @param spriteWidth   The width of characters sprite
     */
    protected MovingEntity(IGame game, Vector2 location, GameTexture.texturesEnum spriteTexture, int spriteWidth, int spriteHeight) {
        super(game, location, spriteTexture, spriteWidth, spriteHeight);
    }

    protected MovingEntity() {

    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;

        sendChangeCommand(this,"angle",angle + "", Command.objectEnum.MovingEntity);
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException();
        }
        this.damage = damage;
    }

    /**
     * Moves the entity towards a specific point
     *
     * @param Point : Coordinates of where the object will move to
     */
    public void move(Vector2 Point) {

        Vector2 calculateNewPosition = null;

        calculateNewPosition = getGame().calculateNewPosition(this.location, Point, speed);


        if (calculateNewPosition.x < 0) calculateNewPosition.x = 0;
        if (calculateNewPosition.y < 0) calculateNewPosition.y = 0;
        if (calculateNewPosition.x > Gdx.graphics.getWidth()) calculateNewPosition.x = Gdx.graphics.getWidth();
        if (calculateNewPosition.y > Gdx.graphics.getHeight()) calculateNewPosition.y = Gdx.graphics.getHeight();
        lastLocation = new Vector2(location.x, location.y);
        location = calculateNewPosition;

        sendChangeCommand(this,"location",location.toString(), Command.objectEnum.MovingEntity);
    }

    protected void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        super.writeObject(stream);

    }

    protected void readObject(java.io.ObjectInputStream stream) throws IOException {
        super.readObject(stream);
    }
}
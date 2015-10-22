package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.json.JSONObject;

public class Bullet extends MovingEntity {

    private int damage;
    private Player shooter;
    private double angle;

	/**
	 * create a new instance of bullet
	 * @param shooter : The player who shot the bullet
	 */

	public Bullet(Game game, Vector2 location,Player shooter,Texture spriteTexture,double angle, int spriteWidth,int spriteHeight) {
        // TODO - set the velocity
        super(game, location, spriteTexture, spriteWidth, spriteHeight);


        JSONObject jsonObject = game.getJSON();

        int speed = 10;

        try {
            speed = (int)jsonObject.get("bulletBaseSpeed");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        this.shooter = shooter;
        this.setSpeed((int) Math.round(speed * shooter.getRole().getSpeedMultiplier()));
        this.angle = angle;
    }

    /**
	 * @return the speed of the bullet, this can be different than baseSpeed if you get a speed bonus.
	 */
	public int getSpeed() {
		return (int) Math.round(super.getSpeed() * shooter.getRole().getSpeedMultiplier());
	}

    /**
     * @return the amount of damage the bullet does
     */
    public int getDamage()    {
        return damage;
    }

    public void setDamage(int damage)    {
        if (damage < 0) {
            throw new IllegalArgumentException();
        }
        this.damage = damage;
    }

    public double getAngle() {
        return angle;
    }

    /**
     * @return the player that fired the bullet
     */
    public Player getShooter(){
        return this.shooter;
    }

    /**
     * THis will damage whatever it hits
     * @param e who or what it hit
     */
    public void hit(Entity e)    {
        if(e instanceof HumanCharacter)        {
            ((HumanCharacter)e).takeDamage(damage);
        }
        else if(e instanceof AICharacter)        {
            ((AICharacter)e).takeDamage(damage);
        }
        else if(e instanceof NotMovingEntity)        {
            ((NotMovingEntity)e).takeDamage(damage);
        }
        try {
            if (((HumanCharacter) e).getHealth() <= 0) {
                ((HumanCharacter) this.shooter).addScore(1);
            }
        }catch(ClassCastException exception){exception.printStackTrace();}
    }


    public void move() {
        location = getGame().calculateNewPosition(this.location,getSpeed(),360 -angle);

    }


}
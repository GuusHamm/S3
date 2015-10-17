package game;

import account.Account;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import game.menu.MainMenu;
import game.role.Role;
import game.role.Soldier;
import javafx.geometry.Point2D;


import java.awt.*;
import java.util.ArrayList;

public class Game {

	private MainMenu gameBrowser;
    //sets the pixels per steps that are taken with every calculation in calculateNewPosition
    private int steps = 1;


    private ArrayList<Account> accountsInGame;
	private int gameLevel;
	private boolean isActive;
	private boolean bossModeActive;
	private int maxScore;
	private int maxNumberOfPlayers;
	private ArrayList<NotMovingEntity> notMovingEntities;
    private ArrayList<MovingEntity> movingEntities;
    private HumanCharacter player;

    //Collision fields
    private Intersector intersector;

	/**
	 * Makes a new instance of the class Game
	 */
    public Game(int gameLevel, int maxNumberOfPlayers, boolean bossModeActive, int maxScore) {
        this.gameLevel = gameLevel;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.bossModeActive = bossModeActive;
        this.maxScore = maxScore;
        this.notMovingEntities = new ArrayList<>();
        this. movingEntities = new ArrayList<>();

        // Initialize player
        Point2D playerLocation = new Point2D(0,0);
        Role playerDefaultRole = new Soldier();
        this.player = new HumanCharacter(this,playerLocation,"Player1",playerDefaultRole,new Texture("player.png"));

        this.accountsInGame = new ArrayList<>();
        intersector = new Intersector();
    }

    public ArrayList<NotMovingEntity> getNotMovingEntities() {
        return notMovingEntities;
    }

    public HumanCharacter getPlayer() {
        return player;
    }

    public ArrayList<MovingEntity> getMovingEntities() {
        return movingEntities;
    }

    public int getGameLevel() {
		return this.gameLevel;
	}

	public int getMaxScore() {
		return this.maxScore;
	}

	public int getMaxNumberOfPlayers() {
		return this.maxNumberOfPlayers;
	}

	public Point2D getMouse() {
        double x = MouseInfo.getPointerInfo().getLocation().getX();
        double y = MouseInfo.getPointerInfo().getLocation().getY();
        return new Point2D(x,y);
	}
    public ArrayList<Account> getAccountsInGame() {
        return accountsInGame;
    }
	/**
	 * Checks for colissions between to colliders of type Rectangle.
	 */
	public boolean collisionDetect(Rectangle colliderA, Rectangle colliderB) {
		// TODO - implement Game.collisionDetect
        // TODO -
        boolean colission;
        if(intersector.overlaps(colliderA,colliderB)){
            colission = true;
        }
		throw new UnsupportedOperationException();
	}

    /**
     * Checks for colissions between to colliders of type Circle.
     */
    public void collisionDetect(Circle colliderA, Circle colliderB) {
        // TODO - implement Game.collisionDetect
        // TODO -
        boolean colission;
        if(intersector.overlaps(colliderA,colliderB)){
            colission = true;
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Checks for colissions between a collider of type Circle and a collider of type Rectangle.
     */
    public void collisionDetect(Circle colliderA, Rectangle colliderB) {
        // TODO - implement Game.collisionDetect
        // TODO -
        boolean colission;
        if(intersector.overlaps(colliderA,colliderB)){
            colission = true;
        }
        throw new UnsupportedOperationException();
    }

    /**
	 * Generates spawnpoints for every entity in the game that needs to be spawned.
	 * This includes players (both human and AI), bullets, pickups and all not-moving entities.
	 * @return the spawnpoint for the selected entity
	 */
	public Point2D generateSpawn(Entity entity) {
		// TODO - implement Game.generateSpawn
		throw new UnsupportedOperationException();
	}

	public int angle(Point2D point1, Point2D point2){
		int angle = (360 - (int)Math.toDegrees(Math.atan2(point2.getY() - point1.getY(), point2.getX()- point1.getX())))%360;

		return angle%360;

	}

    /**
     * Calculates the new position between the currentPosition to the Endposition.
     * @param currentPosition
     * @param EndPosition
     * @param speed
     * @return the new position that has been calculated
     */
	public Point2D calculateNewPosition(Point2D currentPosition,Point2D EndPosition,double speed){

        double x = currentPosition.getX();
        double y = currentPosition.getY();

        //gets the difference of the two x coordinates
        double differenceX =EndPosition.getX()- x;
        //gets the difference of the two y coordinates
        double differenceY =EndPosition.getY()- y;

        //pythagoras formula
        double c = Math.sqrt(Math.pow(Math.abs(differenceX),2) +Math.pow(Math.abs(differenceY),2));

        if( c <= (steps * speed))
        {
            return EndPosition;
        }

        double ratio = c/(steps*speed);

        x += (differenceX / ratio);
        y += (differenceY / ratio);

        return new Point2D(x,y);
	}
    /**
     * Calculates the new position from a beginposition and a angle..
     * @param currentPosition
     * @param speed
     * @param angle
     * @return the new position that has been calculated
     */
    public Point2D calculateNewPosition(Point2D currentPosition, double speed, double angle){

        angle+=90;

        double x=currentPosition.getX();
        double y=currentPosition.getY();

        //uses sin and cos to calculate the EndPosition
        x = x + (Math.sin(Math.toRadians(angle))* (steps * speed));
        y = y + (Math.cos(Math.toRadians(angle))* (steps * speed));

        return new Point2D(x,y);
    }



	/**
	 * Called when an entity needs to be added to the game (Only in the memory, but it is not actually drawn)
	 * @param entity : Adds a new entity to this game
	 */
	public void addEntityToGame(Entity entity){
		//entities.add(entity);
	}
	public void removeEntityFromGame(Entity entity){
		//entities.add(entity);
	}

	public void create() {

	}


}
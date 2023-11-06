
/*
 * Activity 2.5.2
 * 
 * Has Player objects for the PhraseSolver game.
 * 
 * Authors: Sanat Gupta, Ryan Kim, PLTW
 * Date: 10/30/2023
 * A Player class for the PhraseSolver game, which has objects of players who each have points and a name.
 *
 */
import java.util.Scanner; // needed to ask the user for their name

public class Player {

  private int points; // initializing attributes which each player will have
  private String name;

  /**
   * This method initializes a Player object with 0 points and asks the player for
   * a name.
   */
  public Player() {
    this.points = 0; // setting the points to 0

    System.out.println("Enter Player Name:"); // asking for the player's name
    Scanner s = new Scanner(System.in);
    String newName = s.nextLine();

    this.name = newName; // setting the attribute and starting the game
    System.out.println("Welcome to the game " + name + "!"); // welcoming them
  }

  /**
   * This method initializes a Player object with 0 points and a name that the
   * user gives.
   * 
   * @param name The name of the player.
   * 
   */
  public Player(String name) {
    this.points = 0; // setting the points to 0
    this.name = name; // setting the name to what it needs to be
    System.out.println("Welcome to the game " + name + "!"); // starting the game and welcoming them
  }

  /**
   * This method returns the player's current points as an Integer.
   * Preconditions: points exists
   * 
   * @return The number of points the player has.
   */
  public int getPoints() {
    return points; // gives how many points that player has
  }

  /**
   * This method returns the player's name as a String.
   * Preconditions: there is a name
   * 
   * @return The name of the player.
   */
  public String getName() {
    return name; // gives the player's name
  }

  /**
   * This method sets the player's points to whatever the user provides.
   * 
   * @param newPoints The new amount of points the player should have.
   * 
   */
  public void setPoints(int newPoints) {
    points = newPoints; // sets the amount of points the player has to what it needs to be
  }

  /**
   * This method adds an amount to the player's total points.
   * 
   * @param pointsAdded The amount of points that will be added to the player's
   *                    score.
   * 
   */
  public void addPoints(int pointsAdded) {
    points += pointsAdded; // adds the amount of points that need to be added
  }

  /**
   * This method set's the player's name to whatever the user provides.
   * 
   * @param newName The new name of the player.
   */
  public void setName(String newName) {
    name = newName; // sets the name to whatever the player's new name is
  }
}
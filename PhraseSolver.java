
/*
 * Activity 2.5.2
 *
 *  The class that contains code to play the PhraseSolver game.
 * 
 *  Authors: Sanat Gupta, Ryan Kim, PLTW
 *  Date: 10/30/2023
 * 
 *  The PhraseSolver class of the PhraseSolver game contains the main logic of the game, and it is the class that asks for input and allows the user to enter letters and play the game until someone wins.
 */
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PhraseSolver {
  Player player1; // four attributes of each object - two players, a board, and if it's solved
  Player player2;
  Board board;
  boolean solved;

  /**
   * This method initializes a new PhraseSolver object with two players, a board,
   * and the phrase not being solved.
   */
  public PhraseSolver() {
    this.player1 = new Player(); // initializing two players
    this.player2 = new Player();
    this.board = new Board(); // initializes board
    this.solved = false; // the game is not solved yet
  }

  private void printScore() {
    System.out.println(player1.getName() + "'s score: " + player1.getPoints());
    System.out.println(player2.getName() + "'s score: " + player2.getPoints());
  }

  /** This method starts the game and lets the players enter words and play. */
  public void play() {
    boolean solved = false; // the game isn't over yet
    int currentPlayer = 1; // there's only one player right now, might be more later

    ArrayList<String> charactersUsed = new ArrayList<String>(); // make array of characters used

    Scanner input = new Scanner(System.in); // going to ask for the user's guess

    boolean correct = true; // is the guess correct or not

    String guess; // The guess of the player
    while (!solved) // while the game isn't over, this loop will continue running
    {
      System.out.print("\nCurrent Player: "); // printing whose turn it is
      if (currentPlayer == 1) { // checking which player, printing
        System.out.println(player1.getName());
      } else if (currentPlayer == 2) {
        System.out.println(player2.getName());
      }

      correct = true;
      while (correct) {
        System.out.println("");
        printScore();
        System.out.println("");
        System.out.println("Partially Solved Phrase: " + board.getPartialPhrase()); // printing information to the user
        System.out.println("Current letter value: " + board.getLetterValue());

        System.out.println("Enter a letter or try to solve the phrase:"); // asking the user for a letter
        guess = input.nextLine();

        // Letter guess
        if (guess.length() == 1) {
          correct = board.guessLetter(guess.toLowerCase()); // if the character is correct

          if (charactersUsed.contains(guess.toLowerCase())) { // if the character has been repeated
            System.out.println("Character already used, you lose your turn.");
            correct = false; // to not keep the loop going so that the next player goes
          } else {
            if (correct) {
              System.out.println("The letter is in the phrase! +" + board.getLetterValue() + " points!"); // informing
                                                                                                          // user and
                                                                                                          // telling
                                                                                                          // them they
                                                                                                          // get points
              switch (currentPlayer) { // adding the points depending on which user it is
                case 1:
                  player1.addPoints(board.getLetterValue()); // adding
                  break;
                case 2:
                  player2.addPoints(board.getLetterValue());
                  break;
              }
              board.setLetterValue(); // setting the current letter value
            } else {
              System.out.println("The letter is not in the phrase! You lose your turn!"); // their turn is over
              correct = false;
            }
            charactersUsed.add(guess.toLowerCase()); //
          }

        } else if (guess.length() > 1) { // Phrase guessed
          if (guess.equals(board.getPhrase())) { // If the phrase is right, end game and get 1000 points
            System.out.println("You guessed the phrase correctly! You win 1000 points."); // informing user
            if (currentPlayer == 1) {
              player1.addPoints(1000); // adding points depending on which player was correct
            } else {
              player2.addPoints(1000);
            }

            // game ends
            solved = true;
            break;
          } else { // If the phrase is wrong, lose 500 points
            System.out.println("You did not guess the phrase. You lose 500 points and your turn."); // informing user
            if (currentPlayer == 1) {
              player1.addPoints(-500); // losing points depending on which player
            } else {
              player2.addPoints(-500);
            }

            correct = false;
          }
        } else {
          System.out.println("Please enter a character when you guess, you lose your turn.");
          correct = false;
        } // last one for if correct

        // Check if the partial phrase is equal to the real phrase, if so end the game.
        if (board.checkPartialPhrase()) {
          System.out.println("The entire phrase has been guessed!"); // informing user

          // game ends
          correct = false;
          solved = true;
        }

      } // while correct

      // Switch the current player

      if (currentPlayer == 1) {
        currentPlayer = 2;
      } else {
        currentPlayer = 1;
      }

    } // while solved
  

    // Print out the final score
    System.out.println("");
    printScore();
    System.out.println("");

    // Print who wins

    if (player1.getPoints() > player2.getPoints()) {
      // P1 Wins
      System.out.println(player1.getName() + " Wins!");
    } else if (player2.getPoints() > player1.getPoints()) {
      // P2 Wins
      System.out.println(player2.getName() + " Wins!");
    } else {
      // Tie
      System.out.println(
          "It was a tie! " + player1.getName() + " and " + player2.getName() + " had the same points.");
    }

  } // play function

} // entire class
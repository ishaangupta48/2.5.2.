
/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

/**
 * Handles the Board state of the game, contains the solved phrase as well as
 * the formatted guessed phrase.
 */
public class Board {
  private String solvedPhrase; // the part of the phrase that has already been solved
  private String phrase; // the full phrase
  private int currentLetterValue;

  /* your code here - constructor(s) */
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
  }

  /**
   * Returns the value of the current letter.
   * 
   * @return The letter value
   */

  public int getLetterValue() {
    return currentLetterValue;
  }

  /**
   * Returns the solved phrase, or the correct phrase.
   * 
   * @return The solved phrase
   */

  public String getPhrase() {
    return phrase;
  }

  public String getPartialPhrase() {
    return solvedPhrase;
  }

  /* your code here - accessor(s) */

  /**
   * Checks if the guess argument is equal to the phrase, if so change
   * solvedPhrase and return true, return false otherwise.
   * 
   * Postcondition:
   * If the phrase does equal the guess, change solvedPhrase into the phrase
   * 
   * @param guess Checks if this is equal to the phrase
   * @return if the guess is equal to the phrase
   */

  public boolean solvePhrase(String guess) {
    if (guess.equals(phrase)) {
      // If the guess is equal to the right phrase, change solved phrase into the
      // right phrase

      solvedPhrase = phrase;
    }
    // Return if the guess is equal to the phrase.

    return (guess == phrase);
  }

  /**
   * Checks if the partial phrase is equal to the phrase, if so return true
   * 
   * Precondition:
   * PartialPhrase exists and is in the fortmat of "1 2 3 4 5 6 7 8 9 0"
   * 
   */

  public boolean checkPartialPhrase() {
    String str = "";
    for (int i = 0; i < getPartialPhrase().length(); i += 2) {
      str += getPartialPhrase().charAt(i);
    }

    return str.equals(getPhrase());
  }

  /* ---------- provided code, do not modify ---------- */

  /**
   * Sets the letter value to a random value from 1-10 inclusive.
   * 
   * Postcondition:
   * currentLetterValue is a random value from 1-10 inclusive.
   */

  public void setLetterValue() {
    // Generate random int from 1-10 inclusive

    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  /**
   * Checks if the guess argument is equal to the phrase
   * 
   * Precondition:
   * phrase exists
   * 
   * @param guess Checks if this is equal to the phrase
   * @return If the letter was solved or not.
   */

  public boolean isSolved(String guess) {
    if (phrase.equals(guess)) {
      return true;
    }
    return false;
  }

  /**
   * Loads a phrase at random from the file phrases.txt
   * 
   * Precondition:
   * phrases.txt exists and is populated.
   * Postcondition:
   * The instance variable phrase is populated
   * The instance solvedPhrase is populated with _ and a space character for each
   * letter in the phrase.
   * 
   * @return The phrase that was loaded
   */

  private String loadPhrase() {
    String tempPhrase = "";

    int numOfLines = 0;

    // Tries to scan the number of lines and all of the phrases in phrases.txt
    try {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    // Generates a random number from 1 to the number of lines in phrases.txt
    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    // Try to get the random phrase
    try {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    // Set up solvedPhrase, in the format of underscores for each character and
    // spaces between them.
    for (int i = 0; i < tempPhrase.length(); i++) {
      if (tempPhrase.substring(i, i + 1).equals(" ")) {
        solvedPhrase += "  ";
      } else {
        solvedPhrase += "_ ";
      }
    }

    return tempPhrase;
  }

  /**
   * Checks if the guess argument is in the phrase
   * If so, replace all instances of the character in the solvedPhrase with the
   * guess
   * 
   * Precondition:
   * SolvedPhrase exists and is in the format of _ and spaces between them.
   * Postcondition:
   * Replaces all underscores in SolvedPhrase if the chracter matches the real
   * phrase.
   * 
   * @param guess
   * @return If the guess was in the phrase.
   */
  public boolean guessLetter(String guess) {
    //
    boolean foundLetter = false;
    String newSolvedPhrase = "";

    // Loop through each of the letters of the phrase
    for (int i = 0; i < phrase.length(); i++) {

      // If the phrase letter equals the guess
      if (phrase.substring(i, i + 1).equals(guess)) {
        // Add the letter to the solved phrase
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      } else {

        // If not, just add back the _
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
      }
    }

    // Change the solved the phrase and return if the letter is in the phrase
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  }
}
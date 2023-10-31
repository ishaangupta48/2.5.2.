public class PhraseSolver {
  private Player player1;
  private Player player2;
  private Board board;
  private boolean isGameSolved;

  public PhraseSolver() throws IOException {
      // Create two players using constructors with and without parameters
      player1 = new Player();
      player2 = new Player("Player 2");
      // Initialize board
      board = new Board();
      // Initialize other attributes as needed
      isGameSolved = false;
  }

  // Other methods and attributes as needed
}

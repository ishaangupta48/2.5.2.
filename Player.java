import java.util.Scanner;

public class Player {
    private String name;
    private int points;

    public Player() {
        // Prompt user to input player's name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        // Initialize other attributes as needed
    }

    public Player(String inputName) {
        // Initialize name with inputName and points to 0
        name = inputName;
        points = 0;
        // Print a welcome message
        System.out.println("Welcome, " + name + "!");
    }

    // Other methods and attributes as needed
}

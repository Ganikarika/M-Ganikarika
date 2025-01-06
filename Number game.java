import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 5; // Maximum number of attempts allowed
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nA number between 1 and 100 has been generated. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Score based on remaining attempts
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Your current score: " + score);
            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}

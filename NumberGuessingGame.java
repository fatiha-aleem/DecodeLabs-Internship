//Project 1 Number Guessing Game

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGuessingGame {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("=================================");
        System.out.println("   WELCOME TO THE NUMBER GAME");
        System.out.println("=================================");

        do {
           int target = random.nextInt(100) + 1;
           int maxAttempts = 5;
           int attemptsUsed = 0;
           boolean won = false;

        System.out.println("\nI'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts only. Good luck!");

            
        while (attemptsUsed < maxAttempts && !won) {
        int guess = 0;
        boolean validInput = false;

                
 while (!validInput) {
  System.out.print("Enter your guess: ");
    try {
       guess = sc.nextInt();
       validInput = true;
       
    } catch (InputMismatchException e) {
    System.out.println("That's not a valid number. Try again.");
    sc.next(); 
                    }
                }
  attemptsUsed++;

 if (guess == target) {
    won = true;
                    int pointsEarned = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += pointsEarned;
                    System.out.println("Correct! The number was " + target + ".");
                    System.out.println("You won in " + attemptsUsed + " attempt(s). +" + pointsEarned + " points!");
                } else if (guess > target) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attemptsUsed));
                } else {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attemptsUsed));
                }
            }
                
            if (!won) {
        System.out.println("Out of attempts! The number was " + target + ".");
            }
        System.out.println("Current total score: " + totalScore);
        System.out.print("\nPlay again? (Yes/No): ");
        String response = sc.next();
        playAgain = response.equalsIgnoreCase("Yes");

        } 
        while (playAgain);
        System.out.println("\n=================================");
        System.out.println("Thanks for playing this game! \nFINAL SCORE: " + totalScore);
        System.out.println("=================================");
        sc.close();
    }
}
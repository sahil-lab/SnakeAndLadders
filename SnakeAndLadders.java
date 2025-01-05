package com.chess;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class SnakeAndLadders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the board with snakes and ladders
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();

        // Define snakes
        snakes.put(16, 6);
        snakes.put(46, 25);
        snakes.put(49, 11);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(74, 53);
        snakes.put(89, 68);
        snakes.put(92, 88);
        snakes.put(95, 75);
        snakes.put(99, 80);

        // Define ladders
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(78, 98);

        System.out.println("Welcome to Snakes and Ladders!");
        System.out.println("Press Enter to roll the dice!");

        // Players' positions
        int player1Pos = 1;
        int player2Pos = 1;
        boolean gameWon = false;

        while (!gameWon) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            scanner.nextLine(); // Wait for Enter key
            player1Pos = rollDiceAndMove(player1Pos, snakes, ladders, random);
            System.out.println("Player 1 is now on position: " + player1Pos);
            if (player1Pos == 100) {
                System.out.println("Player 1 wins!");
                gameWon = true;
                break;
            }

            // Player 2's turn
            System.out.println("Player 2's turn:");
            scanner.nextLine(); // Wait for Enter key
            player2Pos = rollDiceAndMove(player2Pos, snakes, ladders, random);
            System.out.println("Player 2 is now on position: " + player2Pos);
            if (player2Pos == 100) {
                System.out.println("Player 2 wins!");
                gameWon = true;
                break;
            }
        }

        scanner.close();
    }

    // Method to roll the dice and update the player's position
    public static int rollDiceAndMove(int position, HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders, Random random) {
        int diceRoll = random.nextInt(6) + 1;
        System.out.println("You rolled a " + diceRoll + "!");
        position += diceRoll;

        if (position > 100) {
            System.out.println("You need an exact roll to reach 100. Stay at position: " + (position - diceRoll));
            return position - diceRoll; // Undo the move if it exceeds 100
        }

        // Check for snakes or ladders
        if (snakes.containsKey(position)) {
            System.out.println("Oh no, a snake! You go down to position " + snakes.get(position));
            position = snakes.get(position);
        } else if (ladders.containsKey(position)) {
            System.out.println("Great! A ladder! You climb to position " + ladders.get(position));
            position = ladders.get(position);
        }

        return position;
    }
}

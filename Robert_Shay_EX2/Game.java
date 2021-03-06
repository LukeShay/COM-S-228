package edu.iastate.summer18.cs228.ex2;

/**
 * A game where a user guesses the random numbers that are generated by the client. The game repeats until you get all of the numbers correct. The order does not matter. The user can choose to play again once they get the correct answer.
 * @author Robert Shay
 */
import java.util.Scanner;
import java.util.Random;

public class Game {
	public static void main(String[] args) {
		boolean again = true;
		Scanner s = new Scanner(System.in);
		Random r = new Random();

		while (again) {
			ResizableArrayBag<Integer> generated = new ResizableArrayBag<>();
			ResizableArrayBag<Integer> guessed = new ResizableArrayBag<>();

			int range = r.nextInt(25);
			int guesses = r.nextInt(4) + 1;

			for (int i = 0; i < guesses; i++) {
				generated.add(r.nextInt(range));
			}

			System.out.print("\nEnter " + guesses + " guesses for the numbers ranging from 0 to " + range + ":");

			while (true) {
				guessed.clear();

				for (int i = 0; i < guesses; i++) {
					guessed.add(s.nextInt());
				}

				Object[] guessedA = guessed.toArray();
				int c = 0;

				for (int i = 0; i < guesses; i++) {
					if (generated.getFrequencyOf((Integer) guessedA[i]) == guessed
							.getFrequencyOf((Integer) guessedA[i])) {
						c += guessed.getFrequencyOf((Integer) guessedA[i]);
					}
				}

				if (c == guesses)
					break;

				System.out.print("\nYou got " + c + " correct, guess again: ");
			}

			System.out.print("\nYou are correct! Play again? (Yes/No) ");
			if ((s.next()).equals("Yes"))
				;
			else
				again = false;
		}
		System.out.print("\nThanks for playing!");
		s.close();
	}
}

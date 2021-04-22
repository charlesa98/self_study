package com.ss.basics.part1;

import java.util.Scanner;
import java.util.Random;
/**
 * random number generator that allows the user to guess the number
 * if the user is within 10 numbers, the user wins. If not, they have 5 tires before they lose
 * 
 * Scanner and Random are needed for input and random number generation 
 */

/**
 * @author Charles 
 *
 */
public class JavaBasicsP1A2 {

	/**
	 * handles the main program. Generates a random number between 1-100 and asks the user for a number
	 * If they are within 10 numbers, the win. Else they lose a guess
	 */
	public static void main(String[] args) {
		//create a random number
		Random r = new Random();
		int l = 1, h = 100;
		int random = r.nextInt(h-l)+l;
		//amount of guesses
		int guesses=5;
		//create Scanner object, input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the number game. Guess a number to win in 5 or less tries");
		//scan for next number
		int num = input.nextInt();
		while(guesses>1)
		{
			if((num+10)>=random && (num-10)<=random)
			{
				System.out.println("Congrats you win! The number was "+random);
				System.exit(0);
			}
			else
			{
				guesses--;
				System.out.println("Sorry that is not correct. You have "+guesses+" guess(es) left");
				num = input.nextInt();

			}
		}
		System.out.println("Sorry you have lost. The number was "+random);
		System.exit(0);
		input.close();
	}

}

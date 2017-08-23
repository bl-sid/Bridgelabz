package com.bridgelabz.programs;

import java.util.Random;
import java.util.Scanner;

public class CrossGame {

	char[][] gameArray = new char[3][3]; // stores the turns
	Scanner scanner; // to get user input
	static boolean myturn = false; // checks if turn is ours

	public static void main(String[] args) {

		CrossGame crossGame = new CrossGame(); // class object
		crossGame.game();
	}

	/** Starts the cross game **/
	void game() {
		scanner = new Scanner(System.in);

		//	fills array with white spaces
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameArray[i][j] = ' ';
			}
		}

		//starts the game and gets user input
		for (int i = 0; i < 9; i++) {
			if (!myturn) {	//computer's turn
				System.out.println("Computer's Turn...");
				computerTurn();
				printArray();
				myturn = true;
				if (checkWin('O')) {	//	check if computer has won
					System.out.println("You LOST... (-_-)");
					return;
				}
			} else {
				myTurn();
				if (checkWin('X')) {
					System.out.println("You Won (^_^)");
					return;
				}
			}
		}
		System.out.println("Draw!!!");
	}

	/**
	 * Makes a turn for computer
	 */
	void computerTurn() {
		Random random = new Random();
		int c = random.nextInt(3);	//	random row
		int d = random.nextInt(3);	//	random column
		boolean b = checkValidTurn(c, d);	//	 check if the position is already filled or not
		if (b) {
			gameArray[c][d] = 'O';	//	add the move if position is empty
		} else {
			computerTurn();	//	position is already filled. Again generate random move 
		}
	}

	/**
	 * @param i - row number
	 * @param j - column number
	 * @returns true if turn made is valid else returns false
	 */
	boolean checkValidTurn(int i, int j) {
		if ((gameArray[i][j] == 'O') || (gameArray[i][j] == 'X')) {
			return false;
		}
		return true;
	}

	/**
	 * Prints the game after the move is made
	 */
	void printArray() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gameArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * checks whether computer or player has won after making a move 
	 * @param p - character for checking win
	 * @returns true if computer / player wins else returns false
	 */
	boolean checkWin(char p) {
		for (int i = 0; i < 3; i++) {
			if ((gameArray[i][0] == p) && gameArray[i][1] == p && gameArray[i][2] == p) {
				return true;
			}
			if ((gameArray[0][i] == p) && gameArray[1][i] == p && gameArray[2][i] == p) {
				return true;
			}
		}
		if ((gameArray[0][0] == p) && gameArray[1][1] == p && gameArray[2][2] == p) {
			return true;
		}
		if ((gameArray[0][2] == p) && gameArray[1][1] == p && gameArray[2][0] == p) {
			return true;
		}
		return false;
	}

	/**
	 * gets user's input and puts it into game array
	 */
	void myTurn() {
		System.out.print("Your Turn... Enter coordinates: ");
		int x = scanner.nextInt() - 1;
		int y = scanner.nextInt() - 1;
		if (checkValidTurn(x, y)) {	//	checks if turn is valid
			gameArray[x][y] = 'X';
			printArray();
			myturn = false;

		} else {
			myTurn();
		}
	}
}
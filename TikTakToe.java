import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TikTakToe {
	
	static ArrayList<Integer>player1Position = new ArrayList<Integer>();
	static ArrayList<Integer>player2Position = new ArrayList<Integer>();
	
	public static void printBoard(char[] [] gameBoard) {
		for (char[] row : gameBoard) {
			for(char c : row) {
			System.out.print(c);
			}
		System.out.println();
		}
	}
		public static void main(String[] args) {
			char[] [] gameBoard = {{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}};
			

			while (true) {
				//Player 1
				Scanner scan = new Scanner(System.in);
				System.out.print("Player 1 enter the number from 0-9: ");
				int val = scan.nextInt();
				System.out.println(val);
				
				//Player 2
				Scanner scan1 = new Scanner(System.in);
				System.out.print("Player 2 enter the number from 0-9: ");
				int cpu = scan1.nextInt();
				System.out.println(cpu);
				
				gameFunction(gameBoard, val, "Player");
				gameFunction(gameBoard, cpu, "Cpu");
				printBoard(gameBoard);
				
				String result = checkWinner();
				System.out.println(result);
			}
		}
		
public static void gameFunction (char[][] gameBoard, int pos, String user) {
	char symbol = ' ';
	
	if(user.equals("Player")) {
		symbol = 'X';
		player1Position.add(pos);
	}else if (user.equals("Cpu")) {
		symbol = 'O';
		player2Position.add(pos);
	}
	
	switch(pos) {
		case  1:
			gameBoard [0][0] = symbol;
			break;
		case  2:
			gameBoard [0][2] = symbol;
			break;
		case  3:
			gameBoard [0][4] = symbol;
			break;
		case  4:
			gameBoard [2][0] = symbol;
			break;
		case  5:
			gameBoard [2][2] = symbol;
			break;
		case  6:
			gameBoard [2][4] = symbol;
			break;
		case  7:
			gameBoard [4][0] = symbol;
			break;
		case  8:
			gameBoard [4][2] = symbol;
			break;
		case  9:
			gameBoard [4][4] = symbol;
			break;
		default:
			break;
}
	}

public static String checkWinner() {
	
	List topRow = Arrays.asList(1,2,3);
	List midRow = Arrays.asList(4,5,6);
	List botRow = Arrays.asList(7,8,9);
	List leftCol = Arrays.asList(1,4,7);
	List midCol = Arrays.asList(2,5,8);
	List rightCol = Arrays.asList(3,6,9);
	List cross1 = Arrays.asList(1,5,9);
	List cross2 = Arrays.asList(3,5,7);
	
	List<List> winning = new ArrayList<List>();
	winning.add(topRow);
	winning.add(midRow);
	winning.add(botRow);
	winning.add(leftCol);
	winning.add(midCol);
	winning.add(rightCol);
	winning.add(cross1);
	winning.add(cross2);
	
	for(List l : winning) {
		if (player1Position.containsAll(l)) {
			return "Congratulations Player 1 you won";
		}else if (player2Position.containsAll(l)) {
			return "Congratulations Player 2 you won";
		}else if (player1Position.size() + player2Position.size() == 9) {
			return "Board is Full";
		}
	}
	
	return "";
}

}



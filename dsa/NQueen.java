package dsa;

import java.util.Scanner;

public class NQueen {
	static int size = 0;
	public static boolean isSafe(char board[][], int row, int col) {
		//vertical up
		for(int i = row-1;i>=0;i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		//diag left up
		for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		//diag right up
		for(int i=row-1,j=col+1; i>=0 && j<board.length;i--,j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	public static void nQueen(char board[][], int row) {
		//base 
		if(row == board.length) {
			printBoard(board);
			return;
		}
		
		//column
		for(int j=0;j<board.length;j++) {
			if(isSafe(board, row, j)) {
				board[row][j] = 'Q';
				nQueen(board, row+1);
				board[row][j] = '.'; //backtracking step
			}
		}
	}
	
	public static void printBoard(char board[][]) {
		size = size+1;
		System.out.println("------------chess board----------");
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				System.out.print(board[i][j]+" ");
			}
			
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of queens you want in chess board");
		int n =sc.nextInt();
		char board[][] = new char[n][n];
		
		//initialising
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '.';
			}
		}
		
		nQueen(board,0);
		System.out.println("Total number of possible combinations : "+size);
	}

}

package edu.nyit.csci185.m05.Sudoku;
/**
 * 
 * @author Scott Paillant
 *
 */
public class SudokuDataTest 
{
	
	public static void main(String[] args)
	{
		// A good Sudoku that is solved that I used for testing.
		int[][] data = new int[][]{ {6,8,1,4,2,3,7,5,9} , {4,7,2,1,5,9,3,6,8} , {5,9,3,6,7,8,1,2,4} , {3,1,7,2,8,6,9,4,5} ,{8,6,9,5,1,4,2,3,7} ,{2,5,4,3,9,7,8,1,6} ,{7,4,6,8,3,1,5,9,2} ,{9,3,5,7,6,2,4,8,1}, {1,2,8,9,4,5,6,7,3} } ;
		
		SudokuData sudokuData = new SudokuData(data);
		boolean puzzleSolved = sudokuData.isSodukuSolved();
		System.out.println( "Soduku puzzle is " 
							+(puzzleSolved ? "solved.":"not solved"));
	}
}

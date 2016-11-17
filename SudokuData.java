package edu.nyit.csci185.m05.Sudoku;
import java.lang.RuntimeException;
/**
 * 
 * @author Scott Paillant
 *
 */
public class SudokuData 
{
	public static final int PUZZLE_MAX_SIZE_NINE =9;
	public static final int REGION_MAX_SIZE_THREE=3;
	
	public int[][] data = new int[9][9];
	
	public static void main(String[] args)
	{
		// A good Sudoku that is solved that I used for testing.

		int[][] data = new int[][]{ {6,8,1,4,2,3,7,5,9} , {4,7,2,1,5,9,3,6,8} , {5,9,3,6,7,8,1,2,4} , {3,1,7,2,8,6,9,4,5} ,{8,6,9,5,1,4,2,3,7} ,{2,5,4,3,9,7,8,1,6} ,{7,4,6,8,3,1,5,9,2} ,{9,3,5,7,6,2,4,8,1}, {1,2,8,9,4,5,6,7,3} } ;
		
		SudokuData sudokuData = new SudokuData(data);
		boolean puzzleSolved = sudokuData.isSodukuSolved();
		System.out.println( "Soduku puzzle is " 
							+(puzzleSolved ? "solved.":"not solved"));
		
	}
	
	public SudokuData(int[][] data)
	{
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	public void validateData()
	{
		if(data.length==9 && data[0].length==9)
			return;
		else
			throw new RuntimeException();
	}
	
	public boolean checkRow(int row)
	{
		int[] check = new int[]{1,2,3,4,5,6,7,8,9};
		int count = 0;
		for(int i=0;i<data[row].length;i++)
		{
			for(int j=0;j<check.length;j++)
			{
				if(data[row][i] == check[j])
				{
					
					count++;
					check[j] = -1;
				}
			}
		}
		if(count==9)
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("false");
			return false;
		}
	}
	
	public boolean checkColumn(int column)
	{
		int[] check = new int[]{1,2,3,4,5,6,7,8,9};
		int count = 0;
		
		for(int i=0;i<data[0].length;i++)
		{
			for(int j=0;j<check.length;j++)
			{
				if(data[i][column] == check[j])
				{
					count++;
					check[j] = -1;
				}
			}
		}
		if(count==9)
			return true;
		else
			return false;
	}
	
	public boolean checkBox(int box)
	{
		int[] check = new int[]{1,2,3,4,5,6,7,8,9};
		int[] Box  = new int[9];
		int count =0;
		/*
		 * box 0 needs to check 11,12,13
		 * 						21,22,23
		 * 						31,32,33
		 */
		switch(box)
		{
			case 0 : 
					   Box[0] = data[0][0];
					   Box[1] = data[0][1];
					   Box[2] = data[0][2];
					   Box[3] = data[1][0];
					   Box[4] = data[1][1];
					   Box[5] = data[1][2];
					   Box[6] = data[2][0];
					   Box[7] = data[2][1];
					   Box[8] = data[2][2];
					   
					   for(int i=0;i<Box.length;i++)
					   {
							for(int j=0;j<check.length;j++)
							{
								if(Box[i] == check[j])
								{
									count++;
									check[j] = -1;
								}
							}
						}
						if(count==9)
							return true;
						else
							return false;
			case 1 : 
				   Box[0] = data[0][3];
				   Box[1] = data[0][4];
				   Box[2] = data[0][5];
				   Box[3] = data[1][3];
				   Box[4] = data[1][4];
				   Box[5] = data[1][5];
				   Box[6] = data[2][3];
				   Box[7] = data[2][4];
				   Box[8] = data[2][5];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			case 2 : 
				   Box[0] = data[0][6];
				   Box[1] = data[0][7];
				   Box[2] = data[0][8];
				   Box[3] = data[1][6];
				   Box[4] = data[1][7];
				   Box[5] = data[1][8];
				   Box[6] = data[2][6];
				   Box[7] = data[2][7];
				   Box[8] = data[2][8];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			case 3 : 
				   Box[0] = data[3][0];
				   Box[1] = data[3][1];
				   Box[2] = data[3][2];
				   Box[3] = data[4][0];
				   Box[4] = data[4][1];
				   Box[5] = data[4][2];
				   Box[6] = data[5][0];
				   Box[7] = data[5][1];
				   Box[8] = data[5][2];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			case 4 : 
				   Box[0] = data[3][3];
				   Box[1] = data[3][4];
				   Box[2] = data[3][5];
				   Box[3] = data[4][3];
				   Box[4] = data[4][4];
				   Box[5] = data[4][5];
				   Box[6] = data[5][3];
				   Box[7] = data[5][4];
				   Box[8] = data[5][5];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			case 5 : 
				   Box[0] = data[3][6];
				   Box[1] = data[3][7];
				   Box[2] = data[3][8];
				   Box[3] = data[4][6];
				   Box[4] = data[4][7];
				   Box[5] = data[4][8];
				   Box[6] = data[5][6];
				   Box[7] = data[5][7];
				   Box[8] = data[5][8];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
				case 6 : 
					   Box[0] = data[6][0];
					   Box[1] = data[6][1];
					   Box[2] = data[6][2];
					   Box[3] = data[7][0];
					   Box[4] = data[7][1];
					   Box[5] = data[7][2];
					   Box[6] = data[8][0];
					   Box[7] = data[8][1];
					   Box[8] = data[8][2];
					   
					   for(int i=0;i<Box.length;i++)
					   {
							for(int j=0;j<check.length;j++)
							{
								if(Box[i] == check[j])
								{
									count++;
									check[j] = -1;
								}
							}
						}
						if(count==9)
							return true;
						else
							return false;
			case 7 : 
				   Box[0] = data[6][3];
				   Box[1] = data[6][4];
				   Box[2] = data[6][5];
				   Box[3] = data[7][3];
				   Box[4] = data[7][4];
				   Box[5] = data[7][5];
				   Box[6] = data[8][3];
				   Box[7] = data[8][4];
				   Box[8] = data[8][5];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			case 8 : 
				   Box[0] = data[3][6];
				   Box[1] = data[3][7];
				   Box[2] = data[3][8];
				   Box[3] = data[4][6];
				   Box[4] = data[4][7];
				   Box[5] = data[4][8];
				   Box[6] = data[5][6];
				   Box[7] = data[5][7];
				   Box[8] = data[5][8];
				   
				   for(int i=0;i<Box.length;i++)
				   {
						for(int j=0;j<check.length;j++)
						{
							if(Box[i] == check[j])
							{
								count++;
								check[j] = -1;
							}
						}
					}
					if(count==9)
						return true;
					else
						return false;
			default: return false;
		}
	}
	
	public boolean isSodukuSolved()
	{
		return (checkColumn(0) && checkColumn(1) && checkColumn(2) && checkColumn(3) && checkColumn(4) && checkColumn(5) && checkColumn(6) && checkColumn(7) && checkColumn(8)
				&& checkRow(0) && checkRow(1) && checkRow(2) && checkRow(3) && checkRow(4) && checkRow(5) && checkRow(6) && checkRow(7) && checkRow(8)
				&& checkBox(0) && checkBox(1) && checkBox(2) && checkBox(3) && checkColumn(4) && checkBox(5) && checkBox(6) && checkBox(7) && checkBox(8)
				&& isFilled());
	}
	
	public boolean isFilled()
	{
		int count=0;
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{
				if(data[i][j] >= 1 && data[i][j] <=9 )
				{
					count++;
				}
			}
		}
		if(count==81)
		return true;
		else
			return false;
	}
}

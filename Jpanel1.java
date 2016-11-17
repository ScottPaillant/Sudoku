package edu.nyit.csci185.m05.Sudoku;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Scott Paillant
 * 		 
 *
 */
public class Jpanel1 extends JPanel implements MouseMotionListener, KeyListener  
{
	boolean mouseInsideRect = false;
	String stringToDraw = "";
	int col = 0;
	int row = 0;
	Font fontToUse = new Font(Font.MONOSPACED, Font.BOLD, 120);
	Graphics2D canvas2D; 
	Color g;
	int firstTime = 0;
	String fileToRead="data/puzzles/intermediate/intermediate" + (int) (Math.random() *10 +1)  + ".txt";
	ArrayList<String> untouchables = new ArrayList<String>();
	public int[][] data = new int[9][9];
	boolean running = false;
	Stopwatch stopwatch = new Stopwatch();
	String finishTime ="";
	int count=0;
	public void writeTime() 
	{
		Graphics canvas6 = this.getGraphics();
		if(running==false)
		{
			
		}
		else
		{
			canvas6.clearRect(150,428, 200, 11);
			canvas6.drawString(stopwatch.stopTiming(), 150 ,437);	
		}

	}
	public void setFileToRead(String set)
	{
		fileToRead=set;
	}
	public static void main(String[] args)
	{
	}
	public Jpanel1()
	{
		
	}
	public Jpanel1(String xyz)
	{
	 	setFileToRead(xyz);
	 	repaint();
	 }
	String[][] initialPuzzle = new String[9][9];

	public Graphics2D getCanvas()
	{
		return canvas2D;
	}
	public void fileReader(String xyz)
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(xyz));
			for(int i=0;i<initialPuzzle.length;i++)
			{		
					initialPuzzle[i] = inputStream.nextLine().split(",");
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Error in file " + xyz);
		}
	}
	public void drawCell(int row, int column, String x)
	{
	
		Graphics canvas3 = this.getGraphics();
		canvas2D.setColor(new Color(238,238,238));
		canvas2D.fillRect( (105) + (33 * (column-1) )  , ((105) + (33 * (row-1))) , (25) , (27) );
		canvas2D.setColor(Color.BLACK);
		data[row-1][column-1] = Integer.parseInt(x);
		if (x.equals("0"))
		canvas2D.drawString( " " , (80 + (column * 32)) , (100 + (row * 32)));
		else
		canvas2D.drawString( x , (80 + (column * 32)) , (100 + (row * 32)));
	}
	public void drawCell(int row, int column, String x, Graphics2D canvas)
	{
		
		Graphics canvas3 = this.getGraphics();
		canvas2D.setColor(new Color(238,238,238));
		canvas2D.fillRect( (105) + (33 * (column-1) )  , ((105) + (33 * (row-1))) , (25) , (27) );
		canvas2D.setColor(Color.BLACK);
		data[row-1][column-1] = Integer.parseInt(x);
		if (x.equals("0"))
		canvas2D.drawString( " " , (80 + (column * 32)) , (100 + (row * 32)));
		else
		canvas2D.drawString( x , (80 + (column * 32)) , (100 + (row * 32)));
	}
	public void reDrawCell(int row, int column, String x)
	{

		Graphics canvas4 = this.getGraphics();
		canvas4.setColor(new Color(238,238,238));
		canvas4.fillRect( (105) + (33 * (column-1) )  , ((105) + (33 * (row-1))) , (25) , (27) );
		canvas4.setColor(Color.RED);
		data[row-1][column-1] = Integer.parseInt(x);
		if (x .equals("0"))
		canvas4.drawString( " " , (80 + (column * 32)) , (100 + (row * 32)));
		else
		canvas4.drawString( x , (80 + (column * 32)) , (100 + (row * 32)));
	}
	public void reDrawCell(int row, int column, int number)
	{
		for(int i=0; i<untouchables.size();i++)
		{
			
			if(untouchables.get(i).equals(row+""+column))
			{
				return;
			}
			
		}
		String x = Integer.toString(number);
		Graphics canvas4 = this.getGraphics();
		canvas4.setColor(new Color(238,238,238));
		canvas4.fillRect( (105) + (33 * (col-1) )  , ((105) + (33 * (row-1))) , (25) , (27) );
		canvas4.setColor(Color.RED);
		data[row-1][column-1] = number;
		if (x .equals("0"))
		canvas4.drawString( " " , (80 + (column * 32)) , (100 + (row * 32)));
		else
		canvas4.drawString( x , ((80 + (column * 32)) /* -20 */) , (100 + (row * 32)));
	}
	public void ReDrawCell(int row, int column, String x)
	{
		
		Graphics canvas4 = this.getGraphics();
		Font newfont = new Font("Calibri", Font.BOLD, 15);
		 canvas4.setFont(newfont);
		canvas4.setColor(new Color(238,238,238));
		canvas4.fillRect( (105) + (33 * (col-1) )  , ((105) + (33 * (row-1))) , (25) , (27) );
		canvas4.setColor(Color.BLACK);
		if (x .equals("0"))
		canvas4.drawString( " " , (80 + (column * 32)) , (100 + (row * 32)));
		else
		canvas4.drawString( x , ((80 + (column * 32)) /* -20 */) , (100 + (row * 32)));
	}
	public void drawDone(boolean isFilled,boolean done)
	{

		Graphics canvas5 = this.getGraphics();
		if(isFilled== true && done == true)
		{
			canvas5.clearRect(180, 70, 200, 25);
			canvas5.drawString("Sudoku is Solved!", (180) , 80); 
			if(running==true)
			{
				running = false;
				count = 1;
				writeTime();
				finishTime= stopwatch.stopTiming();
				PrintWriter outputStream = null;
				Scanner inputStream = null;
				String fileName = "scores/scores.txt";
				try
				{
					outputStream = new PrintWriter(new FileOutputStream(fileName));
					outputStream.println(finishTime);
					
					inputStream = new Scanner(new FileInputStream(fileName));
					JOptionPane.showMessageDialog(null,"Fastest time!: " +inputStream.nextLine() );
					outputStream.close();
				}
				catch(IOException e)
				{
					
				}
			}
		}
		else
		{
			if(isFilled==true)
			{
				canvas5.clearRect(180, 70, 200, 25);
				canvas5.drawString("Sudoku is Not Solved!", (180) , 80);
				if(running==true)
				{
					writeTime();
				}
			}
			else
			{
				if(isFilled==false)
				{
					canvas5.clearRect(180, 70, 200, 25);
					canvas5.drawString("Sudoku is Not Filled!", (180) , 80);
					if(running==true)
					{
						writeTime();
					}
				}
			}
			 

		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		Point mousePos = e.getPoint();
		boolean insideRect = isInsideCell1(mousePos);
		if( mouseInsideRect != insideRect)
		{
			mouseInsideRect = insideRect;
		}
	}
	public void makeTemplate()
	{
		
	}
	// Depending on the position of the mouse, the program will set the row and the column
	private boolean isInsideCell1(Point p)
	{
		if(p.getX() >=100 && p.getX() <=133  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 1;
			return true;
		}
		else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 2;
			return true;
		}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 3;
			return true;
		}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 4;
			return true;
		}
		else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 5;
			return true;
		}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 6;
			return true;
		}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 7;
			return true;
		}
		else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 8;
			return true;
		}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=100 && p.getY() <= 133)
		{	
			row = 1;
			col = 9;
			return true;
		}else if(p.getX() >=100 && p.getX() <=133  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 1;
			return true;
		}
		else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 2;
			return true;
		}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 3;
			return true;
		}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 4;
			return true;
		}
		else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 5;
			return true;
		}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 6;
			return true;
		}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 7;
			return true;
		}
		else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 8;
			return true;
		}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=133 && p.getY() <= 166)
		{	
			row = 2;
			col = 9;
			return true;
		}else  if(p.getX() >=100 && p.getX() <=133  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 1;
			return true;
		}
		else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 2;
			return true;
		}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 3;
			return true;
		}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 4;
			return true;
		}
		else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 5;
			return true;
		}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 6;
			return true;
		}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 7;
			return true;
		}
		else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 8;
			return true;
		}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=166 && p.getY() <= 199)
		{	
			row = 3;
			col = 9;
			return true;
		}else
			
			if(p.getX() >=100 && p.getX() <=133  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 1;
				return true;
			}
			else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 2;
				return true;
			}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 3;
				return true;
			}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 4;
				return true;
			}
			else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 5;
				return true;
			}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 6;
				return true;
			}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 7;
				return true;
			}
			else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 8;
				return true;
			}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=200 && p.getY() <= 233)
			{	
				row = 4;
				col = 9;
				return true;
			}else if(p.getX() >=100 && p.getX() <=133  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 1;
				return true;
			}
			else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 2;
				return true;
			}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 3;
				return true;
			}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 4;
				return true;
			}
			else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 5;
				return true;
			}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 6;
				return true;
			}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 7;
				return true;
			}
			else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 8;
				return true;
			}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=233 && p.getY() <= 266)
			{	
				row = 5;
				col = 9;
				return true;
			}else  if(p.getX() >=100 && p.getX() <=133  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 1;
				return true;
			}
			else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 2;
				return true;
			}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 3;
				return true;
			}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 4;
				return true;
			}
			else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 5;
				return true;
			}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 6;
				return true;
			}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 7;
				return true;
			}
			else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 8;
				return true;
			}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=266 && p.getY() <= 299)
			{	
				row = 6;
				col = 9;
				return true;
			}else
				if(p.getX() >=100 && p.getX() <=133  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 1;
					return true;
				}
				else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 2;
					return true;
				}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 3;
					return true;
				}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 4;
					return true;
				}
				else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 5;
					return true;
				}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 6;
					return true;
				}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 7;
					return true;
				}
				else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 8;
					return true;
				}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=300 && p.getY() <= 333)
				{	
					row = 7;
					col = 9;
					return true;
				}else if(p.getX() >=100 && p.getX() <=133  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 1;
					return true;
				}
				else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 2;
					return true;
				}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 3;
					return true;
				}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 4;
					return true;
				}
				else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 5;
					return true;
				}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 6;
					return true;
				}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 7;
					return true;
				}
				else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 8;
					return true;
				}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=333 && p.getY() <= 366)
				{	
					row = 8;
					col = 9;
					return true;
				}else  if(p.getX() >=100 && p.getX() <=133  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 1;
					return true;
				}
				else if(p.getX() >=133 && p.getX() <=166  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 2;
					return true;
				}else if(p.getX() >=166 && p.getX() <=199  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 3;
					return true;
				}else if(p.getX() >=200 && p.getX() <=233  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 4;
					return true;
				}
				else if(p.getX() >=233 && p.getX() <=266  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 5;
					return true;
				}else if(p.getX() >=266 && p.getX() <=299  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 6;
					return true;
				}if(p.getX() >=300 && p.getX() <=333  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 7;
					return true;
				}
				else if(p.getX() >=333 && p.getX() <=366  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 8;
					return true;
				}else if(p.getX() >=366 && p.getX() <=399  && p.getY() >=366 && p.getY() <= 399)
				{	
					row = 9;
					col = 9;
					return true;
				}
				
		
			return false;
	}
	@Override //KeyListener
	public void keyTyped(KeyEvent e)  
	{ 
		if(e.getKeyChar() ==' ') 
		{
			SudokuData sudokuData = new SudokuData(data);
			boolean puzzleSolved = sudokuData.isSodukuSolved();
			boolean puzzleFilled = sudokuData.isFilled();
			drawDone(puzzleFilled,puzzleSolved);
		}		
		responseToKeyInput(e);
	}
	
	@Override //KeyListener
	public void keyPressed(KeyEvent e)  {  }
	
	@Override //KeyListener
	public void keyReleased(KeyEvent e)  {  }
	
	private void responseToKeyInput (KeyEvent e)
	{
		if(mouseInsideRect==true )
		{	
			char x = e.getKeyChar();
			int f;
			switch (x)
			{
				case '1' : stringToDraw="1";
				 f = Integer.parseInt(stringToDraw);
							reDrawCell(row,col,f);
							if(running==false && count == 0)
							{	
							
									running=true;
									stopwatch.startTiming();
									writeTime();
								
							}
							else
							{
								if(count==0)
								writeTime();
							}
							break;
				case '2' : stringToDraw="2";
				 f = Integer.parseInt(stringToDraw);
				reDrawCell(row,col,f);
				if(running==false && count == 0)
				{	
					running=true;
					stopwatch.startTiming();
					writeTime();
				}
				else
				{
					if(count==0)
					writeTime();
				}
						 	break;
				case '3' : stringToDraw="3";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
				}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '4' : stringToDraw="4";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
						
				}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '5' : stringToDraw="5";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '6' : stringToDraw="6";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '7' : stringToDraw="7";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '8' : stringToDraw="8";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '9' : stringToDraw="9";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
				case '0' : stringToDraw="0";
				 f = Integer.parseInt(stringToDraw);
				 reDrawCell(row,col,f);
				 if(running==false && count == 0)
				 {	
						running=true;
						stopwatch.startTiming();
						writeTime();
					}
				 else
					{
						if(count==0)
						writeTime();
					}
							break;
							
				default: break;
			}
		}
		else
		{
			
		}
		
	}
	public void init()
	{
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
	
		
	}
	@Override
	public void paintComponent(Graphics canvas)
	{
		Scanner inputStream = null;
		if(firstTime == 0)
		{
			try
			{
				inputStream = new Scanner(new File("data/puzzles/beginner/default.txt"));

				for(int i=0;i<initialPuzzle.length;i++)
				{		
						initialPuzzle[i] = inputStream.nextLine().split(",");
				}
				
				firstTime++;
			}
			catch(IOException e)
			{
				System.out.println("Error in file default.txt");
			}
		}
		setSize(500,500);
		this.setBackground(Color.WHITE);
		
		canvas2D = (Graphics2D)canvas;
		 
		 
		 BasicStroke stroke2 = new BasicStroke(1);
		 canvas2D.setStroke(stroke2);
		 
		 canvas2D.setColor(Color.GRAY);
		 canvas2D.drawLine(100,133,200,133);
		 canvas2D.drawLine(200,133,300,133);
		 canvas2D.drawLine(300,133,400,133);
		 
		 canvas2D.drawLine(100,166,200,166);
		 canvas2D.drawLine(200,166,300,166);
		 canvas2D.drawLine(300,166,400,166);
		 
		 
		 canvas2D.drawLine(100,233,200,233);
		 canvas2D.drawLine(200,233,300,233);
		 canvas2D.drawLine(300,233,400,233);
		 
		 canvas2D.drawLine(100,266,200,266);
		 canvas2D.drawLine(200,266,300,266);
		 canvas2D.drawLine(300,266,400,266);
		 
		 
		 canvas2D.drawLine(100,333,200,333);
		 canvas2D.drawLine(200,333,300,333);
		 canvas2D.drawLine(300,333,400,333);
		
		 canvas2D.drawLine(100,366,200,366);
		 canvas2D.drawLine(200,366,300,366);
		 canvas2D.drawLine(300,366,400,366);
		 
		 canvas2D.drawLine(133,100,133,200);
		 canvas2D.drawLine(133,200,133,300);
		 canvas2D.drawLine(133,300,133,400);
		 
		 canvas2D.drawLine(166,100,166,200);
		 canvas2D.drawLine(166,200,166,300);
		 canvas2D.drawLine(166,300,166,400);
		 
		 
		 canvas2D.drawLine(233,100,233,200);
		 canvas2D.drawLine(233,200,233,300);
		 canvas2D.drawLine(233,300,233,400);
		 
		 canvas2D.drawLine(266,100,266,200);
		 canvas2D.drawLine(266,200,266,300);
		 canvas2D.drawLine(266,300,266,400);
		 
		 canvas2D.drawLine(333,100,333,200);
		 canvas2D.drawLine(333,200,333,300);
		 canvas2D.drawLine(333,300,333,400);
		 
		 canvas2D.drawLine(366,100,366,200);
		 canvas2D.drawLine(366,200,366,300);
		 canvas2D.drawLine(366,300,366,400);
		 
		 
		 
		 BasicStroke stroke = new BasicStroke(5);
		 canvas2D.setStroke(stroke);
		 
		 
		 canvas2D.setColor(Color.BLACK);
		 
		
		 
		 Rectangle2D r1 = new Rectangle2D.Float(100,100,100,100);
		 canvas2D.draw(r1);
		 Rectangle2D r2 = new Rectangle2D.Float(200,100,100,100);
		 canvas2D.draw(r2);
		 Rectangle2D r3 = new Rectangle2D.Float(300,100,100,100);
		 canvas2D.draw(r3);
		
		 Rectangle2D r4 = new Rectangle2D.Float(100,200,100,100);
		 canvas2D.draw(r4);
		 Rectangle2D r5 = new Rectangle2D.Float(200,200,100,100);
		 canvas2D.draw(r5);
		 Rectangle2D r6 = new Rectangle2D.Float(300,200,100,100);
		 canvas2D.draw(r6);
		 
		 Rectangle2D r7 = new Rectangle2D.Float(100,300,100,100);
		 canvas2D.draw(r7);
		 Rectangle2D r8 = new Rectangle2D.Float(200,300,100,100);
		 canvas2D.draw(r8);
		 Rectangle2D r9 = new Rectangle2D.Float(300,300,100,100);
		 canvas2D.draw(r9);
		 
		 Font newfont = new Font("Calibri", Font.BOLD, 15);
		 canvas.setFont(newfont);
		 init();
		
		fileReader(fileToRead);
		for(int i=0;i<initialPuzzle.length;i++)
		{
			for(int j=0;j<initialPuzzle[0].length;j++)
			{
				canvas2D.setColor(new Color(238,238,238));
				canvas2D.fillRect( (105) + (33 * ((j)) )  , ((105) + (33 * (i))) , (25) , (27) );
				canvas2D.setColor(Color.BLACK);
				data[i][j] = Integer.parseInt(initialPuzzle[i][j]);
				if (initialPuzzle[i][j].equals("0"))
				canvas2D.drawString( " " , (82 +( (j+1) * 32) ), (100 + (i) * 32));
				else
				{
					canvas2D.drawString( initialPuzzle[i][j] , (82 + ( (j+1) * 32)  ) , (100 + ((i+1) * 32)  ));
				 untouchables.add((i+1) + "" + (j+1) );
				}
			}
		}
		canvas2D.drawString("Press Spacebar to check if Sudoku is Solved!" , 117 , 420);

		canvas2D.drawString("Time will show when you start playing, and as you press keys." , 50 , 450);

	}
	
}

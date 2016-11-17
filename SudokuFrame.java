package edu.nyit.csci185.m05.Sudoku;
/**
 * 
 * @author Scott Paillant
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
public class SudokuFrame extends JFrame 
{
	public static void main(String[] args)
	{
		
		SudokuFrame frame = new SudokuFrame("Sudoku");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	// Run beginner
	public void runProgram()
	{
		
		this.dispose();
		SudokuFrame frame = new SudokuFrame("Sudoku");
		frame.setVisible(true);
		Jpanel SudokuPanel = new Jpanel();
		setContentPane(SudokuPanel);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// Run intermediate
	public void runProgram1()
	{
		this.dispose();
		SudokuFrame frame = new SudokuFrame("Sudoku", 2.0);
		frame.setVisible(true);
		Jpanel1 SudokuPanel2 = new Jpanel1();
		setContentPane(SudokuPanel2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// Run expert
	public void runProgram2()
	{
		this.dispose();
		SudokuFrame frame = new SudokuFrame("Sudoku", "");
		frame.setVisible(true);
		Jpanel2 SudokuPanel3 = new Jpanel2();
		setContentPane(SudokuPanel3);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public SudokuFrame(String name)
	{
		  
		Color backgroundColor = getBackground();
		final Jpanel SudokuPanel = new Jpanel();
		SudokuPanel.add(new JLabel("Sudoku"));
		JButton beginner = new JButton("Difficulty: Beginner");
		
		JButton intermediate = new JButton("Difficulty: Intermediate");
		 intermediate.addActionListener(new ActionListener() {
			 
				public void actionPerformed(ActionEvent e)
	            {
					runProgram1();
					
	            }
		 });  
		 
		JButton expert = new JButton("Difficulty: Expert");
		 expert.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	            	runProgram2();
	            	
	            }
	        });
		 
		
		SudokuPanel.add(beginner);   
		beginner.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	runProgram();

            }
        });
		SudokuPanel.add(intermediate);
		SudokuPanel.add(expert);
		
		setTitle(name);
		setContentPane(SudokuPanel);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2-this.getSize().width/2) -250 , (dim.height/2-this.getSize().height/2) - 250);
		setSize(500,500);
		
	}
	public SudokuFrame(String name, String x)
	{
		  
		Color backgroundColor = getBackground();
		final Jpanel2 SudokuPanel = new Jpanel2();
		SudokuPanel.add(new JLabel("Sudoku"));
		JButton beginner = new JButton("Difficulty: Beginner");
		
		JButton intermediate = new JButton("Difficulty: Intermediate");
		 intermediate.addActionListener(new ActionListener() {
			 
				public void actionPerformed(ActionEvent e)
	            {
					runProgram1();
				
					
	            }
		 });  
		 
		JButton expert = new JButton("Difficulty: Expert");
		 expert.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	            	runProgram2();
	            	
	            }
	        });
		 
		 
		SudokuPanel.add(beginner);   
		beginner.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	runProgram();
            	
            }
        });
		SudokuPanel.add(intermediate);
		SudokuPanel.add(expert);
		
		setTitle(name);
		setContentPane(SudokuPanel);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2-this.getSize().width/2) -250 , (dim.height/2-this.getSize().height/2) - 250);
		setSize(500,500);
		
	}
	public SudokuFrame(String name, double y)
	{
		  
		Color backgroundColor = getBackground();
		final Jpanel1 SudokuPanel = new Jpanel1();
		SudokuPanel.add(new JLabel("Sudoku"));
		JButton beginner = new JButton("Difficulty: Beginner");
		
		JButton intermediate = new JButton("Difficulty: Intermediate");
		 intermediate.addActionListener(new ActionListener() {
			 
				public void actionPerformed(ActionEvent e)
	            {
					runProgram1();
				
				
	            }
		 });  
		 
		JButton expert = new JButton("Difficulty: Expert");
		 expert.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	            	runProgram2();
	            	
	            }
	        });
		 
		 
		SudokuPanel.add(beginner);   
		beginner.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	runProgram();
            	
            }
        });
		SudokuPanel.add(intermediate);
		SudokuPanel.add(expert);
		
		setTitle(name);
		setContentPane(SudokuPanel);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// middle of your screen
		this.setLocation((dim.width/2-this.getSize().width/2) -250 , (dim.height/2-this.getSize().height/2) - 250);
		setSize(500,500);
		
	}
}

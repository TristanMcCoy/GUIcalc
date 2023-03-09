/**
 * CLASS: Main (Main.java)
 * 
 * DESCRIPTION
 * Main contains the main() and run() methods.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

import javax.swing.JFrame;

public class Main {
	
	private View mView;
	
	public static void main(String[] args) {
		/**
		 * Instantiates a Main object and calls run().
		 */
		
		new Main().run();
	}
	
	public void exit() {
		/**
		 * Exits the program.
		 */
		
		System.exit(-1);
	}
	
	private View getView() {
		/**
		 * Accessor for mView.
		 */
		
		return mView;
	}
	
	private void run() {
		/**
		 * Run() is the main routine.
		 */
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		setView(new View(this));
	}
	
	private void setView(View pView) {
		/**
		 * Mutator for mView.
		 */
		
		mView = pView;
	}
}

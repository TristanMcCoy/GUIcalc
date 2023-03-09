/**
 * CLASS: View (View.java)
 * 
 * DESCRIPTION
 * View implements the GUI.
 * 
 * COURSE AND PROJECT INFORMATION
 * CSE 205 Object Oriented Programming and Data Structures, Spring B 2022
 * Project Number: 4
 * 
 * AUTHOR: Tristan McCoy
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class View extends JFrame implements ActionListener {
	
	private static final long 	serialVersionUID = 1L;
	public static final int 	FRAME_WIDTH = 500;
	public static final int 	FRAME_HEIGHT = 180;
	private JButton 			mClearButton, mEvalButton, mExitButton;
	private JTextField 			mInputText;
	private JLabel 				mResultLabel;
	private Main 				mMain;
	
	public View (Main pMain) {
		/**
		 * Constructor method for View. Creates the GUI.
		 */
		
		mMain = pMain;
		
		JPanel panelLabel = new JPanel();
		mResultLabel = new JLabel("");
		panelLabel.add(mResultLabel);
		
		JPanel panelInput = new JPanel();
		mInputText = new JTextField(40);
		panelInput.add(mInputText);
		
		JPanel panelButtons = new JPanel();
		mClearButton = new JButton("Clear");
		mClearButton.addActionListener(this);
		panelButtons.add(mClearButton);
		mEvalButton = new JButton("Evaluate");
		mEvalButton.addActionListener(this);
		panelButtons.add(mEvalButton);
		mExitButton = new JButton("Exit");
		mExitButton.addActionListener(this);
		panelButtons.add(mExitButton);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		panelMain.add(Box.createVerticalGlue());
		panelMain.add(panelLabel);
		panelMain.add(panelInput);
		panelMain.add(panelButtons);
		
		setTitle("Calculator");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panelMain);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		/**
		 * Detects which button was clicked and handles it.
		 */
		
		if (pEvent.getSource() == mClearButton) clear();
		else if (pEvent.getSource() == mEvalButton) evaluate();
		else if (pEvent.getSource() == mExitButton) mMain.exit();
	}
	
	private void clear() {
		/**
		 * Clears the mInputText and mResultLabel text fields.
		 */
		
		mInputText.setText("");
		mResultLabel.setText("");
	}
	
	private void evaluate() {
		/**
		 * Evaluates the expression in mInputText.
		 */
		
		Expression expr = new Expression(mInputText.getText());
		mResultLabel.setText(expr.evaluate().toString());
	}
	
	public void messageBox(String pMessage) {
		/**
		 * Displays pMessage.
		 */
		
		JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
	}
}

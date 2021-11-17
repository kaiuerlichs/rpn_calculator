import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * The application class contains the GUI logic for the RPN Calculator
 * 
 * @author Kai Uerlichs
 * @version 1.0
 */
public class Application {

	private JFrame frame;
	private JTextField expressionInput;
	private JTextField delimiterInput;

	/**
	 * Main method that starts the life cycle of the program
	 * 
	 * @param args Not implemented
	 */
	public static void main(String[] args) {
		
		// Creates a new Runnable to be executed in the event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				// Attempt to create a new instance of the application and run it
				try {
					Application app = new Application();
					app.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Default constructor. Initialises the GUI.
	 */
	public Application() {
		initialise();
	}

	/**
	 * Initialise the contents of the window.
	 */
	public void initialise() {
		
		// Set the look and feel of the Swing GUI to system native
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Could not change look and feel.");
		}
		
		// Create a new JFrame, set its size, close operation and make the layout 
		frame = new JFrame("RPN Calculator");
		frame.setBounds(100, 100, 400, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// Create a TabbedPane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 386, 323);
		frame.getContentPane().add(tabbedPane);
		
		
		// Create the main view panel
		JPanel panelCalc = new JPanel();
		panelCalc.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("RPN Calculator", panelCalc);
		panelCalc.setLayout(null);
		
		// Add the expression input section
		JLabel label1 = new JLabel("1. Enter your RPN expression here");
		label1.setBounds(10, 10, 361, 13);
		panelCalc.add(label1);
		
		expressionInput = new JTextField();
		expressionInput.setBounds(10, 33, 361, 19);
		panelCalc.add(expressionInput);
		
		// Add the delimiter input section
		JLabel label2 = new JLabel("2. Set the delimiter");
		label2.setBounds(10, 62, 361, 13);
		panelCalc.add(label2);
		
		delimiterInput = new JTextField();
		delimiterInput.setBounds(10, 85, 68, 19);
		panelCalc.add(delimiterInput);
		
		JButton spaceButton = new JButton(" ");
		spaceButton.setBounds(303, 84, 68, 21);
		panelCalc.add(spaceButton);
		
		JButton commaButton = new JButton(",");
		commaButton.setBounds(156, 84, 68, 21);
		panelCalc.add(commaButton);
		
		JButton semicolonButton = new JButton(";");
		semicolonButton.setBounds(83, 84, 68, 21);
		panelCalc.add(semicolonButton);
		
		JButton underscoreButton = new JButton("_");
		underscoreButton.setBounds(229, 84, 68, 21);
		panelCalc.add(underscoreButton);
		
		// Add clear and calculate buttons
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(210, 132, 100, 50);
		panelCalc.add(clearButton);
		
		JButton calcButton = new JButton("Calculate");
		calcButton.setBounds(60, 132, 100, 50);
		panelCalc.add(calcButton);
		
		// Create output section
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 210, 361, 2);
		panelCalc.add(separator);
		
		JLabel outputLabel = new JLabel("Your results will appear here...");
		outputLabel.setVerticalAlignment(SwingConstants.TOP);
		outputLabel.setBounds(10, 222, 361, 64);
		panelCalc.add(outputLabel);
		
		
		// Create help panel
		JPanel panelHelp = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelHelp.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		tabbedPane.addTab("Help", panelHelp);
		
		JLabel helpLabel = new JLabel("<html><b>RPN Calculator</b> by Kai Uerlichs<br/>This is a simple calculator tool, that evaluates postfix (or Reverse Polish Notation)<br/>expressions.<br/><br/><b>How to use the calculator</b><br/><br/>To calculate, simply enter your RPN expression into the input box. Make sure to<br/>pick a delimiter and include it in your expression, so the program can interpret it.<br/><br/>Then, define your delimiter in the field below, or select one of the pre-defined<br/>ones. Then, simply click calculate and the result will be displayed below.<br/>Furthermore, an infix interpretation of your expression will be calculated and<br/>displayed as well.<br/><br/>If your expression is invalid, the program will display an error message and instruct<br/>you on how to fix it in many cases.<br/><br/><b>Debug</b><br/><br/>The debug section launches has the option to launch an automatic test program,<br/>that will output its results to a console window. This is for developers only.</html>");
		helpLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panelHelp.add(helpLabel);
		
		
		// Create debug panel
		JPanel panelDebug = new JPanel();
		tabbedPane.addTab("Debug", panelDebug);
		panelDebug.setLayout(null);
		
		JButton runTests = new JButton("Run tests");
		runTests.setBounds(148, 144, 85, 21);
		panelDebug.add(runTests);
		
		JLabel debugText = new JLabel("<html>The button below will launch a console window and perform some<br/>automated tests on the underlying data structures of this project.<br/>The output tells the developers whether everything is running smoothly.<br/></html>");
		debugText.setHorizontalAlignment(SwingConstants.CENTER);
		debugText.setBounds(10, 77, 361, 57);
		panelDebug.add(debugText);
		
		
		// Add button action listeners for main panel
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get expression and delimiter from input boxes
				String expression = expressionInput.getText();
				String delimiter = delimiterInput.getText();
				
				// Check if either is empty, display warning
				if(expression.equals("")) {
					outputLabel.setForeground(Color.red);
					outputLabel.setText("Your expression cannot be empty.");
				}
				else if(delimiter.equals("")){
					outputLabel.setForeground(Color.red);
					outputLabel.setText("Your delimiter cannot be empty.");
				}
				// Calculate result if both are non-empty
				else {
					// Attempt to calculate result and handle exceptions with appropriate warnings to user
					try {
						double result = RPNCalculator.calculate(expression, delimiter);
						String infixExpression = RPNCalculator.rpnToInfix(expression, delimiter);
						
						outputLabel.setForeground(Color.black);
						outputLabel.setText("<html><b>Your result:</b> " + result + "<br/><b>Infix expression:</b> " + infixExpression);
					} 
					catch (IllegalCalculationException e1) {
						outputLabel.setForeground(Color.red);
						outputLabel.setText("Your RPN expression is invalid.");
					} 
					catch (IllegalCharacterException e1) {
						outputLabel.setForeground(Color.red);
						outputLabel.setText("Your RPN expression contains an illegal character: " + e1.getMessage());
					} 
					catch (IllegalDelimiterException e1) {
						outputLabel.setForeground(Color.red);
						outputLabel.setText("The delimiter you set cannot be used: " + e1.getMessage());
					} catch (DivisionByZeroException e1) {
						outputLabel.setForeground(Color.red);
						outputLabel.setText("You cannot divide by 0.");
					}
				}
			}
		});
		
		// Clear both expression and delimiter input fields
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressionInput.setText("");
				delimiterInput.setText("");
			}
		});
		
		// Set delimiter input field to pre-defined delimiter values
		underscoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delimiterInput.setText("_");
			}
		});
		semicolonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delimiterInput.setText(";");
			}
		});
		commaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delimiterInput.setText(",");
			}
		});
		commaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delimiterInput.setText(",");
			}
		});
		spaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delimiterInput.setText(" ");
			}
		});
		
		
		// Add action listeners for debug panel
		// Create an instance of the Test class and run the automated tests
		runTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Test test1 = new Test();
				test1.run();
			}
		});
	}
	
	/**
	 * Set the visibility of the frame to 'true'
	 */
	public void show() {
		frame.setVisible(true);
	}

}
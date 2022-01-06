import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean playerTurn;
	
	
	
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150, 150, 150));
		
		for(int i =0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
			firstTurn();
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(playerTurn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						playerTurn = false;
						textField.setText("O Turn");
						check();
					}
				}else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						playerTurn = true;
						textField.setText("X Turn");
						check();
					}
				}
			}
		}
	}
	
	public void firstTurn() {
		
		if(random.nextInt(2) == 0) {
			playerTurn = true;
			textField.setText("X Turn");
		}else {
			playerTurn = false;
			textField.setText("O Turn");
		}
	}
	
	public void check() {
		for(int i = 0; i < 9; i += 3) {
			if(buttons[i].getText() == buttons[i + 1].getText() && buttons[i + 1].getText() == buttons[i + 2].getText()) {
				if(buttons[i].getText() == "X") {
					xWins(i, i + 1, i + 2);
				}else if(buttons[i].getText() == "O") {
					oWins(i, i + 1, i + 2);
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			if(buttons[i].getText() == buttons[i + 3].getText() && buttons[i + 3].getText() == buttons[i + 6].getText()) {
				if(buttons[i].getText() == "X") {
					xWins(i, i + 3, i + 6);
				}else if(buttons[i].getText() == "O") {
					oWins(i, i + 3, i + 6);
				}
			}
		}
		if(buttons[0].getText() == buttons[4].getText() && buttons[4].getText() == buttons[8].getText()) {
			if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
				xWins(0, 4, 8);
			}else if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
				oWins(0, 4, 8);
			}
		}
		if(buttons[2].getText() == buttons[4].getText() && buttons[4].getText() == buttons[6].getText()) {
			if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
				xWins(2, 4, 6);
			}else if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
				oWins(2, 4, 6);
			}
		}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("X wins");
		
	}
	
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("O wins");
	}
	

}

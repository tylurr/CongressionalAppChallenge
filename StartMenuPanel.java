import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartMenuPanel extends JPanel implements ActionListener {
	
	public static final String[] wordLengths = {"2", "3", "4", "5"};
	
	private JLabel gameLabel;
	private JLabel messageLabel;
	private JLabel wordLengthLabel;
	private JComboBox wordLengthsList;
	private JLabel nameLabel;
	private JTextField nameField;
	private JButton startButton;
	
	//the start menu panel talks to the game window, which can talk to the actual game
	private GameWindow window;
	
	//creates a new start menu panel inside the game window
	public StartMenuPanel(GameWindow window) {
		
		
		this.setSize( 1920, 1080 );
		this.setBackground( new Color(247, 196, 255) );
		this.setLayout( null );
		
		this.window = window;
		
		
		
		this.gameLabel = new JLabel("Guess A Word Game");
		this.gameLabel.setBackground( new Color(247, 196, 255) );
		this.gameLabel.setBounds( 350, 0, 600, 100 );
		this.gameLabel.setOpaque( true );
		this.gameLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.gameLabel.setHorizontalAlignment( JLabel.CENTER );
		this.add(this.gameLabel);
		
		this.messageLabel = new JLabel("");
		this.messageLabel.setBackground( new Color(247, 196, 255) );
		this.messageLabel.setBounds( 250, 100, 800, 100 );
		this.messageLabel.setOpaque( true );
		this.messageLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.messageLabel.setHorizontalAlignment( JLabel.CENTER );
		this.add(this.messageLabel);
		
		this.wordLengthLabel = new JLabel( "Select word length:" );
		this.wordLengthLabel.setBackground( new Color(247, 196, 255) );
		this.wordLengthLabel.setBounds( 0, 400, 600, 100 );
		this.wordLengthLabel.setOpaque( true );
		this.wordLengthLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.wordLengthLabel.setHorizontalAlignment( JLabel.RIGHT );
		this.add( this.wordLengthLabel );
		
		this.wordLengthsList = new JComboBox(wordLengths);
		this.wordLengthsList.setBackground( new Color(247, 196, 255) );
		this.wordLengthsList.setBounds(  700, 400, 500, 100 );
		this.wordLengthsList.setOpaque( true );
		this.wordLengthsList.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.add(wordLengthsList);
		
		this.startButton = new JButton("Start");
		this.startButton.setBackground( new Color(247, 196, 255) );
		this.startButton.setBounds( 350, 550, 600, 100 );
		this.startButton.setOpaque( true );
		this.startButton.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.add(this.startButton);
		

		this.nameLabel = new JLabel( "Enter your name:" );
		this.nameLabel.setBackground( new Color(247, 196, 255) );
		this.nameLabel.setBounds( 0, 250, 600, 100 );
		this.nameLabel.setOpaque( true );
		this.nameLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.nameLabel.setHorizontalAlignment( JLabel.RIGHT );
		this.add( this.nameLabel );
		
		this.nameField = new JTextField( 3 );
		this.nameField.setBackground( new Color(255, 255, 255) );
		this.nameField.setForeground( new Color(247, 196, 255) );
		this.nameField.setBounds( 700, 250, 500, 100 );
		this.nameField.setFont( new Font("Comic Sans MS", Font.BOLD, 36) );
		this.nameField.setHorizontalAlignment( JLabel.CENTER );
		this.add( this.nameField );
		
		
		this.wordLengthsList.addActionListener(this);
		this.startButton.addActionListener(this);
		
	}
	
	public int getSelectedWordLength() {
		return Integer.parseInt((String) wordLengthsList.getSelectedItem());
	
	}
	
	public String getUsername() {
		return this.nameField.getText();
	}
	
	/**
	 * 	Displays the given error message on the Game Panel's message 
	 * 	Label and changes the text color to indicate an error by the 
	 * 	player.
	 */
	public void displayError( String error )
	{
		this.messageLabel.setText( error );
		this.messageLabel.setForeground( new Color(201, 52, 85) );
	}
	
	
	private void onStartButtonClicked()
	{
		String username = nameField.getText();
		int wordLength = Integer.parseInt( (String) wordLengthsList.getSelectedItem() );
		this.window.startGame( username, wordLength );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == this.startButton) {
			this.onStartButtonClicked();
		}
		
	}
	
	
	
	
	
	

}

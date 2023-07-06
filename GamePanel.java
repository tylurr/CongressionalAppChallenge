import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GamePanel extends JPanel implements ActionListener{
	
	private JLabel titleLabel;
	private JLabel messageLabel;
	private JLabel guessLabel;
	private JLabel hintLabel;
	private JTextField guessField;
	private JButton guessButton;
	private JButton resetButton;
	private JButton wordListButton;
	private JButton hintButton;
		
	private GameWindow window;
	

	//creates a new game panel inside the game window
	public GamePanel(GameWindow window) {
		this.window = window;
		
		
		this.setSize( 1920, 1080 );
		this.setBackground( new Color(247, 196, 255) );
		

		this.setLayout( null );
		
		
		// Create and setup each of the COMPONENTS
		
		//setting up title
		this.titleLabel = new JLabel( "What word am I thinking of?" );
		this.titleLabel.setBackground( new Color(247, 196, 255) );
		this.titleLabel.setBounds( 0, 0, 1300, 100 );
		this.titleLabel.setOpaque( true );
		this.titleLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.titleLabel.setHorizontalAlignment( JLabel.CENTER );
		this.add( this.titleLabel );
		
		//setting up message
		this.messageLabel = new JLabel( "" );
		this.messageLabel.setBackground( new Color(247, 196, 255) );
		this.messageLabel.setBounds( 0, 100, 1300, 100 );
		this.messageLabel.setOpaque( true );
		this.messageLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.messageLabel.setHorizontalAlignment( JLabel.CENTER );
		this.add( this.messageLabel );
		
		this.hintLabel = new JLabel( "" );
		this.hintLabel.setBackground( new Color(247, 196, 255) );
		this.hintLabel.setBounds( 0, 175, 1300, 100 );
		this.hintLabel.setOpaque( true );
		this.hintLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.hintLabel.setHorizontalAlignment( JLabel.CENTER );
		this.add( this.hintLabel );
		
		//setting up guess section
		this.guessLabel = new JLabel( "Enter your guess:" );
		this.guessLabel.setBackground( new Color(247, 196, 255) );
		this.guessLabel.setBounds( 0, 300, 600, 100 );
		this.guessLabel.setOpaque( true );
		this.guessLabel.setFont( new Font("Comic Sans MS", Font.BOLD, 44) );
		this.guessLabel.setHorizontalAlignment( JLabel.RIGHT );
		this.add( this.guessLabel );
		
		this.guessField = new JTextField( 3 );
		this.guessField.setBackground( new Color(255, 255, 255) );
		this.guessField.setForeground( new Color(247, 196, 255) );
		this.guessField.setBounds( 700, 300, 500, 100 );
		this.guessField.setFont( new Font("Comic Sans MS", Font.BOLD, 36) );
		this.guessField.setHorizontalAlignment( JLabel.CENTER );
		this.add( this.guessField );
		
		//setting up reset button
		this.resetButton = new JButton( "Reset" );
		this.resetButton.setBackground( new Color(255, 255, 255) );
		this.resetButton.setForeground( new Color(247, 196, 255) );
		this.resetButton.setBounds( 350, 450, 300, 100 );
		this.resetButton.setFont( new Font("Comic Sans MS", Font.BOLD, 30) );
		this.resetButton.setFocusPainted( false );
		this.add( this.resetButton );		
		
		//setting up guess button
		this.guessButton = new JButton( "Guess" );
		this.guessButton.setBackground( new Color(255, 255, 255) );
		this.guessButton.setForeground( new Color(247, 196, 255) );
		this.guessButton.setBounds(350, 550, 300, 100 );
		this.guessButton.setFont( new Font("Comic Sans MS", Font.BOLD, 30) );
		this.guessButton.setFocusPainted( false );
		this.add( this.guessButton );		
		
		//setting up word list button
		this.wordListButton = new JButton( "Word List" );
		this.wordListButton.setBackground( new Color(255, 255, 255) );
		this.wordListButton.setForeground( new Color(247, 196, 255) );
		this.wordListButton.setBounds( 650, 450, 300, 100 );
		this.wordListButton.setFont( new Font("Comic Sans MS", Font.BOLD, 30) );
		this.wordListButton.setFocusPainted( false );
		this.add( this.wordListButton );	
		
		this.hintButton = new JButton( "Hint" );
		this.hintButton.setBackground( new Color(255, 255, 255) );
		this.hintButton.setForeground( new Color(247, 196, 255) );
		this.hintButton.setBounds( 650, 550, 300, 100 );
		this.hintButton.setFont( new Font("Comic Sans MS", Font.BOLD, 30) );
		this.hintButton.setFocusPainted( false );
		this.add( this.hintButton );	
		
		
		this.resetButton.addActionListener(this);
		this.guessButton.addActionListener(this);
		this.wordListButton.addActionListener(this);
		this.hintButton.addActionListener(this);

	}
	
	public JLabel getMessageLabel() {
		return this.messageLabel;
	}
	
	public JLabel getHintLabel() {
		return this.hintLabel;
	}
	
	private void onGuessButtonClicked()
	{
		//added to lowercase
		String guess = this.guessField.getText().toLowerCase();
		this.window.guessWord(guess);
	}
	
	private void onResetButtonClicked() {
		this.window.resetGame();
		this.guessField.setText("");
		this.messageLabel.setText("");
		this.hintLabel.setText("");
		this.messageLabel.setForeground(new Color(0,0,0));
		
	}
	
	private void onWordListButtonClicked() {
		String wordList = "";
		
		for (int i = 0; i < GuessWordGame.secretWordList.length; i++) {
			String s = GuessWordGame.secretWordList[i];
			
			if (s.length() == this.window.getGuessWordGame().getWordLength()) {
					wordList += "\n" + s; 
			
			}
			
		}
		UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
		JOptionPane.showMessageDialog(null, wordList, "Word List", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void onHintButtonClicked() {
		this.window.displayHint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object button = e.getSource();
		if ( button == this.resetButton )
		{
			this.onResetButtonClicked();
			
		}

		
		else if ( button == this.guessButton )
		{
			this.onGuessButtonClicked();
			
		}
		
		else if ( button == this.wordListButton )
		{
			this.onWordListButtonClicked();

		}
		
		else if (button == this.hintButton) {
			this.onHintButtonClicked();
		}
	}
	
	
	
	/**
	 * 	Displays the given message on the Game Panel's message Label with 
	 * 	normal default text color.
	 */
	public void displayMessage( String message )
	{
		this.messageLabel.setText( message );
		this.messageLabel.setForeground( new Color(0, 0, 0) );
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
	
	/**
	 * 	Displays the given message when the player has won the game, 
	 * 	this method displays the message on the Game Panel's message 
	 * 	Label and changes the text color to indicate the player has 
	 * 	beaten the game.
	 */
	public void displayWinner( String message )
	{
		this.messageLabel.setText( message );
		this.messageLabel.setForeground( new Color(33, 166, 99) );
	}
	
	public void displayHint(String hint) {
		this.hintLabel.setText("Hint: " + hint);
		
	}
	
	
	
	



	
	
	
}

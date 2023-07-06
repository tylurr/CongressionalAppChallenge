
import java.awt.Color;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	//components of the gui, which are inside the game window
	private StartMenuPanel startMenuPanel;
	private GamePanel gamePanel;

	
	/** Game so that the Window can communicate Inputs */
	private GuessWordGame game;
	
	
	
	/**
	 * 	Creates a new Game Window for the given GuessAWord Game.
	 */
	public GameWindow( GuessWordGame game )
	{
		// Store the game so the Window can talk to it when
		//	INPUT EVENTS occurs
		this.game = game;
		
		
		// Setup the WINDOW details
		this.setTitle( "Guess a Word!" );
		this.setSize( 1920, 1080 );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.getContentPane().setBackground( new Color(247, 196, 255) );
		this.setLayout( null );
		
		this.startMenuPanel = new StartMenuPanel(this);
		this.add(this.startMenuPanel);
		
		this.gamePanel = new GamePanel(this);
		this.gamePanel.setVisible(false);
		this.add(this.gamePanel);

		
		
		
		
	}
	
	public StartMenuPanel getStartMenuPanel() {
		return this.startMenuPanel;
	}
	
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	public GuessWordGame getGuessWordGame() {
		return this.game;
	}
	
	
	
	/**
	 * 	Starts the Game Panel. I.e., makes it appear on screen.
	 */
	public void startGame( String username, int wordLength )
	{
		this.game.startGame( username, wordLength );
	}
	
	public void resetGame() {
		this.game.reset();
	}
	
	public void guessWord(String guess) {
		this.game.guessWord(guess);
	}
	
	public void displayHint() {
		this.game.displayHint();
	}

}



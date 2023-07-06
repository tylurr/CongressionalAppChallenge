
import java.util.ArrayList;


public class GuessWordGame {

	
	/** 
	 * 	GUI Window that the game displays stuff on, 
	 * 	and receives Inputs from 
	 */
	private GameWindow window;
	
	
	
	/** Word the player is trying to guess */
	private String secretWord;
	
	private String username;
	
	private int wordLength;
	
	public static final String[] secretWordList = {"the","of","and","to","in","is","you","that","it",
	"he","was","for","on","are","as","with","his","they","at","be","this","have","from","or","one","had",
	"by","word","but","not","what","all","were","we","when","your","can","said","there","use",
	"an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them",
	"these","so","some","her","would","make","like","him","into","time","has","look","two","more",
	"write","go","see","number","no","way","could","people","my","than","first","water","been","call","who",
	"oil","its","now","find","long","down","day","did","get","come","made","may","part"};
	
	/** The number of attempts to guess the secret word */
	private int tries;
	
	/** True if the player guessed the word correctly */
	private boolean winner;

	
	
	/**
	 * 	Creates a new Guess-A-Word Game, which will create the 
	 * 	Game Window.
	 */
	public GuessWordGame()
	{

		this.window = new GameWindow(this);
	}
	
	public void start() {
		//sets visibility of window to true, which displays the start menu panel
		this.window.setVisible(true);
	}
	
	
	/**
	 * 	Resets the Guess A Word game. This will pick a new secret
	 * 	number with the given length and display 
	 * 	the starting message.
	 */
	public void reset()
	{
		this.secretWord = this.pickSecretWord(this.wordLength);
		this.tries = 0;
		this.winner = false;
		
		
	}
	
	/**
	 * 	Randomly chooses a new secret word in the list of words using the desired length of the words
	 */
	private String pickSecretWord(int wordLength)
	{
		
		ArrayList<String> sortedSecretWordList = this.getSortedSecretWordList(wordLength);
		int secretWordIndex = (int)(Math.random() * sortedSecretWordList.size() + 1);
		return sortedSecretWordList.get(secretWordIndex);
	}
	
	public ArrayList<String> getSortedSecretWordList (int wordLength) {
		ArrayList<String> sortedSecretWordList = new ArrayList<String>();
		
		for (int i = 0; i < secretWordList.length; i++) {
			if (secretWordList[i].length() == wordLength) {
				sortedSecretWordList.add(secretWordList[i]);
			}
		}
		
		return sortedSecretWordList;

	}
	
	/**
	 * 	Starts the guess a word game. This will pick a new secret 
	 * 	word in the list of words, tell the Game Panel what message to start 
	 * 	off with, and then show the game panel
	 */
	
	public void startGame( String username, int wordLength ) {
		if (this.isValidInput(username) ) {
			this.window.getStartMenuPanel().setVisible(false);
			this.window.getGamePanel().setVisible(true);
			this.wordLength = wordLength;
			this.username = username;
			this.secretWord = this.pickSecretWord(wordLength);
		}
		else {
			this.window.getStartMenuPanel().displayError("Input only letters.");
		}
	}
	
	public void guessWord(String guess) {
		
		if ( this.winner ) {
			return;	
		}
		
		if ( !this.isValidInput(guess) ) {
			this.window.getGamePanel().displayError("Input only letters.");
		}

		else {
			this.tries ++;
			
			if ( !guess.equals(this.secretWord) ) {
				this.window.getGamePanel().displayMessage(this.username + ", Incorrect Guess!");

			}
			
			else if (guess.equals(secretWord)) {
				
				if (tries == 1) {
					this.window.getGamePanel().displayWinner(this.username + ", you win! It took you " + this.tries + " try!");
					this.winner = true;	
				}
				
				else if (tries > 1) {
					this.window.getGamePanel().displayWinner(this.username + ", you win! It took you " + this.tries + " tries!");
					this.winner = true;	
				}
				
			}
			
		}
		
	}
	

	
	public int getWordLength() {
		return this.wordLength;
	}
	
	public String getHint() {
		
		if (this.winner == false) {
			String dashes = "";
			
			for (int tries = this.tries; tries < this.wordLength; tries++ ) {
				dashes += "-";
			}
			
			
			String hint = this.secretWord.substring(0, this.tries) + dashes;
			return hint;
			
		}
		
		else {
			String hint = "You already won!";
			return hint;
		}
		
		
		
	}
	
	
	public void displayHint() {
		String hint = this.getHint();
		this.window.getGamePanel().displayHint(hint);
	}

	
	/**
	 * 	Returns true if the given guess has only letters in it
	 */
	
	public boolean isValidInput( String input ) {
		//checks if the string contains no characters
		if (input.length() == 0) {
			return false;
	    }
		int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
            // checks whether the character is not a letter
            // if it is not a letter , it will return false
	        if ((this.isLetter(input.charAt(i)) == false)) {
	        	return false;
	        }
        }
        
        return true;
       
	}
	
	
	public boolean isLetter(char c) {
		
		boolean isUppercaseLetter = (c >= 'A') && (c <= 'Z');
		boolean isLowercaseLetter = (c >= 'a') && (c <= 'z');
		return isUppercaseLetter || isLowercaseLetter;
	}
	
	
}

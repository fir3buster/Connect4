
import java.util.Random;

// Inheritance of items from Superclass Player
// Extension from Player abstract class
// Creating a bot/computer that can randomly place the counter
public class BotPlayer extends Player{

    private Random random;

    public BotPlayer(char counter){
        super(counter);
        random = new Random();
    }
    
    public int getMove(){
	    return random.nextInt(7)+1;
	}

    public boolean isBOT(){
        return true;
    } 
    
}
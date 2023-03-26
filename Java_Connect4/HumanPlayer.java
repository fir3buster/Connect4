
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Inheritance of items from Superclass Player
// Extension from Player abstract class
// Create Humanplayer 
public class HumanPlayer extends Player{

    private BufferedReader BuffR;

    public HumanPlayer(char counter){ 
        super(counter);
        BuffR = new BufferedReader(new InputStreamReader(System.in));
    }
  
    public int getMove(){
		try{		
			return Integer.parseInt(BuffR.readLine());
		    }
		catch(IOException e){	
            return -1;
		}
	}

    public boolean isBOT(){
        return false;
    }

}   
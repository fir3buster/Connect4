
import java.util.ArrayList;

//Class ConnectFourGame to run the game 
public class ConnectFourGame{
	
    public ConnectFourGame(){
		playGame();
	}

	private void playGame(){
        // Printout Message for the rules and gameplay of G
        System.out.println("");
        System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red which uses 'r', Player 2 is Yellow which uses 'y'");
		System.out.println("To play the game type in the number of the column you want to drop your counter in");
		System.out.println("A player wins by connecting 4 counters in a row -  vertically, horizontally or diagonally");
		System.out.println("");

        // Polymorphism. Instance of MyBoard class.
        MyBoard board = new MyBoard(); // Create a board object
        
        // Polymorphism. Instance of Display class.
        // Displaying the board
        Display show = new CLDisplay(); // Create a show object
        show.view(board.printBoard()); 

        System.out.println("Enter any number from 1-7: ");
        System.out.println("");
        
        // Create player in Red and bot/computer in Yellow.
        ArrayList<Player> gamer = new ArrayList<>();
        gamer.add(new HumanPlayer('r'));
        gamer.add(new BotPlayer('y'));
        int currentPlayer = 0;
		
        boolean win = false;
		while(!win){
            boolean hasWon = false;
            // Check if the board is full
            board.boardisfull();
            //below takes the counter and column value from player
            int move = gamer.get(currentPlayer).getMove();
            char counter = gamer.get(currentPlayer).getCounter();
            int newMove = checkMove(move, counter);
       
            // provide an if statement to check the correct classes 
            if(gamer.get(currentPlayer) instanceof HumanPlayer){
                board.placeCounter(counter,checkCol(newMove,board.getMyBoard(),counter));
                System.out.println("Player has moved: " + newMove);
            }
            else{
                board.placeCounter(counter,checkColCom(newMove,board.getMyBoard(),counter));
                System.out.println("Computer has moved: " + newMove);
            } 
			
        // check if the player (Human or Bot/Computer) has won
        hasWon = board.hasWon(counter);
        show.view(board.printBoard());
        System.out.println("");

        //switches to the next player
        currentPlayer = (currentPlayer+1)%gamer.size();
      
        //If either one of the player (Human or Bot/Computer) has won. Print player has won and try again.
			if(hasWon){
                System.out.println(counter +" has won. Please try again.");
				win = true;
			}
		}
	}

    //Setting a boundary. Whenever any of the column that Human put in is full. They have to reselect other column.
    public int checkCol(int move, char[][] board, char counter){
        Player playerHolder = new HumanPlayer(counter);
        
        while(board[move-1][0] == 'r' || board[move-1][0] == 'y'){
            System.out.println("column is full, enter another column");
            move = playerHolder.getMove();
        }
        return move;
    }

    // Applicable to Bot/Computer as well. Setting a boundary for Bot and they have to reselect any other column when the selected ones is full.
    public int checkColCom(int random, char[][] board, char counter){
        // Polymorphism. Creating playerHolder for Bot/Computer.
        Player playerHolder = new BotPlayer(counter);
        while(board[random-1][0] == 'r' || board[random-1][0] == 'y'){
            random = playerHolder.getMove();
        }
        return random;
    }

    // Setting Board boundary that the counter move is within the board range.
    public int checkMove(int move, char counter){
        // Polymorphism. Creating playerHolder object for Humanplayer.
        Player playerHolder = new HumanPlayer(counter);

        // Numbers allowed to enter between 1 and 7, both included.
        while(move < 1 || move > 7){
        System.out.println("invalid input, Enter any number from 1-7");
			move = playerHolder.getMove();
        }
        return move;
    }
  
}

// Class MyBoard dealing with the board of the game
// Partially encapsulated class, with private data member of board.
public class MyBoard{
    private char[][] board;

    // Constructor MyBoard
    public MyBoard() {
    //gives you to have board of size n in row and n+1 in column  
        board = new char[7][8]; 
    }

    // Getter of MyBoard
    public char[][] getMyBoard(){
        return board;
    }
  
    //Checking if the board is full. The Match will result in a draw if the board is full.
    public void boardisfull(){
        int count = 0;

        for(int i=0; i < board.length-1; i++){
            for(int j=0; j < board[i].length-1; j++){
                // to include both counts of either player/computer 
                if(board[i][j] == 'r' || board[i][j] == 'y'){ 
                    count = count + 1;
                    if(count == 42){ //depending on board size
                        System.out.println("This game is a draw! Please replay the game.");
                        System.exit(0); //game ended up in draw. Exit Game!
                    }
                }
            }
        }
    }
  
    // Subsequently, printing out the board after players' move
    public String printBoard(){
        String toPrint = ""; // def variable for print out
        
        for(int i=0; i < board.length-1; i++){
            for(int j=0; j < board[i].length-1; j++){
				if(board[j][i] == 'r'){
					toPrint += ("| r ");
				}
				else if(board[j][i] == 'y'){
					toPrint += ("| y ");
				}
				else{
					toPrint += ("|   ");
				}
			}
			toPrint += ("|\n");
		}

		toPrint += ("  1   2   3   4   5   6   7");
        return toPrint;
    }

    //Placing a counter on the board
    public void placeCounter(char player, int position){
        boolean placed = false;

		if(player == 'r'){
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[position-1][i-1] == 'y'){
						// skip
					}
					else if(board[position-1][i-1] != 'r'){
						board[position-1][i-1] = 'r';
						placed = true;       
					}
				}
			}
		}
		else{
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[position-1][i-1] == 'r'){
						// skip
					}
					else if(board[position-1][i-1] != 'y'){
						board[position-1][i-1] = 'y';
						placed = true;
					} 
				}
			}
		}
    }

    //Checking if Player/Computer has won the game on following conditions: Vertical / Horizontal / Diagonal
    //Getting reference from provided MyConnectFour.java
    public boolean hasWon(char player){ 
        
        //Check for horizontal
        int count = 0;

        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i] == player){
                    count = count + 1;
                    if(count >= 4){
                        return true;
                    }
                }
                else{
                    count = 0;
                }
            }
  		    count = 0;
        }

        //Check for vertical
        count = 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == player){
                    count = count + 1;
                    if(count >= 4){
                        return true;
                    }
                }
                else{
                    count = 0;
                }
            }
            count = 0;	
        }
        
        //check down-right (bottom)
        count = 0;

        for (int i = 0; i < board.length; i++) {			
			for (int j = i, k = 0; j < board.length && k < board[0].length; j++, k++){
				if(board[j][k] == player) {
					count = count + 1;
					if(count >= 4){ 
						return true;
					}
				}
				else{
                    count = 0;
				}
			}
            count = 0;
		}
		
		//check up-right (bottom)
		count = 0;
        for (int i = 0; i < board[0].length; i++) {	
			for (int j = board.length - 1, k = i; j >= 0 && k < board[0].length; j--, k++){
				if(board[j][k] == player) {
					count = count + 1;
					if(count >= 4){ 
						return true;
					}
				}
				else{
                    count = 0;
				}
			}
            count = 0;
		}
		
        //check down-right (top)
		count = 0;

        for (int i = 1; i < board[0].length; i++) {			
			for (int j = 0, k = i; j < board.length && k < board[0].length; j++, k++){
				if(board[j][k] == player) {
					count = count + 1;
					if(count >= 4){ 
						return true;
					}
				}
				else{
                    count = 0;
				}
			}
            count = 0;
		}
		
		//check up-right (top)
		count = 0;
        for (int i = board.length - 2; i >= 0; i--) {	
			for (int j = i, k = 0; j >= 0 && k < board[0].length; j--, k++){
				if(board[j][k] == player) {
					count = count + 1;
					if(count >= 4){ 
						return true;
					}
				}
				else{
                    count = 0;
				}
			}
            count = 0;
		}
    return false;
    }
}
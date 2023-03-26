
// Encapsulation of class Player, with private data member of counter.
public abstract class Player{

    private char counter;

    public Player(char counter){
        this.counter = counter;
    }
    
    public char getCounter(){
        return counter;
    }

    // Showing and returning the move the Player (Human/Bot) wants to make 
    abstract int getMove();

    // Checking whether the Player is Bot/Computer.
    abstract boolean isBOT();
    
}
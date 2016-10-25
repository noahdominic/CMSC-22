public class Player{
    public int score;
    private int move;

    public Player(){score = 0; move = 0;}
    public void reset(){
        score = 0;
        move = 0;
    }
    public void setMove(int x){move = x;}
    public int getMove(){return move;}
    public void incScore(){
        score++;;
    }
}
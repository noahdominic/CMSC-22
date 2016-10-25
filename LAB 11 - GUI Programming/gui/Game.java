/**
 * Created by Noah Dominic on 25/10/2016.
 */
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Game extends Frame {

    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static final int LIZARD = 4;
    public static final int SPOCK = 5;

    private String[] moveList;

    private Label lblChoice;

    private Panel moveChoice;

    private CheckboxGroup move;
    private Checkbox rock;
    private Checkbox paper;
    private Checkbox scissors;
    private Checkbox lizard;
    private Checkbox spock;

    private TextArea display;

    private Button playbutton;

    private Panel disScr;

    private Label lblplyrscor;
    private Label lblopponentscor;

    private TextField displayerscr;
    private TextField discompscr;

    private Dialog gameover;

    private Player me;
    private Player comp;


    public Game(){
        me = new Player();
        comp = new Player();
        moveList =  new String[] {"ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK"};
        setLayout(new FlowLayout());
        lblChoice = new Label("Your Choice");

        moveChoice = new Panel(new GridLayout(0, 1));

        move = new CheckboxGroup();
        rock = new Checkbox("Rock", move, true);
        paper = new Checkbox("Paper", move, false);
        scissors = new Checkbox("Scissors", move, false);
        lizard = new Checkbox("Lizard", move, false);
        spock = new Checkbox("Spock", move, false);
        moveChoice.add(lblChoice);
        moveChoice.add(rock);
        moveChoice.add(paper);
        moveChoice.add(scissors);
        moveChoice.add(lizard);
        moveChoice.add(spock);
        add(moveChoice);

        display = new TextArea("GAME START", 8, 22);
        display.setEditable(false);
        add(display);

        playbutton = new Button("RockPaperScissorsLizardSpock!");
        add(playbutton);

        disScr = new Panel(new GridLayout(2, 2));
        lblplyrscor = new Label("Player's Score");
        lblopponentscor = new Label("Computer's Score");
        displayerscr = new TextField(String.format("%d",me.score), 1);
        discompscr = new TextField(String.format("%d",me.score), 1);
        displayerscr.setEditable(false);
        discompscr.setEditable(false);
        disScr.add(lblplyrscor);
        disScr.add(displayerscr);
        disScr.add(lblopponentscor);
        disScr.add(discompscr);
        add(disScr);

        setTitle("RockPaperScissorsLizardSpock");
        setSize(300,275);
        setVisible(true);


        //for closing this
        addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent we) {
                  dispose();
              }
        });

        playbutton.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if(me.score < 5 && comp.score < 5) { playGame(); }
                }
            }
            public void mousePressed(MouseEvent e){;}
            public void mouseReleased(MouseEvent e){;}
            public void mouseEntered(MouseEvent e){;}
            public void mouseExited(MouseEvent e){;}
        });
    }

    public void playGame(){
    	//checks which value hand they (user & computer) played
        checkMove();

        //gives points to the winner of round
        givePoints();

        //displays dialog if game is over
        isGameOver();

        //refreshes players' scores bc for some reaosn they don't
        displayerscr.setText(String.format("%d",me.score));
        discompscr.setText(String.format("%d",comp.score));
    }

    public void checkMove(){
        if(rock.getState() == true) {me.setMove(ROCK);
        } else if(paper.getState() == true) {me.setMove(PAPER);
        } else if(scissors.getState() == true) {me.setMove(SCISSORS);
        } else if(lizard.getState() == true) {me.setMove(LIZARD);
        } else if(spock.getState() == true) {me.setMove(SPOCK);}

        comp.setMove((int)(Math.random() * 5 + 1));

        display.replaceRange("Player chose " + moveList[me.getMove()-1] + "\nComputer chose " + moveList[comp.getMove() -1] + ".\n", 0, 100);
    }

    public void givePoints(){
        if(me.getMove() == comp.getMove()){
            display.append("\n\nIT'S A DRAW");
        } else if(me.getMove() == ROCK) {
            if (comp.getMove() == LIZARD || comp.getMove() == SCISSORS){
                me.incScore();
                display.append("\n\nYOU WIN THIS ROUND.");
            } else if(comp.getMove() == PAPER || comp.getMove() == SPOCK){
                comp.incScore();
                display.append("\n\nYOU LOST THIS ROUND.");
            }
        } else if (me.getMove() == PAPER) {
            if (comp.getMove() == SPOCK || comp.getMove() == ROCK){
                me.incScore();
                display.append("\n\nYOU WIN THIS ROUND.");
            } else if (comp.getMove() == SCISSORS || comp.getMove() == LIZARD){
                comp.incScore();
                display.append("\n\nYOU LOST THIS ROUND.");
            }
        } else if (me.getMove() == SCISSORS) {
            if (comp.getMove() == PAPER || comp.getMove() == LIZARD) {
                me.incScore();
                display.append("\n\nYOU WIN THIS ROUND.");
            } else if (comp.getMove() == ROCK || comp.getMove() == SPOCK){
                comp.incScore();
                display.append("\n\nYOU LOST THIS ROUND.");
            }
        } else if (me.getMove() == LIZARD) {
            if (comp.getMove() == SPOCK || comp.getMove() == PAPER){
                me.incScore();
                display.append("\n\nYOU WIN THIS ROUND.");
            } else if(comp.getMove() == ROCK || comp.getMove() == SCISSORS){
                comp.incScore();
                display.append("\n\nYOU LOST THIS ROUND.");
            }
        } else if (me.getMove() == SPOCK) {
            if (comp.getMove() == SCISSORS || comp.getMove() == ROCK){
                me.incScore();
                display.append("\n\nYOU WIN THIS ROUND.");
            } else if (comp.getMove() == LIZARD || comp.getMove() == PAPER) {
                comp.incScore();
                display.append("\n\nYOU LOST THIS ROUND.");
            }
        }
    }

    public void gameReset(){
        me.reset();
        comp.reset();
        display.setText("GAME START");
    }

    public void isGameOver() {
        if(me.score >= 5 || comp.score >= 5) {
            gameover = new Dialog(this, "GAME OVER");
            gameover.setLayout(new FlowLayout());
            if(comp.score >= 5) {
                gameover.add(new Label("GAME OVER. COMPUTER WON..."));
            } else if (me.score >=5){
                gameover.add(new Label("GAME OVER. YOU WON!"));
            }
            Button b = new Button("Press to Restart");
            gameover.add(b);

            gameover.setSize(300, 100);
            if(gameover.isVisible() == false)
            	gameover.setVisible(true);

            //if user closes dialog box, game ends
            gameover.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    gameover.dispose();
                    dispose();
                }
            });

            //mouse listener for button
            b.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        gameover.dispose();
                        gameReset();

                        displayerscr.setText(String.format("%d",me.score));
                        discompscr.setText(String.format("%d",comp.score));
                    }
                }

                public void mousePressed(MouseEvent e) {
                    ;
                }

                public void mouseReleased(MouseEvent e) {
                    ;
                }

                public void mouseEntered(MouseEvent e) {
                    ;
                }

                public void mouseExited(MouseEvent e) {
                    ;
                }
            });
        }
    }

    public static void main (String[] args){
        new Game();
    }

}


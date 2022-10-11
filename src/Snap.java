import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame{
        CardGame game = new CardGame();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        int previousCardValue = 0;
        String snap = "";
        boolean gameOver = false;
        public void play(){
            introduction();
            while(!gameOver){
                askToDealCard(Player.getPlayer());
                System.out.println(game.dealCard().toString());
                if(previousCardValue == game.dealCard().getNumber()){
                    System.out.println("");
                    lookForSnap();
                    gameOver = true;
                }
                previousCardValue = game.dealCard().getNumber();
                Player.switchTurn();
                game.shuffleDeck();
                askToDealCard(Player.getPlayer());
                System.out.println(game.dealCard().toString());
                if(previousCardValue == game.dealCard().getNumber()){
                    System.out.println("");
                    lookForSnap();
                    gameOver = true;
                }
                previousCardValue = game.dealCard().getNumber();
                Player.switchTurn();
                game.shuffleDeck();
            }
        }
        public void introduction(){
            System.out.println();
            System.out.println("WELCOME TO SNAP");
            System.out.println();
        }
        public void askToDealCard(int player){
            System.out.println();
            System.out.println("Player " + player + "'s turn");
            System.out.println("PRESS ENTER to deal card");
            scanner.nextLine();
            System.out.println();
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!snap.equalsIgnoreCase("snap")){
                    lostMessage();
                    System.exit(0);
                }
            }
        };
        public void lookForSnap(){
            Timer timer = new Timer();
            timer.schedule(timerTask, 2000);
            snap = scanner.nextLine();
            timer.cancel();
            if(snap.equalsIgnoreCase("snap")){
                winningMessage();
            }
            else{
                lostMessage();
            }
        }
        public void winningMessage(){
            System.out.println();
            System.out.println("Player " + player.getPlayer() + " Won");
        }
        public void lostMessage(){
            System.out.println();
            System.out.println("Too slow, player " + player.getPlayer() + " lost");
        }
}

/**
 * This class represents the game management.
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class GameManagement {

    private final Rounds rounds = new Rounds();
    private final Random random = new Random();
    public Player player1 = new Player();
    public Player player2 = new Player();
    private final RoundsForTwoPlayers roundsForTwoPlayers = new RoundsForTwoPlayers();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method is used for one player game
     */

    public void OnePlayerGame (int numberOfPlayers) throws IOException {
        long input = 0;
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        player1.setName(name);
        int randomRounds;
        rounds.thirdRound(player1,player2,numberOfPlayers);
        for (int i=0;i<3;i++){
            randomRounds = random.nextInt(3);
            if (randomRounds == 0){
                rounds.firstRound(player1,player2,numberOfPlayers);
            }else if (randomRounds == 1){
                rounds.secondRound(player1,player2,numberOfPlayers);
            }else{
                rounds.secondRound(player1,player2,numberOfPlayers);
            }
        }
        System.out.println("End of the game " + player1.getName() + ", your final score is:" + player1.getScore());
    }


    /**
     * This method is used for multiplayer!
     */

    public void TwoPLayersGame () throws IOException {
        int input = 0;
        int input2 = 0;
        String playersName;
        System.out.println("First player,what's your name?");
        playersName = scanner.nextLine();
        player1.setName(playersName);
        System.out.println("Second player,what's your name?");
        playersName = scanner.nextLine();
        player2.setName(playersName);
        for (int i=0;i<4;i++){
            int randomRounds = random.nextInt(5);
            if (randomRounds == 0){
                rounds.firstRound(player1,player2,2);
            }else if (randomRounds == 1){
                rounds.secondRound(player1,player2,2);
            }else if (randomRounds == 2){
                rounds.thirdRound(player1,player2,2);
            }else if (randomRounds == 3){
                roundsForTwoPlayers.fourthRound(player1,player2);
            }else{
                roundsForTwoPlayers.multFirstRound(player1,player2);
            }
        }
        System.out.println("End of the game " + player1.getName() + ", your final score is:" + player1.getScore());
        System.out.println("End of the game " + player2.getName() + ", your final score is:" + player2.getScore());
    }


    /**
     * This method unites the rounds for implementation.
     */

    public void Play () throws IOException {
        System.out.println("How many players will play the game? (1 or 2)");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        if (numberOfPlayers == 1) {
            OnePlayerGame(numberOfPlayers);
        } else {
            TwoPLayersGame();
        }
    }
}



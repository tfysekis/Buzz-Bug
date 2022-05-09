/**
 *This class represents the rounds of the game.
 */

import jdk.jshell.spi.SPIResolutionException;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Rounds {

    private int points = 0;
    private int bet;
    private int secondBet;
    private String answer;
    private String rightAnswer;
    private String secondAnswer;
    private final RoundsForTwoPlayers roundsForTwoPlayers = new RoundsForTwoPlayers();
    private final RandomQuestions questions = new RandomQuestions();
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final String[] category = new String[3];
    /**
     * The constructor Rounds is used for initialization of the
     * the list categories
     */

    public Rounds() {
        category[0] = "Food";
        category[1] = "Films";
        category[2] = "Technology";
    }


    /**
     * This method represents the first round of the game.If the player
     * finds the right answer he wins 1000 points.
     */

    public void firstRound(Player player1, Player player2, int numberOfPlayers) {
        System.out.println("Prepare for the first round!");
        System.out.println("The answer must be A B C or D");
        if (numberOfPlayers == 2) {
            roundsForTwoPlayers.multFirstRound(player1, player2);
        } else {
            for (int i = 0; i < 2; i++) {
                questions.ShowQuestion(category[i]);
                answer = scanner.nextLine();
                rightAnswer = questions.getRightAnswer();
                if (answer.equals(rightAnswer)) {
                    player1.setScore(1000);
                } else {
                    System.out.println("Wrong Answer");
                    System.out.println("The right answer is: " + rightAnswer);
                }
                System.out.println("Your score is: " + player1.getScore());
            }
        }
    }

    /**
     * This method represents the second round of the game.The player
     * bets an amount of points and if he finds the right answer
     * he wins his risky punt.
     */

    public void secondRound(Player player1, Player player2, int numberOfPlayers) {

        System.out.println("Second round!");
        System.out.println("The answer must be A B C or D");

        for (int i = 0; i < 2; i++) {
            int randomElement = random.nextInt(category.length);
            System.out.println("This is a " + category[randomElement] + " category!");
            System.out.println("You can bet 250,500,750 or 1000 points in this category.What's your choice (write the number of your choice) " + player1.getName() + "?");
            int bet = scanner.nextInt();
            if (numberOfPlayers == 2) {
                System.out.println("What's your bet " + player2.getName() + "?");
                secondBet = scanner.nextInt();
                scanner.nextLine();
                roundsForTwoPlayers.multSecondRound(player1, player2, randomElement);
            } else {
                scanner.nextLine();
                questions.ShowQuestion(category[randomElement]);
                answer = scanner.nextLine();
                rightAnswer = questions.getRightAnswer();
                if (answer.equals(rightAnswer)) {
                    player1.setScore(points + bet);
                    System.out.println("You score is: " + player1.getScore());
                } else {
                    player1.setScore(points - bet);
                    System.out.println("Wrong Answer");
                    System.out.println("The right answer is: " + rightAnswer);
                }
            }
        }
    }

    /**
     * In this round the player has 5 seconds to answer the question . If he finds the right answer
     * then the remaining milliseconds multiplied by 0,2 will be added to his current score.
     */
    public void thirdRound(Player player1, Player player2, int numberOfPlayers) {

        int startTime;
        int stopTime;
        int remainingTime;
        int remainingTime2 = 0;

        System.out.println("Third round!");
        System.out.println("You have 5 seconds to answer each question.");
        System.out.println("The remaining milliseconds  will be added to your score multiplied by 0,2");
        System.out.println("The answer must be A B C or D");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lets go " + player1.getName() + "!");
        for (int i = 0; i < 2; i++) {
            questions.ShowQuestion(category[i]);
            startTime = (int) System.currentTimeMillis();
            answer = scanner.nextLine();
            stopTime = (int) System.currentTimeMillis();
            remainingTime = 5000 - (stopTime - startTime);
            if (numberOfPlayers == 2) {
                roundsForTwoPlayers.multThirdRound(player1, player2);
            }
            rightAnswer = questions.getRightAnswer();
            if (remainingTime < 0) {
                System.out.println("Sorry, you run out of time " + player1.getName() + "!");
            } else if (rightAnswer.equals(answer)) {
                int score = (int) (remainingTime * 0.2);
                System.out.println("Correct");
                player1.setScore(score);
            } else {
                System.out.println("Wrong answer!");
            }
        }
    }

}
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RoundsForTwoPlayers {

    private String answer;
    private int points = 0;
    private int bet;
    private int secondBet;
    private String secondAnswer;
    private String rightAnswer;
    private  Scanner scanner = new Scanner(System.in);
    private  RandomQuestions questions = new RandomQuestions();
    private  Random random = new Random();
    private  String[] category = new String[3];


    public RoundsForTwoPlayers() {
        category[0] = "Food";
        category[1] = "Films";
        category[2] = "Technology";
    }

    /**
     * This method is used for multiplayer for the
     * first round.
     * @param player1 status of the first player.
     * @param player2 status of the second player.
     */

    public void multFirstRound(Player player1, Player player2) {
        for (int i = 0; i < 2; i++) {
            System.out.println("The answer must be A B C or D");
            questions.ShowQuestion(category[i]);
            System.out.println(player1.getName() + " your turn!");
            answer = scanner.next();
            scanner.nextLine();
            System.out.println(player2.getName() + " your turn!");
            secondAnswer = scanner.nextLine();
            rightAnswer = questions.getRightAnswer();
            if (answer.equals(rightAnswer)) {
                player1.setScore(1000);
            } else {
                System.out.println("Wrong Answer " + player1.getName());
                System.out.println("The right answer is: " + rightAnswer);
            }
            if (secondAnswer.equals(rightAnswer)) {
                player2.setScore(1000);
            } else {
                System.out.println("Wrong Answer " + player2.getName());
                System.out.println("The right answer is: " + rightAnswer);
            }
            System.out.println(player1.getScore() + ",your score " + player1.getName());
            System.out.println(player2.getScore() + ",your score " + player2.getName());
        }
    }

    /**
     * This method is used for multiplayer, for
     * the second round,with the help of the
     * single player secondRound
     * @param player1 status of the first player.
     * @param player2 status of the second player.
     * @param randomElement randomElement for the optimization of the category.
     */

    public void multSecondRound(Player player1, Player player2, int randomElement) {
        questions.ShowQuestion(category[randomElement]);
        System.out.println("Your turn " + player1.getName());
        answer = scanner.nextLine();
        System.out.println("Your turn " + player2.getName());
        secondAnswer = scanner.nextLine();
        rightAnswer = questions.getRightAnswer();
        if (answer.equals(rightAnswer)) {
            player1.setScore(points + bet);
        } else {
            player1.setScore(points - bet);
            System.out.println("Wrong answer,the right one is : " + rightAnswer);
        }
        if (secondAnswer.equals(rightAnswer)) {
            player2.setScore(points + bet);
        } else {
            player2.setScore(points - bet);
            System.out.println("Wrong answer,the right one is : " + rightAnswer);
        }
        System.out.println("Score: " + player1.getScore() + ", " + player1.getName());
        System.out.println("Score: " + player2.getScore() + ", " + player2.getName());
    }

    /**
     * This method is use for multiplayer for the
     * third round.
     * @param player1 status of the first player.
     * @param player2 status of the second player.
     */

    public void multThirdRound(Player player1, Player player2) {
        int startTime2;
        int stopTime2;
        int remainingTime2;
        System.out.println("Your turn " + player2.getName() + "!");
        startTime2 = (int) System.currentTimeMillis();
        secondAnswer = scanner.nextLine();
        stopTime2 = (int) System.currentTimeMillis();
        remainingTime2 = 5000 - (stopTime2 - startTime2);
        rightAnswer = questions.getRightAnswer();
        if (remainingTime2 < 0) {
            System.out.println("Sorry, you run out of time" + player2.getName() + "!");
        } else if (rightAnswer.equals(answer)) {
            int score2 = (int) (remainingTime2 * 0.2);
            System.out.println("Correct");
            player1.setScore(score2);
        } else {
            System.out.println("Wrong answer!");
        }
    }

    /**
     * This method is used for the multiplayer for
     * the fourth round.
     * @param playerA status of the first player.
     * @param playerB status of the second player.
     */

    public void fourthRound(Player playerA, Player playerB) {

        System.out.println("Prepare for the fourth Round!!!");
        System.out.println("In this round the quickest player to give the right answer gets 1000 points");
        System.out.println("In case your answer is  wrong you get 0 points as usual!");

        int startTime;
        int stopTimeA;
        int stopTimeB;
        int PlayerA_time;
        int PlayerB_time;
        String answer1;
        String answer2;
        for (int i = 0; i < 3; i++) {

            questions.ShowQuestion(category[i]);
            System.out.println("Player's 1 turn");
            startTime = (int) System.currentTimeMillis();
            answer1 = scanner.nextLine();
            stopTimeA = (int) System.currentTimeMillis();
            PlayerA_time = stopTimeA - startTime;

            System.out.println("Player's 2 turn");
            startTime = (int) System.currentTimeMillis();
            answer2 = scanner.nextLine();
            stopTimeB = (int) System.currentTimeMillis();
            PlayerB_time = stopTimeB - startTime;


            rightAnswer = questions.getRightAnswer();

            if (answer1.equals(rightAnswer) && !answer2.equals(rightAnswer)) {
                playerA.setScore(1000);
                System.out.println("Player's 2 answer wasn't correct.  1000 points for Player 1 ");

            } else if (answer2.equals(rightAnswer) && !answer1.equals(rightAnswer)) {
                playerB.setScore(1000);
                System.out.println("Player's 1 answer wasn't correct.  1000 points for Player 2 ");

            } else if (!answer2.equals(rightAnswer) && !answer1.equals(rightAnswer)) {
                System.out.println("Sorry neither of you found the right answer. No points for both of you");

            } else {
                if (stopTimeA > stopTimeB) {
                    playerA.setScore(500);
                    playerA.setScore(1000);
                    System.out.println("Player 2 was quicker! ");
                } else {
                    playerA.setScore(1000);
                    playerB.setScore(500);
                    System.out.println("Player 1 was quicker");
                }
            }
        }
        System.out.println("End of round 4!!!");
    }

    /**
     * This is a game mode used only for two players game.The first player who answers correct
     * five questions he wins 5000 points.
     *
     * @param player1 Status of first player
     * @param player2 Status of second player
     */

    public void fifthRound(Player player1, Player player2) {
        long startTime, startTime2;
        long stopTime, stopTime2;
        long totalTime = 0, totalTime2 = 0;
        System.out.println("The first player who answers correctly five question wins 5000 points!");
        System.out.println("Max attempts 7!");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int counter = 0;
        int correctAnswers = 0;
        int correctAnswers2 = 0;
        while (correctAnswers != 5) {
            int randomElement = random.nextInt(2);
            questions.ShowQuestion(category[randomElement]);
            rightAnswer = questions.getRightAnswer();
            System.out.println(player1.getName() + ",your turn!");
            startTime = System.nanoTime();
            answer = scanner.nextLine();
            stopTime = System.nanoTime();
            totalTime = stopTime - startTime;
            System.out.println(player2.getName() + ",your turn!");
            startTime2 = System.nanoTime();
            secondAnswer = scanner.nextLine();
            stopTime2 = System.nanoTime();
            totalTime2 = stopTime2 - startTime2;
            if (answer.equals(rightAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong Answer " + player1.getName());
                System.out.println("The right answer is: " + rightAnswer);
            }
            if (secondAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
                correctAnswers2++;
            } else {
                System.out.println("Wrong Answer" + player2.getName());
                System.out.println("The right answer is: " + rightAnswer);
            }
            System.out.println("You have " + correctAnswers + " right answers!");
            counter++;
            if (counter == 7) {
                break;
            }
            if (correctAnswers2 == 5) {
                break;
            }
        }
        if (correctAnswers == 5 && totalTime > totalTime2) {
            player1.setScore(5000);
            System.out.println("Congrats " + player1.getName() + "!You answered first correctly 5 questions.You won 5000 points!");
        } else if (correctAnswers2 == 5 && totalTime2 > totalTime) {
            player2.setScore(5000);
            System.out.println("Congrats " + player2.getName() + "!You answered first correctly 5 questions.You won 5000 points!");
        } else
            System.out.println("You reached max attempts!");
    }
}
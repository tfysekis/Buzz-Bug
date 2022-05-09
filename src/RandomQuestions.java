/**
 * This class represents a list of questions that
 * are randomly selected for the knowledge game.
 */

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class RandomQuestions {

    private ArrayList<Question> questions;
    private HashSet<Question> burnedQuestions;
    private  String rightAnswer;

    /**
     * The constructor is used for initialization of the
     * arraylist question.
     */
    public RandomQuestions() {
        questions = new ArrayList<>();
        burnedQuestions = new HashSet<>();
        InputStream is = ClassLoader.getSystemResourceAsStream("InputFile.text");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            for (int i = 0; i < 21; i++) {
                questions.add(new Question(br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * This method is choosing a question that hasn't been shown before.
     * @return choice
     */
    public int ChooseQuestion(String category){
        Random random = new Random();
        int choice;
        do{
            choice = random.nextInt(21);
        }while (!((questions.get(choice).getCategory().equals(category)) && !burnedQuestions.contains(questions.get(choice))));

        rightAnswer =  questions.get(choice).getRightAnswer();
        burnedQuestions.add(questions.get(choice));
        return  choice;
    }


    /**
     * This method prints a questions.
     * @param category is for choosing randomly a question.
     */
    public  void ShowQuestion(String category){

        int choice = ChooseQuestion(category);
        System.out.println(questions.get(choice).getQuestion());
        System.out.println(questions.get(choice).getAnswer1());
        System.out.println(questions.get(choice).getAnswer2());
        System.out.println(questions.get(choice).getAnswer3());
        System.out.println(questions.get(choice).getAnswer4());
        System.out.println("Make a choice!");
    }

    /**
     * This method returns the right answer.
     * @return rightAnswer
     */
    public String getRightAnswer() {
        return rightAnswer;
    }
}


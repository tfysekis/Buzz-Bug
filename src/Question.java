/**
 * This class represents a question for the knowledge game.
 */


public class Question {

    private String question;
    private String category;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String Answer4;
    private  String rightAnswer;

    /**
     * Initialization of the question parameters.
     * @param question
     * @param category
     * @param Answer1
     * @param Answer2
     * @param Answer3
     * @param Answer4
     * @param rightAnswer
     */

    public  Question (String question,String category,String Answer1, String Answer2,String Answer3,String Answer4, String rightAnswer){

        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.Answer4 = Answer4;
        this.category = category;
        this.question = question;
        this.rightAnswer = rightAnswer;

    }

    /**
     * This method returns the category of the question.
     * @return category
     */

    public String getCategory() { return category; }

    /**
     * This method returns the right answer.
     * @return rightAnswer
     */

    public String getRightAnswer() { return rightAnswer; }

    /**
     * This method returns the question.
     * @return question
     */

    public String getQuestion() { return question; }

    /**
     * This method returns the first proposal.
     * @return Answer1
     */

    public String getAnswer1() { return Answer1; }

    /**
     * This method returns the second proposal.
     * @return Answer2
     */

    public String getAnswer2() { return Answer2; }

    /**
     * This method returns the third proposal.
     * @return Answer3
     */
    public String getAnswer3(){ return  Answer3; }

    /**
     * This method returns the fourth proposal.
     * @return Answer4
     */

    public String getAnswer4(){ return Answer4;}
    
}


/**
 * This class represents a Player
 */


public class Player {

    private String name;
    private int score;

    public Player(){ }

    /**
     * This method returns player's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is setting the player's name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns  player's current score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is setting player's score
     * @param score
     */

    public void setScore(int score ){
        this.score += score;
    }

}



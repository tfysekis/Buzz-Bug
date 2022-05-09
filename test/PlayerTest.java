import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing the status of a player.
 */

class PlayerTest {

    private Player item;
    private String result;

    @BeforeEach
    void setUp() {
        item = new Player();
        item.setName("Georgia");
        item.setScore(10000);
    }

    @Test
    void getName() {
        result = "Georgia";
        assertEquals(result,item.getName());
    }

    @Test
    void getScore() {
        assertEquals(10000,item.getScore());
    }

}
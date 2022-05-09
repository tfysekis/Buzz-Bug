import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing if a question is correctly added.
 */

public class QuestionTest {

    private Question item;
    private String result;

    @BeforeEach
    void setUp() {
        item = new Question("Which nut is used to make dynamite?", "1", "2","A","B", "C","A");
    }

    @Test
    void getCategory() {
        result = item.getCategory();
        assertEquals("1",result);
    }

    @Test
    void getRightAnswer() {
        result = item.getRightAnswer();
        assertEquals("A",result);
    }

    @Test
    void getQuestion() {
        result = item.getQuestion();
        assertEquals("Which nut is used to make dynamite?",result);
    }

    @Test
    void getAnswer1() {
        result = item.getAnswer1();
        assertEquals("2",result);
    }

    @Test
    void getAnswer2() {
        result = item.getAnswer2();
        assertEquals("A",result);
    }

    @Test
    void getAnswer3() {
        result = item.getAnswer3();
        assertEquals("B",result);
    }

    @Test
    void getAnswer4() {
        result = item.getAnswer4();
        assertEquals("C",result);
    }
}

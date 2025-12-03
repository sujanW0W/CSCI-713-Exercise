import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testValidName() {
        Utils utils = new Utils();
        String name = "Tanjiro";
        Boolean isValid = utils.checkName(name);
        assertTrue(isValid);
    }

    @Test
    void testInvalidName() {
        Utils utils = new Utils();
        String name = "";
        Boolean isValid = utils.checkName(name);
        assertFalse(isValid);
    }

    @Test
    void testCheckNameWithSingleCharacter() {
        Utils utils = new Utils();
        Boolean isValid = utils.checkName("A");
        assertTrue(isValid);
    }

    @Test
    void testCheckNameWithWhitespace() {
        Utils utils = new Utils();
        // Note: " " has length > 0, so it will return true (potential bug)
        Boolean isValid = utils.checkName(" ");
        assertTrue(isValid);
    }

    @Test
    void testNullName() {
        Utils utils = new Utils();
        String name = null;
        Boolean isValid = utils.checkName(name);
        assertFalse(isValid);
    }

    @Test
    void testValidAge() {
        Utils utils = new Utils();
        int age = 25;
        Boolean isValid = utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testInvalidAge() {
        Utils utils = new Utils();
        int age = -25;
        Boolean isValid = utils.isValidAge(age);
        assertFalse(isValid);
    }

    @Test
    void testZeroAge() {
        Utils utils = new Utils();
        int age = 0;
        Boolean isValid = utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testLargeAge() {
        Utils utils = new Utils();
        int age = 150;
        Boolean isValid = utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testIsValidAgeWithMinInteger() {
        Utils utils = new Utils();
        Boolean isValid = utils.isValidAge(Integer.MIN_VALUE);
        assertFalse(isValid);
    }
}

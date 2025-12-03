import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testValidName() {
        String name = "Tanjiro";
        Boolean isValid = Utils.checkName(name);
        assertTrue(isValid);
    }

    @Test
    void testInvalidName() {
        String name = "";
        Boolean isValid = Utils.checkName(name);
        assertFalse(isValid);
    }

    @Test
    void testCheckNameWithSingleCharacter() {
        Boolean isValid = Utils.checkName("A");
        assertTrue(isValid);
    }

    @Test
    void testCheckNameWithWhitespace() {
        // Note: " " has length > 0, so it will return true (potential bug)
        Boolean isValid = Utils.checkName(" ");
        assertTrue(isValid);
    }

    @Test
    void testNullName() {
        String name = null;
        Boolean isValid = Utils.checkName(name);
        assertFalse(isValid);
    }

    @Test
    void testValidAge() {
        int age = 25;
        Boolean isValid = Utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testInvalidAge() {
        int age = -25;
        Boolean isValid = Utils.isValidAge(age);
        assertFalse(isValid);
    }

    @Test
    void testZeroAge() {
        int age = 0;
        Boolean isValid = Utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testLargeAge() {
        int age = 150;
        Boolean isValid = Utils.isValidAge(age);
        assertTrue(isValid);
    }

    @Test
    void testIsValidAgeWithMinInteger() {
        Boolean isValid = Utils.isValidAge(Integer.MIN_VALUE);
        assertFalse(isValid);
    }
}

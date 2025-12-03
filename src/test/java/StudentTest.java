import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentConstructor() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals("Alice", student.getName());
        assertEquals(20, student.age);
        assertEquals(3.5, student.getGpa(), 0.001);
    }

    @Test
    void testGetName() {
        Student student = new Student("Bob", 22, 3.9);
        assertEquals("Bob", student.getName());
    }

    @Test
    void testSetAgeWithNegativeValue() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(-5);
        // Should set to 0 due to bug
        assertEquals(0, student.age);
    }

    @Test
    void testSetAgeWithPositiveValue() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(25);
        assertEquals(25, student.age);
    }

    @Test
    void testSetAgeWithZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(0);
        assertEquals(0, student.age);
    }

    @Test
    void testSetAgeWithLargeValue() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(150);
        assertEquals(150, student.age);
    }

    @Test
    void testGetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals(3.5, student.getGpa(), 0.001);
    }

    @Test
    void testSetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(4.0);
        assertEquals(4.0, student.getGpa(), 0.001);
    }

    @Test
    void testSetGpaWithZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(0.0);
        assertEquals(0.0, student.getGpa(), 0.001);
    }

    @Test
    void testSetGpaWithNegative() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(-1.0);
        assertEquals(-1.0, student.getGpa(), 0.001);
    }
}

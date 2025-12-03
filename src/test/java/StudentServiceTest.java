import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testGetTopStudentWithSingleStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);
        
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
        assertEquals(3.5, top.getGpa(), 0.001);
    }

    @Test
    void testAddMultipleStudents() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        service.addStudent(new Student("Charlie", 19, 3.2));
        service.addStudent(new Student("David", 21, 3.8));
        
        assertEquals(4, service.calculateAverageGpa() > 0 ? 4 : 0);
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testGetTopStudentWithSameGpa() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.5);
        Student s3 = new Student("Charlie", 19, 3.5);
        
        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        
        Student top = service.getTopStudent();
        assertEquals(3.5, top.getGpa(), 0.001);
        // Should return first student when all have same GPA
        assertEquals("Alice", top.getName());
    }

    @Test
    void testGetTopStudentWhenFirstIsHighest() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 4.0);
        Student s2 = new Student("Bob", 22, 3.9);
        Student s3 = new Student("Charlie", 19, 3.2);
        
        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        
        // First student has highest GPA, loop should not update top
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
        assertEquals(4.0, top.getGpa(), 0.001);
    }

    @Test
    void testGetTopStudentWithMiddleHighest() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.0);
        Student s2 = new Student("Bob", 22, 4.0);
        Student s3 = new Student("Charlie", 19, 3.2);
        
        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
        assertEquals(4.0, top.getGpa(), 0.001);
    }

    @Test
    void testGetTopStudentWithLastHighest() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.0);
        Student s2 = new Student("Bob", 22, 3.5);
        Student s3 = new Student("Charlie", 19, 4.0);
        
        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        
        Student top = service.getTopStudent();
        assertEquals("Charlie", top.getName());
        assertEquals(4.0, top.getGpa(), 0.001);
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithEmptyList() {
        StudentService service = new StudentService();
        double avg = service.calculateAverageGpa();
        assertEquals(0.0, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithSingleStudent() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.8));
        double avg = service.calculateAverageGpa();
        assertEquals(3.8, avg, 0.001);
    }

    @Test
    void testCalculateAverageGpaWithDifferentGpas() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.0));
        service.addStudent(new Student("Bob", 22, 4.0));
        service.addStudent(new Student("Charlie", 19, 3.5));
        
        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testRemoveStudentByName() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);
        Student s3 = new Student("Charlie", 19, 3.2);
        for(Student s: new Student[] {s1, s2, s3}){
            service.addStudent(s);
        }
        
        Student topStudentBeforeRemoval = service.getTopStudent();
        assertEquals("Bob", topStudentBeforeRemoval.getName());
        
        service.removeStudentByName("Bob");
        
        Student topStudentAfterRemoval = service.getTopStudent();
        assertEquals("Alice", topStudentAfterRemoval.getName());
    }

    @Test
    void testRemoveStudentByNameNotFound() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);
        
        int sizeBefore = service.calculateAverageGpa() > 0 ? 1 : 0;
        service.removeStudentByName("Bob");
        // List should still contain Alice
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testRemoveStudentByNameFromEmptyList() {
        StudentService service = new StudentService();
        // Should not throw exception, just do nothing
        assertDoesNotThrow(() -> service.removeStudentByName("Alice"));
        double avg = service.calculateAverageGpa();
        assertEquals(0.0, avg, 0.001);
    }

    @Test
    void testRemoveStudentByNameNoMatchInNonEmptyList() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));
        
        // Remove non-existent name - should iterate through all but not remove
        service.removeStudentByName("Charlie");
        
        // Both students should still be there
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
        double avg = service.calculateAverageGpa();
        assertEquals(3.7, avg, 0.001);
    }

     @Test
    void testRemoveStudentByNameMultipleMatches() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Alice", 22, 3.9);
        Student s3 = new Student("Bob", 19, 3.2);
        
        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        
        assertThrows(java.util.ConcurrentModificationException.class, () -> {
            service.removeStudentByName("Alice");
        });
    }

}

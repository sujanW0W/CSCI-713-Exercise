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
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

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

}

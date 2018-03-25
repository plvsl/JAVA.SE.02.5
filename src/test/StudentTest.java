package test;

import main.Discipline;
import main.Student;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class StudentTest {
    private Discipline math;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        math = new Discipline<>("Mathematics");
        student1 = new Student(12);
        student2 = new Student(1);
        math.addStudent(student2).addStudent(student1);
    }

    @Test
    public void addStudentMethodShouldSetStudentWithSpecialIdToMathDiscipline() {
        assertTrue(math.isStudentInGroup(student1));
        assertTrue(math.isStudentInGroup(student2));
    }

    @Test
    public void addStudentMethodShouldNotSetStudentWithSpecialIdToMathDiscipline() {
        Student student3 = new Student(134);

        assertFalse(math.isStudentInGroup(student3));
    }
}

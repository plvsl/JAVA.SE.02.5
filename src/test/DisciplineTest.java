package test;

import main.Discipline;
import main.Student;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DisciplineTest {

    @Test
    public void doubleDisciplineShouldSetCorrectName(){
        Discipline math = new Discipline<>("Mathematics");
        assertEquals("Mathematics", math.getName());
    }

    @Test
    public void integerDisciplineShouldSetCorrectName(){
        Discipline bio = new Discipline<>("Biology");
        assertEquals("Biology", bio.getName());
    }

    @Test
    public void getStudentGroupsShouldReturnCorrectListForEachStudent(){
        Discipline math = new Discipline<>("Mathematics");
        Discipline bio = new Discipline<>("Biology");

        Student student1 = new Student(12);
        Student student2 = new Student(3);
        Student student3 = new Student(132);

        math.addStudent(student2).addStudent(student1);
        bio.addStudent(student2).addStudent(student3);

        List<Discipline> disciplines = Discipline.getStudentGroups(3);
        assertEquals("Mathematics", disciplines.get(0).getName());
        assertEquals("Biology", disciplines.get(1).getName());

        List<Discipline> disciplines1 = Discipline.getStudentGroups(12);
        assertEquals("Mathematics", disciplines1.get(0).getName());

        List<Discipline> disciplines2 = Discipline.getStudentGroups(132);
        assertEquals("Biology", disciplines2.get(0).getName());
    }

    @Test
    public void setMarkAndGetPositionInGroupShouldSetAndReturnCorrectValues(){
        Discipline math = new Discipline<>("Mathematics");
        Discipline bio = new Discipline<>("Biology");

        Student student1 = new Student(12);
        Student student2 = new Student(666);

        math.addStudent(student1).addStudent(student2);
        bio.addStudent(student1).addStudent(student2);

        math.setMark(student1, 2.2).setMark(student2, 5.9);
        bio.setMark(student2, 2).setMark(student1, 5);

        assertEquals("Student position is 2", math.getStudentPositionInGroup(student1));
        assertEquals("Student position is 1", math.getStudentPositionInGroup(student2));
        assertEquals("Student position is 2", bio.getStudentPositionInGroup(student2));
        assertEquals("Student position is 1", bio.getStudentPositionInGroup(student1));
    }

}

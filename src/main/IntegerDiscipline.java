package main;

import java.util.HashMap;
import java.util.Map;

public class IntegerDiscipline extends Discipline {

    Map<Student, Integer> marks = new HashMap<>();

    public IntegerDiscipline(String name) {
        super(name);
    }

    public IntegerDiscipline setMark(Student student, int mark) {
        if (this.isStudentInGroup(student)) {
            marks.put(student, mark);
        }
        return this;
    }

    public String getStudentPositionInGroup(Student student) {
        Map<Student, Integer> sortedMarks = Discipline.sortByValue(marks);

        if (this.isStudentInGroup(student)) {
            int i = 1;
            for (Student student1 : sortedMarks.keySet()) {
                if (student.getId() == student1.getId()) {
                    return "Student position is " + (sortedMarks.keySet().size() - i + 1);
                }
                i++;
            }
        }


        return "No such student";
    }
}

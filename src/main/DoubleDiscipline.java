package main;

import java.util.*;

public class DoubleDiscipline extends Discipline {

    Map<Student, Double> marks = new HashMap<>();

    public DoubleDiscipline(String name) {
        super(name);
    }

    public DoubleDiscipline setMark(Student student, double mark) {
        if (this.isStudentInGroup(student)) {
            marks.put(student, mark);
        }
        return this;
    }

    public String getStudentPositionInGroup(Student student) {
        Map<Student, Double> sortedMarks = Discipline.sortByValue(marks);

        int i = 1;
        for (Student student1 : sortedMarks.keySet()) {
            if (student.getId() == student1.getId()) {
                return "Student position is " + (sortedMarks.keySet().size() - i + 1);
            }
            i++;
        }
        return "No such student";
    }
}

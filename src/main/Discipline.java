package main;

import java.util.*;

public class Discipline<T extends Comparable<? super T>> {
    private String name;
    private Map<Student, T> marks = new HashMap<>();
    private List<Student> students = new LinkedList<>();
    private static List<Discipline> disciplines = new LinkedList<>();

    public Discipline(String name) {
        this.name = name;
        disciplines.add(this);
    }

    public String getName() {
        return name;
    }

    public Discipline addStudent(Student student) {
        students.add(student);
        return this;
    }

    public boolean isStudentInGroup(Student studentCheck) {
        for (Student student : students) {
            if (student.getId() == studentCheck.getId()) {
                return true;
            }
        }
        return false;
    }

    public static List getStudentGroups(int id) {
        List<Discipline> result = new LinkedList<>();

        for (Discipline discipline : disciplines) {
            for (Object student : discipline.students) {
                if (((Student)student).getId() == id) {
                    result.add(discipline);
                }
            }
        }
        return result;
    }

    public Discipline setMark(Student student, T mark) {
        if (this.isStudentInGroup(student)) {
            marks.put(student, mark);
        }
        return this;
    }

    public String getStudentPositionInGroup(Student student) {
        Map<Student, T> sortedMarks = Discipline.sortByValue(marks);

        int i = 1;
        for (Student student1 : sortedMarks.keySet()) {
            if (student.getId() == student1.getId()) {
                return "Student position is " + (sortedMarks.keySet().size() - i + 1);
            }
            i++;
        }
        return "No such student";
}

    private static <Student, T extends Comparable<? super T>> Map<Student, T> sortByValue(Map<Student, T> map) {
        List<Map.Entry<Student, T>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        Map<Student, T> result = new LinkedHashMap<>();
        for (Map.Entry<Student, T> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}

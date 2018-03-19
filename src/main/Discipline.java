package main;

import java.util.*;

public class Discipline {
    private String name;
    private List<Student> students = new LinkedList<>();
    private static List<Discipline> disciplines = new LinkedList<>();

    Discipline(String name) {
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
        for (Student student : students)
            if (student.getId() == studentCheck.getId())
                return true;
        return false;
    }

    public static List getStudentGroups(int id) {
        List<Discipline> result = new LinkedList<>();

        for (Discipline discipline : disciplines) {
            for (Student student : discipline.students) {
                if (student.getId() == id) {
                    result.add(discipline);
                }
            }
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}

package main;

import java.util.List;

public class App {

    public static void main(String[] args) {
        DoubleDiscipline math = new DoubleDiscipline("Mathematics");
        IntegerDiscipline bio = new IntegerDiscipline("Biology");

        math.addStudent(new Student(1)).addStudent(new Student(12)).addStudent(new Student(123))
                .addStudent(new Student(555)).addStudent(new Student(666)).addStudent(new Student(23));
        bio.addStudent(new Student(2)).addStudent(new Student(23)).addStudent(new Student(234));

        List<Discipline> done = Discipline.getStudentGroups(23);
        done.get(0).getName();
        for (Discipline group : done) {
            System.out.println(group.getName());
        }

        math.setMark(new Student(12), 4.5).setMark(new Student(123), 3.1)
                .setMark(new Student(555), 2.2).setMark(new Student(666), 5.9);
        System.out.println(math.getStudentPositionInGroup(new Student(555)));
    }
}

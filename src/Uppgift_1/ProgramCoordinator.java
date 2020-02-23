package Uppgift_1;

import java.util.ArrayList;
import java.util.List;

public class ProgramCoordinator {

    private String name;
    private Program program;
    private Teacher tempTeacher;
    private List<Teacher> teachers;

    public ProgramCoordinator(String name, Teacher teacher, Program program) {
        this.name = name;
        this.program = program;
        this.teachers = new ArrayList<>();
        addTeacher(teacher);
    }

    public void addTeacher(Teacher teacher) {
        teacher.setProgramCoordinator(this);
        this.teachers.add(teacher);

    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);

    }

    public Teacher findTeacher(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                tempTeacher = teacher;
            } else {
                System.out.println("Läraren finns inte.");
            }
        }
        return tempTeacher;
    }

    public Program getProgram() {
        return program;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

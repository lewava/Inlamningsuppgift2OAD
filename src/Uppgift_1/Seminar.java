package Uppgift_1;

import java.util.ArrayList;
import java.util.List;

public class Seminar {

    private String name;
    private Teacher teacher;
    private Program program;
    private List<Subject> subjects;
    private List<Attendance> attendanceList;

    public Seminar(String name, Teacher teacher) {
        this.name = name;
        this.subjects = new ArrayList<>();
        this.attendanceList = new ArrayList<>();
        setTeacher(teacher);

    }

    public int getTotalAttendance() {
        return attendanceList.size();
    }

    public void setTeacher(Teacher teacher) {
        teacher.addSeminar(this);
        this.teacher = teacher;
    }

    public void setProgram(Program program) {
        this.program = program;

    }

    public void addSubject(Subject subject) {
        subjects.add(subject);

    }

    public void addAttendance(Attendance attendance) {
        this.attendanceList.add(attendance);
    }

    public void removeAttendance(Attendance attendance) {
        this.attendanceList.remove(attendance);

    }

    public Teacher getTeacher() {
        return this.teacher;

    }

    public Program getProgram() {
        return program;

    }

    public List<Subject> getSubjects() {
        return subjects;

    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

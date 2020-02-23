package Uppgift_1;

public class Subject {

    private String name;
    private Seminar seminar;

    public Subject(String name) {
        this.name = name;
    }

    public void viewSubjectInfo() {
        System.out.println("Lärare:" + seminar.getTeacher());
        seminar.getAttendanceList().forEach(e -> System.out.println(e.getStudent()));
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }


    public String getName() {
        return name;
    }

    public Seminar getSeminar() {
        return this.seminar;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
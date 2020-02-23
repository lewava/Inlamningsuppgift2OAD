package Uppgift_1;

public class Attendance {

    private boolean attendanceLevel;
    private Student student;
    private Seminar seminar;

    public Attendance(Student student) {
        this.student = student;
    }

    public void registerAttendance(Student student, Seminar seminar) {
        student.attendSeminars(this);
        seminar.addAttendance(this);
        this.attendanceLevel = true;
    }

    public void removeAttendance(Student student, Seminar seminar) {
        student.attendSeminars(this);
        seminar.addAttendance(this);
        this.attendanceLevel = false;
    }

    public void setAttendanceLevel(Boolean attendanceLevel) {
        this.attendanceLevel = attendanceLevel;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean getAttendanceLevel() {
        return attendanceLevel;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }

    public Student getStudent() {
        return student;

    }

    public Seminar getSeminar() {
        return seminar;
    }
}

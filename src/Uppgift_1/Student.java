package Uppgift_1;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Attendance> seminarsAttended;

    public Student(String name) {
        this.name = name;
        seminarsAttended = new ArrayList<>();

    }

    public void attendSeminars(Attendance attendance) {
        attendance.setStudent(this);
        attendance.setAttendanceLevel(true);
        this.seminarsAttended.add(attendance);
    }

    public List<Attendance> getSeminarsAttended() {
        return seminarsAttended;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

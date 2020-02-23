package Uppgift_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {

    private String name;
    private ProgramCoordinator programCoordinator;
    private List<Seminar> seminars;

    public Program(String name) {
        this.name = name;
        seminars = new ArrayList<>();

    }

    public Set<Student> getStudents() {
        return seminars.stream()
                .map(Seminar::getAttendanceList)
                .flatMap(Collection::stream)
                .map(Attendance::getStudent)
                .collect(Collectors.toSet());
    }

    public void addProgramCoordinator() {
        this.programCoordinator = programCoordinator;

    }

    public void addSeminar(Seminar seminar) {
        seminars.add(seminar);

    }

    public void removeSeminar(Seminar seminar) {
        seminars.remove(seminar);
    }

    public ProgramCoordinator getProgramCoordinator() {
        return programCoordinator;

    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

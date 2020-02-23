package Uppgift_1;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String name;
    private ProgramCoordinator programCoordinator;
    private List<Seminar> seminars;

    public Teacher(String name) {
        this.name = name;
        seminars = new ArrayList<>();
    }

    public List<Seminar> getSeminarHistory() {
        return seminars;
    }

    public Seminar getCurrentSeminar() {
        return seminars.get(seminars.size() - 1);
    }

    public void setProgramCoordinator(ProgramCoordinator programCoordinator) {
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

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

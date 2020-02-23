package Uppgift_1;

public class Main {

    public Main() {

        //Skapa program.
        Program program = new Program("Teknikprogrammet");

        //Skapa lärare.
        Teacher britta = new Teacher("Britta");
        Teacher erik = new Teacher("Erik");

        //Skapa programansvarig.
        ProgramCoordinator programCoordinator = new ProgramCoordinator("Ulf", erik, program);

        //Lägg till lärare.
        programCoordinator.addTeacher(britta);
        programCoordinator.addTeacher(erik);

        //Skapa Ämnen.
        Subject Engelska = new Subject("Engelska");
        Subject Svenska = new Subject("Svenska");
        Subject matte = new Subject("Matte");

        //Skapa kurs och lägg till ämnen.
        Seminar språkKurs = new Seminar("Språk", erik);
        språkKurs.addSubject(Engelska);
        språkKurs.addSubject(Svenska);

        //Skapa kurs och lägg till ämnen.
        Seminar matteKurs = new Seminar("Matte", britta);
        matteKurs.addSubject(matte);

        //Lägg till Studenter.
        Student leon = new Student("Leon");
        Student alex = new Student("Alex");
        Student frida = new Student("Frida");

        //Lägg till närvaro.
        Attendance språkAttendance = new Attendance(leon);
        språkAttendance.registerAttendance(leon, språkKurs);
        språkAttendance.registerAttendance(frida, språkKurs);

        //Lägg till närvaro.
        Attendance alexMatte = new Attendance(alex);
        alexMatte.registerAttendance(alex, matteKurs);

        //Lägg till kurs i programet.
        program.addSeminar(språkKurs);
        program.addSeminar(matteKurs);

        //---------------------------------------KRAV----------------------------------------------------

        System.out.println("-----1-----");

        //Vilket program en Coordinator ansvarar för?
        System.out.println(programCoordinator.getName());

        System.out.println("-----2----");

        //Vilka lärare som finns för ett Program?
        programCoordinator.getTeachers().forEach(System.out::println);

        System.out.println("-----3-----");

        //Hur många studenter som finns i ett Program?
        System.out.println("Namn: " + program.getStudents());
        System.out.println("Antal: " + program.getStudents().size());

        System.out.println("-----4-----");

        //Vad närvaron är för Student X?
        System.out.println("Leon har varit på lektionen " + leon.getSeminarsAttended().size()
                + " gång.");

        System.out.println("-----5-----");

        //Vilka kurser/seminarier som en lärare undervisat i?
        erik.getSeminarHistory().forEach(System.out::println);

        System.out.println("-----6-----");

        //Vilka ämnen som undervisats i ett Seminar?
        System.out.println(språkKurs.getSubjects());

        System.out.println("-----7-----");

        //Närvaron för Seminar X?
        System.out.println(språkKurs.getTotalAttendance() + " elever har varit på kursen " +
                språkKurs.getName() + ".");
    }

    public static void main(String[] args) {
        new Main();
    }
}

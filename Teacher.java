package timetable;

public class Teacher {
    public String name;
    public Subject subject;

    public Teacher() {
        name="";
        subject=null;
    }
    public Teacher(String x,Subject sub) {
        name = x;
        subject = sub;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
package timetable;

public class Subject {
   public  int hours;
   public char subname;

    @Override
    public String toString() {
        return "Subject{" +
                "hours=" + hours +
                ", subname=" + subname +
                '}';
    }

    public Subject(int x, char name) {
        hours = x;
        subname = name;
    }
}
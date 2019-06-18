package timetable;


public class Day {
    public Room roomA= new Room(1);
    public Room roomB = new Room(2);
    public Room roomC = new Room(3);
    public int DaysNumber;
    public boolean freeRoams;
    public Day(int x) {
        DaysNumber=x;
        freeRoams=true;
    }


    @Override
    public String toString() {
        return "Day{" +
                "DaysNumber=" + DaysNumber +
                '}';
    }
}
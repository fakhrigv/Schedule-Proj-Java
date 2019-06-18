package timetable;

public class Week{
    public int WeekNumber;

    public Week() {
        WeekNumber=0;
    }
    public Week(int x) {
        WeekNumber=x;
    }
    public Day ponedelnik = new Day(1);
    public Day vtornik = new Day(2);
    public Day sreda = new Day(3);
    public Day chetverg=new Day(4);
    public Day patnica=new Day(5);

    @Override
    public String toString() {
        return "Week{" +
                "WeekNumber=" + WeekNumber +
                '}';
    }
}

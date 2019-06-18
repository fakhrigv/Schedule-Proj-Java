package timetable;

public class Room{
  public   int RoomsNumber;
  public   boolean Empty; // checks if the room is empty or not.

    public Room(int x) {
        RoomsNumber=x;
        Empty=true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomsNumber=" + RoomsNumber +
                '}';
    }
}

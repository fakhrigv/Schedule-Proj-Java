package timetable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class Schedule {
    public static int maxNumbOfTeachers = 10;
    public static int NumbOfWeeks = 12;
    public static int NumbOfDays = 5;
    public static int maxNumberOfDays = 60;
    public static Subject math = new Subject(24, 'M');
    public static Subject phys = new Subject(36, 'P');
    public static Subject english = new Subject(24, 'E');
    public static Subject russian = new Subject(48, 'R');

    public static void main(String[] args) throws IOException, InterruptedException {
        int numberOfTeacher = 1;
        Scanner scan = new Scanner(System.in);
        Day[][] Days = new Day[12][5];


        // Creating days per week
        for (int i = 0; i < maxNumberOfDays; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 5; k++) {
                    Days[j][k] = createDays(i);
                }
            }
        }


        // Creating teachers
        System.out.println("Give 'the number of the teachers: ");
        int Numb = scan.nextInt();
        Teacher[] teachers = new Teacher[Numb];
        // Getting all the teachers until break or # of teachers = 10
        for (; numberOfTeacher <= Numb; numberOfTeacher++) {
            System.out.println("Please give the name of the Subject and the Name of the teacher: ");
            String Name = scan.next();
            String Sub = scan.next();
            if (Name.equals("break") || Sub.equals("break")) {
                break;
            }
            teachers[numberOfTeacher - 1] = createTeachers(Name, Sub);
        }





        File file = new File("~/IdeaProjects/Schedule/data.csv");
        int j = 0;
    for (int teacher = 0; teacher < teachers.length;teacher++ ) {
        for (int i = 0; i < NumbOfWeeks; i++) {
            //int DayLimit = 0;
            while (j <= NumbOfDays) {
                int Random = getRandomNumberInRange(0,4);
                //TimeUnit.SECONDS.sleep(1);
                int RandomRoom = getRandomNumberInRange(1,3);
                //TimeUnit.SECONDS.sleep(1);
                if (teachers[teacher].subject.hours == 24) {
                    if (Days[i][Random].freeRoams ) {
                        if (RandomRoom == 1) {
                            if (Days[i][Random].roomA.Empty) {
                                System.out.println("Lesson of Week:" + (i + 1) + ",Day: " + (Random + 1) + " of teacher: " + teachers[teacher].name +
                                        " Will be in the Room: " + Days[i][Random].roomA.RoomsNumber);
                                String str = (i + 1) + "," + (Random + 1) + "," + teachers[teacher].name + " , " + Days[i][Random].roomB.RoomsNumber;
                                //   writeDataLineByLine(str,file);

                                Days[i][Random].roomA.Empty = false;
                                if (!Days[i][Random].roomA.Empty && !Days[i][Random].roomB.Empty && !Days[i][Random].roomC.Empty)
                                    Days[i][Random].freeRoams = false;

                                //                            System.out.println("Day: " + j);
                                j = j + 2;


                           /* if(j>=5) {
                                j=j%5;
                            }
                           */
                                System.out.println();

                            }
                        } else if (RandomRoom == 2) {
                            if (Days[i][Random].roomB.Empty) {
                                System.out.println("Lesson of Week:" + (i + 1) + ",Day: " + (Random + 1) + " of teacher: " + teachers[teacher].name +
                                        " Will be in the Room: " + Days[i][Random].roomB.RoomsNumber);

                                String str = (i + 1) + "," + (Random + 1) + "," + teachers[teacher].name + " , " + Days[i][Random].roomB.RoomsNumber;
                                // writeDataLineByLine(str,file);
                                Days[i][Random].roomB.Empty = false;
                                if (!Days[i][Random].roomA.Empty && !Days[i][Random].roomB.Empty && !Days[i][Random].roomC.Empty)
                                    Days[i][Random].freeRoams = false;

                                //                              System.out.println("Day: " + j);
                                j = j + 2;

                           /* if(j>=5) {
                                j=j%5;
                            }
                           */
                                System.out.println();


                            }
                        } else if (RandomRoom == 3) {
                            if (Days[i][Random].roomC.Empty) {
                                System.out.println("Lesson of Week:" + (i + 1) + ",Day: " + (Random + 1) + " of teacher: " + teachers[teacher].name +
                                        " Will be in the Room: " + Days[i][Random].roomC.RoomsNumber);
                                String str = (i + 1) + "," + (Random + 1) + "," + teachers[teacher].name + " , " + Days[i][Random].roomB.RoomsNumber;
                                // writeDataLineByLine(str,file);

                                Days[i][j].roomC.Empty = false;
                                if (!Days[i][Random].roomA.Empty && !Days[i][Random].roomB.Empty && !Days[i][Random].roomC.Empty)
                                    Days[i][Random].freeRoams = false;

//                                System.out.println("Day: " + j);
                                j = j + 2;

                           /* if(j>=5) {
                                j=j%5;
                            }
                           */
                                System.out.println();

                            }
                        }
                    }
                            // ELSE CONDITION WHEN THERE ARE NO FREE ROOMS IN ANY DAY OF THE WEEK
                            else {
                            System.out.println("We got no Free rooms in Week: " + i + ",On a day #: " + j);
                            j++;

                           /* if(j>=5) {
                                j=j%5;
                            }
                           */
                            System.out.println();
                        }
                    }
                if(j>=5) {
                    j=j%5;
                    break;
                }
            }
        }
        }
    }


    public static void writeInsideFile(Teacher tch)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
        writer.write(tch.name);
        writer.write(tch.subject.subname);
        writer.close();
    }


    public static void writeWeekInFile(Week week, Day day)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
        writer.write(week.WeekNumber);
        writer.write(day.DaysNumber);

        writer.close();
    }

    public static Teacher createTeachers(String tmp, String nm) {

        Teacher teacher = new Teacher();

        if (tmp.charAt(0) == 'M' || tmp.charAt(0) == 'm') teacher = new Teacher(nm, math);
        else if (tmp.charAt(0) == 'P' || tmp.charAt(0) == 'p') teacher = new Teacher(nm, phys);
        else if (tmp.charAt(0) == 'E' || tmp.charAt(0) == 'e') teacher = new Teacher(nm, english);
        else if (tmp.charAt(0) == 'R' || tmp.charAt(0) == 'r') teacher = new Teacher(nm, russian);
        else {
            System.out.println("You used wrong input. try again.");
            System.exit(1);
        }
        return teacher;
    }



    public static Day createDays(int number) {
        Day newDay = new Day(number);
        return newDay;
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void writeDataLineByLine(String line,File file)
    {
        // first create file object for file placed at location
        // specified by filepath
        try {
            // create FileWriter object with file as parameter
            FileWriter OutFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(OutFile);
            /* String to split. */
            String[] tempArray;

            /* delimiter */
            String delimiter = ",";

            /* given string will be split by the argument delimiter provided. */
            tempArray = line.split(delimiter);
            writer.writeNext(tempArray);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


package Main;

/* Runner file for Advent of Code*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import Main.DailyFiles.*;

public class Runner {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Choose a day");
        int choice = input.nextInt();
        System.out.println("-----------------------------------");
        switch (choice) {
            case 1:
                System.out.println(Advent1.main());
                break;
            case 2:
                System.out.println(Advent2.main());
                break;
            case 3:
                System.out.println(Advent3.main());
                break;
            case 4:
                System.out.println(Advent4.main());
                break;
            case 5:
                System.out.println(Advent5.main());
                break;
            case 6:
                System.out.println(Advent6.main());
                break;
            case 7:
                System.out.println(Advent7.main());
                break;
            case 8:
                System.out.println(Advent8.main());
                break;
            case 9:
                System.out.println(Advent9.main());
                break;
        }
    }

    public static ArrayList<String> readFile(int num){
        // Declare an ArrayList of Strings
        ArrayList<String> myList = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Main/DataFiles/data" + String.valueOf(num) + ".txt"));
            // Grab a line of text (this case they happen to be integers)
            String line = br.readLine();
            while (line != null) {
                // Add to the bottom of the ArrayList
                myList.add(line);
                line = br.readLine(); // try to read again
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.print("file not found");
        } catch (IOException ex) {
            System.err.print("uh oh");
        }
        return myList;
    }

}

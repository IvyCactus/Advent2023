/* Runner file for Advent of Code*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Runner {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Choose a day");
        int choice = input.nextInt();
        System.out.println("-----------------------------------");
        switch (choice) {
            case 1:
                Advent1 file1 = new Advent1();
                file1.main();
        }

    }

    public static ArrayList<String> readFile(String fileName){
        // Declare an ArrayList of Strings
        ArrayList<String> myList = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // Grab a line of text (this case they happen to be integers)
            String line = br.readLine();
            while (line != null) {
                // Add to the bottom of the ArrayList
                myList.add(line);
                line = br.readLine(); // try to read again
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.print("uh oh");
        } catch (IOException ex) {
            System.err.print("uh oh");
        }
        return myList;
    }

}

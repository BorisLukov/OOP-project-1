package bg.tu_varna.sit;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        RoomOperations roomOperations = new RoomOperations();
        System.out.println("Select your option:");
        System.out.println("Type help to see the supported commands.");
        Scanner scanner = new Scanner(System.in);
        String op = null;
        do {
            op = scanner.nextLine();
            switch (op) {
                case "open":
                    roomOperations.open();
                    break;
                case "close":
                    roomOperations.close();
                case "save":
                    break;
                case "saveas":
                    break;
                case "help":
                    System.out.println("Available commands:");
                    System.out.println("open <file> opens the file");
                    System.out.println("save saves and closes the current file");
                    System.out.println("saveas <file> saves and closes the current file in <file>");
                    System.out.println("close closes the opened file without saving the current progress");
                    System.out.println("checkin registers you in the room");
                    System.out.println("availability shows a list of free rooms");
                    System.out.println("checkout leaves the room");
                    System.out.println("report shows a list of the room usage");
                    System.out.println("find finds a suitable room with a number of beds");
                    System.out.println("find! closes the opened file without saving the current progress");
                    System.out.println("unavailable makes a room unavailable for a specific time");
                    System.out.println("exit exits the program");
                    break;
                case "checkin":
                    roomOperations.checkin();
                    break;
                case "availability":
                    roomOperations.availability();
                    break;
                case "checkout":
                    roomOperations.checkout();
                    break;
                case "report":
                    roomOperations.report();
                    break;
                case "find":
                    roomOperations.find();
                    break;
                case "find!":
                    break;
                case "unavailable":
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
    }while(!op.equals("exit"));

}
}

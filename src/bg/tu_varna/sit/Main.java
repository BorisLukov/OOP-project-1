package bg.tu_varna.sit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Select your option:");
        System.out.println("Type help to see the supported commands.");
        Scanner scanner = new Scanner(System.in);
        String op = null;

        do {
            op = scanner.nextLine();
            switch (op) {
                case "open":
                    scanner.nextLine();
                    break;
                case "save":
                    scanner.nextLine();

                    break;
                case "saveas":
                    scanner.nextLine();

                    break;
                case "exit":
                    scanner.nextLine();

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
                    scanner.nextLine();

                    break;
                case "checkin":
                    scanner.nextLine();

                    break;
                case "availability":
                    scanner.nextLine();

                    break;
                case "checkout":
                    scanner.nextLine();

                    break;
                case "report":
                    scanner.nextLine();

                    break;
                case "find":
                    scanner.nextLine();

                    break;
                case "find!":
                    scanner.nextLine();

                    break;
                case "unavailable":
                    scanner.nextLine();

                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(!op.equals("exit"));
    }
}

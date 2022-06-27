package bg.tu_varna.sit;

import bg.tu_varna.sit.menu.Menu;
import bg.tu_varna.sit.rooms.RoomOperations;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        RoomOperations roomOperations = new RoomOperations();
        roomOperations.addRooms();
        System.out.println("Type help to see the supported commands.");
        System.out.println("Select your option:");
        Menu menu = new Menu();
        menu.startMenu();



}
}

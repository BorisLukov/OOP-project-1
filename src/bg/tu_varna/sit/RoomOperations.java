package bg.tu_varna.sit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomOperations {
    private RoomDetails roomDetails;
    Scanner scanner = new Scanner(System.in);

    private ArrayList<RoomDetails> roomOperations = new ArrayList<>();

    public void addRooms(RoomDetails roomDetails){
        if(roomDetails.getRoomNumber() <= 0) {
            roomOperations.add(roomDetails);
            System.out.println("Room successfully added");
        }

    }

    public void checkin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String op = scanner.nextLine();
        for (RoomDetails roomOperation : roomOperations) {
            if(roomDetails.getRoomNumber() == Integer.parseInt(op)){
                roomDetails.setNote("Taken");
                System.out.println("Enter date from: ");
                roomDetails.setDateFrom(sdf.parse(scanner.nextLine()));
                System.out.println("Enter date to: ");
                roomDetails.setDateTo(sdf.parse(scanner.nextLine()));

            }
        }
    }

    public void availability(){

    }

    public void checkout(){

    }

    public void report(){

    }

    public void find(){

    }

    public void findUrgent(){

    }

    public void unavailable(){

    }
}

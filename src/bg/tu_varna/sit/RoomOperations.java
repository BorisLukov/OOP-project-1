package bg.tu_varna.sit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomOperations {
    private RoomDetails roomDetails;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;
    Scanner scanner = new Scanner(System.in);

    public void open() throws IOException {
        try {
            File file = new File("Hotel.json");
            if (file.createNewFile()) {
                System.out.println("File created and opened: " + file.getName());
            } else {
                System.out.println("File successfully opened.");
            }
        } catch (IOException e) {
            System.out.println("File couldn't open.");
            e.printStackTrace();
        }
        FileReader fileReader = new FileReader("Hotel.json");
        setStatus(true);
        fileReader.close();
    }

    public void close() throws IOException {
        FileReader fileReader = new FileReader("Hotel.json");
        fileReader.close();
        setStatus(false);
    }

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

    public void availability() throws ParseException {
        ArrayList<RoomDetails> availableRooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String op = scanner.nextLine();
        for (RoomDetails roomOperation : roomOperations) {
            if(sdf.parse(op).before(roomDetails.getDateFrom()) && sdf.parse(op).after(roomDetails.getDateTo())){
                availableRooms.add(roomDetails);
            }
        }
        for (RoomDetails availableRoom : availableRooms) {
            System.out.println(roomDetails);
        }
    }

    public void checkout(){
        String op = scanner.nextLine();
        for (RoomDetails roomOperation : roomOperations) {
            if(roomDetails.getRoomNumber() ==  Integer.parseInt(op)){
                roomDetails.setNote("Available");
                roomOperation.setDateFrom(null);
                roomOperation.setDateTo(null);
            }
        }
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

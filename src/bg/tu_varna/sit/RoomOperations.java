package bg.tu_varna.sit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomOperations {
    private RoomDetails roomDetails;
    private boolean status;
    Scanner scanner = new Scanner(System.in);
    private ArrayList<RoomDetails> roomOperations = new ArrayList<>();

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


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
        System.out.println("File successfully closed.");
        setStatus(false);
    }

    public void save(){


    }

    public void saveas(){


    }


    public void addRooms(RoomDetails roomDetails){
        if(roomDetails.getRoomNumber() <= 0) {
            roomOperations.add(roomDetails);
            System.out.println("Room successfully added");
        }

    }

    public void checkin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String op = scanner.nextLine();
        for (RoomDetails roomDetails : roomOperations) {
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
        for (RoomDetails roomDetails : roomOperations) {
            if(sdf.parse(op).before(roomDetails.getDateFrom()) && sdf.parse(op).after(roomDetails.getDateTo())){
                availableRooms.add(roomDetails);
            }
        }
        for (RoomDetails roomDetails : availableRooms) {
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

    public void report() throws ParseException {
        ArrayList<RoomDetails> rooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter date from: ");
        String op = scanner.nextLine();
        System.out.println("Enter date to: ");
        String op2 = scanner.nextLine();

        for (RoomDetails roomDetails : roomOperations) {
            if(roomDetails.getDateFrom().after(sdf.parse(op)) || roomDetails.getDateTo().before(sdf.parse(op2))){
                rooms.add(roomDetails);

            }
        }
        for (RoomDetails room : rooms) {
            System.out.println(roomDetails);
        }
    }

    public void find() throws ParseException {
        ArrayList<RoomDetails> rooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter date from: ");
        String op = scanner.nextLine();
        System.out.println("Enter date to: ");
        String op2 = scanner.nextLine();
        System.out.println("Enter number of beds: ");
        int op3 = scanner.nextInt();
        for (RoomDetails roomDetails : roomOperations) {
            if((roomDetails.getDateFrom().after(sdf.parse(op)) || roomDetails.getDateTo().before(sdf.parse(op2))) && roomDetails.getBeds() >= op3){
                rooms.add(roomDetails);
            }
        }

        rooms.sort(new Comparator<RoomDetails>(){
            public int compare(RoomDetails o1, RoomDetails o2) {
                if (o1.getBeds() == o2.getBeds())
                    return 0;
                return o1.getBeds() < o2.getBeds() ? -1 : 1;
            }
        });
    }

    public void findUrgent(){

    }

    public void unavailable(){

    }
}

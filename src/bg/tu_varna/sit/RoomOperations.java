package bg.tu_varna.sit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomOperations {
    private RoomDetails roomDetails;
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<RoomDetails> roomOperations = new ArrayList<>();

    public void checkin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter room number.");
        int op = scanner.nextInt();
        System.out.println("Enter date from: ");
        String op1 = scanner.next();
        System.out.println("Enter date to: ");
        String op2 = scanner.next();
        System.out.println("Enter number of guests: ");
        int op3 = scanner.nextInt();
        for (RoomDetails roomDetails : roomOperations) {
            if(roomDetails.getRoomNumber() == op && !roomDetails.getNote().equals("Unavailable")){
                roomDetails.setNote("Taken");
                roomDetails.setDateFrom(sdf.parse(op1));
                roomDetails.setDateTo(sdf.parse(op2));
                roomDetails.setNumGuests(op3);
            }
        }
    }


    public void availability() throws ParseException {
        ArrayList availableRooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter date:");
        String op = scanner.next();
        if(op != null){

        for (RoomDetails roomDetails : roomOperations) {
            if(sdf.parse(op).before(roomDetails.getDateFrom()) || sdf.parse(op).after(roomDetails.getDateTo())){
                availableRooms.add(roomDetails);
            }
        }
            System.out.println(availableRooms);
        }else{
            Calendar calendar = Calendar.getInstance();
            sdf.format(calendar);
            for (RoomDetails roomDetails : roomOperations) {
                if(calendar.before(roomDetails.getDateFrom()) && calendar.after(roomDetails.getDateTo())){
                    availableRooms.add(roomDetails);
                }
            }
            for (Object roomDetails : availableRooms) {
                System.out.println(roomDetails);
            }
        }

    }

    public void checkout(){
        System.out.println("Enter room number: ");
        int op = scanner.nextInt();
        for (RoomDetails roomOperation : roomOperations) {
            if(roomDetails.getRoomNumber() ==  op && roomDetails.getNote().equals("Taken")){
                roomDetails.setNote("Available");
                roomOperation.setDateFrom(null);
                roomOperation.setDateTo(null);
                roomOperation.setNumGuests(0);
            }
        }

    }

    public void report() throws ParseException {
        ArrayList<RoomDetails> rooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter date from: ");
        String op = scanner.next();
        System.out.println("Enter date to: ");
        String op2 = scanner.next();

        for (RoomDetails roomDetails : roomOperations) {
            if(roomDetails.getDateFrom().after(sdf.parse(op)) || roomDetails.getDateTo().before(sdf.parse(op2))){
                rooms.add(roomDetails);
            }
        }
        System.out.println(rooms);
    }

    public void find() throws ParseException {
        ArrayList<RoomDetails> rooms = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter date from: ");
        String op = scanner.next();
        System.out.println("Enter date to: ");
        String op2 = scanner.next();
        System.out.println("Enter number of beds: ");
        int op3 = scanner.nextInt();
        for (RoomDetails roomDetails : roomOperations) {
            if(roomDetails.getBeds() >= op3){
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
        System.out.println("Enter number of guests: ");
        rooms.get(0).setNumGuests(scanner.nextInt());
        rooms.get(0).setNote("Taken");
        rooms.get(0).setDateFrom(sdf.parse(op));
        rooms.get(0).setDateTo(sdf.parse(op2));
    }

    public void findUrgent(){

    }

    public void unavailable() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter room number.");
        int op = scanner.nextInt();
        System.out.println("Enter date from: ");
        String op1 = scanner.next();
        System.out.println("Enter date to: ");
        String op2 = scanner.next();
        for (RoomDetails roomDetails : roomOperations) {
            if(roomDetails.getRoomNumber() == op){
                roomDetails.setNote("Unavailable");
                roomDetails.setDateFrom(sdf.parse(op1));
                roomDetails.setDateTo(sdf.parse(op2));
            }
        }
    }
}

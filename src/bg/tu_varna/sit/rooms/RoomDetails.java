package bg.tu_varna.sit.rooms;

import java.util.Date;

public class RoomDetails {
    private int roomNumber;
    private Date dateFrom;
    private Date dateTo;
    private String note;
    private int beds;
    private int numGuests;

    public RoomDetails(int roomNumber, Date dateFrom, Date dateTo, String note, int beds, int numGuests) {
        this.roomNumber = roomNumber;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.note = note;
        this.beds = beds;
        this.numGuests = numGuests;
    }
    public RoomDetails(){

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getBeds() {
        return beds;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    @Override
    public String toString() {
        return "RoomDetails{" +
                "roomNumber=" + roomNumber +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", note='" + note + '\'' +
                ", beds=" + beds +
                ", numGuests=" + numGuests +
                '}';
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
}

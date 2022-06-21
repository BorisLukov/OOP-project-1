package bg.tu_varna.sit;

import java.util.Date;

public class RoomDetails {
    private int roomNumber;
    private Date dateFrom;
    private Date dateTo;
    private String note;
    private int beds;

    public RoomDetails(int roomNumber, Date dateFrom, Date dateTo, String note, int beds) {
        this.roomNumber = roomNumber;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.note = note;
        this.beds = beds;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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

    public void setBeds(int beds) {
        this.beds = beds;
    }
}

package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Reservation {
    private int roomId;
    private int customerId;
    private Date checkIn;
    private Date checkOut;
    private Timestamp checkInTime;
    private String services;

    public Reservation(int roomId, int customerId, Date checkIn, Date checkOut, String services) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.checkInTime = new Timestamp(System.currentTimeMillis());
        this.services = services;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public String getServices() {
        return services;
    }
}

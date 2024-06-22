package model;

public class Room {
    private int capacity;
    private String description;
    private boolean seaView;
    private boolean jacuzzi;
    private boolean safe;

    public Room(int capacity, String description, boolean seaView, boolean jacuzzi, boolean safe) {
        this.capacity = capacity;
        this.description = description;
        this.seaView = seaView;
        this.jacuzzi = jacuzzi;
        this.safe = safe;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public boolean isSafe() {
        return safe;
    }
}


package entity;

import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<ParkingSlot> parkingSlotList;

    public ParkingLot(int capacity, List<ParkingSlot> parkingSlotList) {
        this.capacity = capacity;
        this.parkingSlotList = parkingSlotList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}

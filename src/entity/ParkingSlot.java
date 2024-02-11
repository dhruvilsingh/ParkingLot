package entity;

public class ParkingSlot {
    private static int slotNoInitializer = 1;
    private int slotNo;
    private Car car;

    public ParkingSlot() {
        this.slotNo = slotNoInitializer;
        slotNoInitializer++;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean getOccupiedStatus(){
        if(this.car == null)
            return false;
        return true;
    }
}

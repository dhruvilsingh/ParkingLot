package repository;

import entity.ParkingLot;
import entity.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepository {
    private ParkingLot parkingLot;

    public ParkingRepository(int capacity){
        List<ParkingSlot> parkingSlotList = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            parkingSlotList.add(new ParkingSlot());
        }
        parkingLot = new ParkingLot(capacity, parkingSlotList);
    }

    public void addCarToSlot(ParkingSlot parkingSlot){
        parkingLot.getParkingSlotList().set(parkingSlot.getSlotNo()-1, parkingSlot);
    }

    public ParkingSlot removeCarFromSlot(int slotNo){
        if(slotNo < 1  || slotNo > parkingLot.getCapacity()){
            System.out.println("Enter a valid slot number");
            return null;
        }

        ParkingSlot parkingSlot = parkingLot.getParkingSlotList().get(slotNo-1);

        parkingLot.getParkingSlotList().get(slotNo-1).setCar(null);
        return parkingSlot;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingLot.getParkingSlotList();
    }

    public int getCapacity(){
        return parkingLot.getCapacity();
    }
}

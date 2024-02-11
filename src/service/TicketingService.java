package service;

import entity.Car;
import entity.ParkingSlot;
import repository.ParkingRepository;

import java.util.*;

public class TicketingService {
    private PriorityQueue<ParkingSlot> parkingSlotPriorityQueue;
    private HashMap<String, List<ParkingSlot>> colorToSlotMap;
    private HashMap<String, Integer> regNoToSlotNoMap;
    private ParkingRepository parkingRepository;

    public TicketingService(int capacity){
        parkingSlotPriorityQueue = new PriorityQueue<>(capacity, Comparator.comparingInt(ParkingSlot::getSlotNo));
        this.colorToSlotMap = new HashMap<>();
        this.regNoToSlotNoMap = new HashMap<>();
        parkingRepository = new ParkingRepository(capacity);
        List<ParkingSlot> parkingSlotList = parkingRepository.getParkingSlotList();
        for(ParkingSlot ps : parkingSlotList){
            parkingSlotPriorityQueue.add(ps);
        }
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(String regNo, String color){
        if(parkingSlotPriorityQueue.isEmpty()){
            System.out.println("Sorry, parking lot is full");
            return ;
        }
        ParkingSlot parkingSlot = parkingSlotPriorityQueue.remove();
        Car car = new Car(regNo, color);
        parkingSlot.setCar(car);
        parkingRepository.addCarToSlot(parkingSlot);
        addCarToMap(regNo, color, parkingSlot);
        System.out.println("Allocated slot number: " + parkingSlot.getSlotNo());
    }

    public void exitCar(int slotNo){
        if(slotNo < 1  || slotNo > parkingRepository.getCapacity()){
            System.out.println("Enter a valid slot number");
            return ;
        }
        if(!parkingRepository.getParkingSlotList().get(slotNo-1).getOccupiedStatus()){
            System.out.println("The slot is already empty");
            return;
        }
        removeCarFromMap(parkingRepository.getParkingSlotList().get(slotNo-1));
        ParkingSlot parkingSlot = parkingRepository.removeCarFromSlot(slotNo);
        if(parkingSlot == null)
            return;
        parkingSlot.setCar(null);
        parkingSlotPriorityQueue.add(parkingSlot);
        System.out.println("Slot Number " + slotNo + " is free");
    }

    public List<ParkingSlot> getStatus(){
        List<ParkingSlot> occupiedParkingSlots = new ArrayList<>();
        for(ParkingSlot ps : parkingRepository.getParkingSlotList()){
            if(ps.getOccupiedStatus())
                occupiedParkingSlots.add(ps);
        }
        return occupiedParkingSlots;
    }

    public List<String> getRegNoByColor(String color){
        List<String> regNoList = new ArrayList<>();
        if(!colorToSlotMap.containsKey(color)){
            System.out.println("No car parked with this color");
            return null;
        }
        List<ParkingSlot> parkingSlots = colorToSlotMap.get(color);
        for(ParkingSlot ps : parkingSlots){
            regNoList.add(ps.getCar().getRegistrationNumber());
        }
        return regNoList;
    }

    public List<Integer> getSlotNoByColor(String color){
        List<Integer> slotNoList = new ArrayList<>();
        if(!colorToSlotMap.containsKey(color)){
            System.out.println("No car parked with this color");
            return null;
        }
        List<ParkingSlot> parkingSlots = colorToSlotMap.get(color);
        for(ParkingSlot ps : parkingSlots){
            slotNoList.add(ps.getSlotNo());
        }
        return slotNoList;
    }

    public int getSlotNoByRegNo(String regNo){
        if(!regNoToSlotNoMap.containsKey(regNo)){
            System.out.println("No car parked with this registration number");
            return 0;
        }
        return regNoToSlotNoMap.get(regNo);
    }

    private void removeCarFromMap(ParkingSlot parkingSlot) {
        Car car = parkingSlot.getCar();
        colorToSlotMap.get(car.getColor()).remove(parkingSlot);
        if(colorToSlotMap.get(car.getColor()).isEmpty())
            colorToSlotMap.remove(car.getColor());
        regNoToSlotNoMap.remove(car.getRegistrationNumber());
    }

    private void addCarToMap(String regNo, String color, ParkingSlot parkingSlot) {
        if(colorToSlotMap.containsKey(color)){
            colorToSlotMap.get(color).add(parkingSlot);
        }
        else{
            List<ParkingSlot> slotList = new ArrayList<>();
            slotList.add(parkingSlot);
            colorToSlotMap.put(color, slotList);
        }
        regNoToSlotNoMap.put(regNo, parkingSlot.getSlotNo());
    }

}

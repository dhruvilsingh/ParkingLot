import entity.ParkingSlot;
import service.TicketingService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketingService ticketingService = null;

        while (true) {
            System.out.print("Enter command - ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            switch (command[0]) {
                case "create_parking_lot":
                    if(command.length != 2){
                        System.out.println("Invalid arguments");
                        break;
                    }
                    int capacity;
                    try{
                        capacity = Integer.parseInt(command[1]);
                    }catch (NumberFormatException e){
                        System.out.println("Enter a valid capacity");
                        break;
                    }
                    ticketingService = new TicketingService(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    if(!validate(ticketingService,command, 3))
                        break;
                    String regNo = command[1];
                    String color = command[2];
                    ticketingService.parkCar(regNo, color);
                    break;
                case "leave":
                    if(!validate(ticketingService,command, 2))
                        break;
                    int slotNo;
                    try{
                        slotNo = Integer.parseInt(command[1]);
                    }catch (NumberFormatException e){
                        System.out.println("Enter a valid slot number");
                        break;
                    }
                    ticketingService.exitCar(slotNo);
                    break;
                case "status":
                    if(!validate(ticketingService,command, 1))
                        break;
                    List<ParkingSlot> parkingSlotList = ticketingService.getStatus();
                    System.out.println("Slot No.\t Registration No.\t Color");
                    for (ParkingSlot ps : parkingSlotList) {
                            System.out.println(ps.getSlotNo() + "\t" +
                                               ps.getCar().getRegistrationNumber() + "\t" +
                                               ps.getCar().getColor());
                    }
                    break;
                case "registration_numbers_for_cars_with_color":
                    if(!validate(ticketingService,command, 2))
                        break;
                    color = command[1];
                    List<String> regNoList = ticketingService.getRegNoByColor(color);
                    if(regNoList == null)
                        break;
                    for(String s : regNoList)
                        System.out.println(s);
                    break;
                case "slot_number_for_car_with_registration_number":
                    if(!validate(ticketingService,command, 2))
                        break;
                    regNo = command[1];
                    slotNo = ticketingService.getSlotNoByRegNo(regNo);
                    if(slotNo == 0)
                        break;
                    System.out.println(slotNo);
                    break;
                case "slot_numbers_for_cars_with_color":
                    if(!validate(ticketingService,command, 2))
                        break;
                    color = command[1];
                    List<Integer> slotNumberList = ticketingService.getSlotNoByColor(color);
                    if(slotNumberList == null)
                        break;
                    for(Integer i : slotNumberList)
                        System.out.println(i);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Enter a valid command");
                    break;
            }
        }
    }

    private static boolean validate(TicketingService ticketingService, String[] command, int noOfArguments){
        if (ticketingService == null){
            System.out.println("No parking lot exist! Create parking lot first");
            return false;
        }
        if(command.length != noOfArguments){
            System.out.println("Invalid arguments");
            return false;
        }
        return true;
    }
}
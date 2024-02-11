Clone the project compile and run.

Commands - 
create_parking_lot capacity
(Creates a parking lot with entered capacity)

park regNo color
(Parks the car at nearest slot)

leave slotNo
(Exits the car from entered slot)

status
(Displays all the cars parked)

registration_numbers_for_cars_with_color color
(Displays the registration numbers of all cars of enetered color)

slot_number_for_car_with_registration_number regNo
(Displays the slot number of the car with entered registration number)

slot_numbers_for_cars_with_color color
(Displays all slot numbers with cars of entered color)

exit
(exits)


Example -
$ create_parking_lot 6 
Created a parking lot with 6 slots 
$ park KA-01-HH-1234 White 
Allocated slot number: 1 
$ park KA-01-HH-9999 White 
Allocated slot number: 2 
$ park KA-01-BB-0001 Black 
Allocated slot number: 3 
$ park KA-01-HH-7777 Red 
Allocated slot number: 4 
$ park KA-01-HH-2701 Blue 
Allocated slot number: 5 
$ park KA-01-HH-3141 Black 
Allocated slot number: 6 
$ leave 4 
Slot number 4 is free 
$ status 
Slot No. Registration No Color 
1 KA-01-HH-1234 White 
2 KA-01-HH-9999 White
3 KA-01-BB-0001 Black 
5 KA-01-HH-2701 Blue 
6 KA-01-HH-3141 Black 
$ park KA-01-P-333 White 
Allocated slot number: 4 
$ park DL-12-AA-9999 White 
Sorry, parking lot is full 
$ registration_numbers_for_cars_with_color White 
KA-01-HH-1234
KA-01-HH-9999
KA-01-P-333 
$ exit

Clone the project compile and run.<br><br>

# Commands -
- create_parking_lot capacity <br>
(Creates a parking lot with entered capacity)

- park regNo color <br>
(Parks the car at nearest slot)

- leave slotNo <br>
(Exits the car from entered slot)

- status <br>
(Displays all the cars parked)

- registration_numbers_for_cars_with_color color <br>
(Displays the registration numbers of all cars of enetered color)

- slot_number_for_car_with_registration_number regNo <br>
(Displays the slot number of the car with entered registration number)

- slot_numbers_for_cars_with_color color <br>
(Displays all slot numbers with cars of entered color)

- exit <br>
(exits)

<br><br>
# Example -
$ create_parking_lot 6 <br>
Created a parking lot with 6 slots <br>
$ park KA-01-HH-1234 White <br>
Allocated slot number: 1 <br>
$ park KA-01-HH-9999 White <br>
Allocated slot number: 2 <br>
$ park KA-01-BB-0001 Black <br>
Allocated slot number: 3 <br>
$ park KA-01-HH-7777 Red <br>
Allocated slot number: 4 <br>
$ park KA-01-HH-2701 Blue <br>
Allocated slot number: 5 <br>
$ park KA-01-HH-3141 Black <br>
Allocated slot number: 6 <br>
$ leave 4 <br>
Slot number 4 is free <br>
$ status <br>
Slot No. Registration No Color <br>
1 KA-01-HH-1234 White <br>
2 KA-01-HH-9999 White <br>
3 KA-01-BB-0001 Black <br>
5 KA-01-HH-2701 Blue <br>
6 KA-01-HH-3141 Black <br>
$ park KA-01-P-333 White <br>
Allocated slot number: 4 <br>
$ park DL-12-AA-9999 White <br>
Sorry, parking lot is full <br>
$ registration_numbers_for_cars_with_color White <br>
KA-01-HH-1234 <br>
KA-01-HH-9999 <br>
KA-01-P-333 <br>
$ exit <br>

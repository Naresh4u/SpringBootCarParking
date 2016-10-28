# SpringBootCarParking

# Service URL: http://localhost:8888/swagger-ui.html

Parking lot automation

Develop a parking lot ticketing component which will support have 3 types of parking spaces (small, medium, large). The number of spaces should be configurable for each type. Whenever a car comes in, it will check for the availability based on parking history and either allocates the slot to the right car based on car size. Cars will be charged based on sizes, configurable. [Small à $2/hrs, ($ 10/day), medium à 3 $/hrs. ($ 15/day), large à $ 5/hrs. ($ 20/day)].

Guide lines

-        Any car driver will interact 2 times with the system. While coming in for parking (system to check availability) and while going out (system to calculate payment)

-        While coming in for Parking, the system should accept few criteria through command line and return a parking lot number, if parking is available.

-        While going out, system should accept the parking lot number and provide the calculated amount to be paid.

-        Use the best programming practices and code coverage with Test cases.

-        The code should be extensible and configurable.

-        For simplicity, there is no need to store data in the database. You can mimic the database call and store the data in a data structure, temporarily.

-        Provide all the assumptions made.

Artifact Expected

-        A high level approach document with assumptions. Not more than 2 pages. Keep it simple.

-        Code as a Maven project, which can be imported into Eclipse.


# Water-and-Energy-efficient-Irrigation-System

The idea of the project is to build a IoT based Irrigation system which irrigate the field automatically when the values of soil moisture, humidity and temperature sensed by the sensors are outside the critical or threshold values.				
The field is divided into grid type structure where each grid consists of a sprinkler which is connected to the water solenoid valve. The water solenoid valve is connected to the coordinator node which is sensing values of temperature, humidity and soil moisture. The coordinator is sending the sensed data to the PAN coordinator which is which is connected to the electric motor.
When any grid of the field has the values of soil moisture, humidity and temperature outside the threshold values, the coordinator generates an interrupt and then sends the sensed data to the PAN coordinator.
As the PAN coordinator receives the data from the coordinator it immediately switch ON the motor and the water starts flowing through the pipe. The solenoid valve of all the grids will be close except the one grid whose values of soil moisture, humidity and temperature is less than the threshold limits.
The coordinator sets the DIO pin of the microprocessor to 1 and sends a power of 3.3V to the MOSFET whose threshold voltage is 1.5V. As the DIO pin is set due to which the gate and source get connected which completes the circuit and a voltage of 24V is supplied to the water solenoid valve which allows the flow of water through the pipe hence the grids with values of soil moisture, humidity and temperature less then threshold values are irrigated.
When the values of soil moisture, humidity and temperature reaches the threshold limit, the interrupt is cleared and the coordinator stops sending the data to the PAN coordinator. As the PAN coordinator observes that the interrupt is cleared and no grid need to be irrigated so it switches OFF the electric motor and no more water is supplied. Since the values sensed are between the threshold values so the coordinator of the grid will clear its DIO pin which will break the circuit since gate and drain are disconnect. So, no power will reach to water solenoid value due to which valve will close and no more water can reach that part of field.

 
The circuit consists of the following
1.	 microcontroller which contains DIO and ground pins
2.	Water solenoid valve
3.	24V DC
4.	MOSFET
Problems which could occur-
1.	Water logging-  There could be possibility that the water have been logged around some sensor so the sensor will always tell the false value.
2.	False conditions detected by sensor-  There could be possibility that due to some fire in the nearby region the sensor will sense the false value of temperature and humidity and due to which our system can misbehave.

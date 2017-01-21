package mb224bd_assign1.ferry;

import java.util.ArrayList;

public abstract class Vehicle {
	
	// Stores the passengers in the vehicle
	protected ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	protected int size;
	
	public int getNrOfPassengers() {
		return passengers.size();
	}
	
	public int getSize() {
		return size;
	}
	
	/*
	 * Returns a copy of the passenger list,
	 * passenger objects are still shared!
	 */
	public ArrayList<Passenger> getPassengers() {
		ArrayList<Passenger> passengersCopy = new ArrayList<Passenger>(passengers.size());
	    for (Passenger passenger: passengers) passengersCopy.add(passenger);
	    return passengersCopy;
	}
}

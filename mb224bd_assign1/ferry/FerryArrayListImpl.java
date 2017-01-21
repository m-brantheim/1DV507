package mb224bd_assign1.ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryArrayListImpl implements Ferry {

	private ArrayList<Vehicle> vehicles;

	private ArrayList<Passenger> passengers;

	private int ferryPassengerCapacity = 200;

	// Bike has 1 in size and car 5
	private int ferryVehicleCapacity = 200;
	
	// Total money earned for the ferry, is incremented on disembarking
	private int moneyEarned = 0;

	/*
	 * Ferry constructor which creates new array lists
	 * for vehicles and passengers
	 */
	public FerryArrayListImpl() {
		vehicles = new ArrayList<Vehicle>();
		passengers = new ArrayList<Passenger>();
	}
	
	public int getMoneyEarned() {
		return moneyEarned;
	}

	@Override
	public int countPassengers() {
		return passengers.size();
	}

	/*
	 * Iterates through list of vehicles and gets their size
	 * Returns: total space occupied by the vehicles
	 */
	@Override
	public int countVehicleSpace() {
		int totalSpace = 0;
		Iterator<Vehicle> iterator = iterator();
		while(iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			totalSpace += vehicle.getSize();
		}
		return totalSpace;
	}

	/*
	 * Iterates through list of passengers and vehicles separately and calculates total cost
	 * Returns: Total ferry income for a given load
	 */
	@Override
	public int countMoney() {
		int totalMoney = 0;

		// Uses VehicleType enum to select cost per passenger
		for(Passenger passenger: passengers) {
			switch(passenger.getVehicleType()) {
			
			case NONE:
				totalMoney += 20;
				break;
				
			case BIKE:
				// Do nothing for now, implementation may be changed in the future
				break;
				
			case CAR:
				totalMoney += 15;
				break;

			case BUS:
				totalMoney += 10;
				break;

			case LORRY:
				totalMoney += 15;
				break;

			default:
				System.out.println("Vehicle type not recognized");
			}
		}

		// Dynamically determines subclass of vehicle to calculate cost
		for(Vehicle vehicle: vehicles) {
			if (vehicle instanceof Bike) {
				totalMoney += 40;
			} else if (vehicle instanceof Car) {
				totalMoney += 100;
			} else if (vehicle instanceof Bus) {
				totalMoney += 200;
			} else if (vehicle instanceof Lorry) {
				totalMoney += 300;
			}
		}

		return totalMoney;
	}

	@Override
	public Iterator<Vehicle> iterator() {
		return vehicles.iterator();
	}

	/*
	 * Embarks a vehicle if it has not been embarked before
	 * and there is enough space to fit it on the ferry
	 */
	@Override
	public void embark(Vehicle v) {
		if(!hasEmbarked(v)) {
			if(hasSpaceFor(v)) {
				ArrayList<Passenger> vehiclePassengers = new ArrayList<Passenger>();
				vehiclePassengers = v.getPassengers();
				for(Passenger p : vehiclePassengers){
					passengers.add(p);
				}
				vehicles.add(v);
			} else {
				System.out.println("Vehicle capacity of " + ferryVehicleCapacity + " has been reached, no more vehicles can be embarked");
			}
		} else {
			System.out.println("Vehicle has already embarked!");
		}
	}

	/*
	 * Embarks a passenger if there is enough space
	 */
	@Override
	public void embark(Passenger p) {
		if(hasRoomFor(p)) {
			passengers.add(p);
		} else {
			System.out.println("Passenger capacity of " + ferryPassengerCapacity + " has been reached, no more passengers can be embarked");
		}

	}

	/*
	 * Adds the money earned from the trip to moneyEarned, 
	 * which is saved between trips. Resets ferry by creating
	 * new array lists for vehicles and passengers
	 */
	@Override
	public void disembark() {
		moneyEarned += countMoney();
		vehicles = new ArrayList<Vehicle>();
		passengers = new ArrayList<Passenger>();
	}

	/*
	 * Checks if there is space for adding a vehicle
	 * Returns: true if there is space, false if not
	 */
	@Override
	public boolean hasSpaceFor(Vehicle v) {
		return countVehicleSpace() + v.getSize() <= ferryVehicleCapacity;
	}

	/*
	 * Checks if there is space for adding a passenger
	 * Returns: true if there is space, false if not
	 */
	@Override
	public boolean hasRoomFor(Passenger p) {
		return countPassengers() < ferryPassengerCapacity;
	}
	
	/*
	 * Checks if a vehicle has already embarked by comparing hash codes
	 * Returns: true if the vehicle has already embarked
	 */
	public boolean hasEmbarked(Vehicle v) {
		for(Vehicle vehicle: vehicles) {
			if(v.hashCode() == vehicle.hashCode()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		int bikes = 0;
		int cars = 0;
		int buses = 0;
		int lorries = 0;
		
		for(Vehicle vehicle: vehicles) {
			if (vehicle instanceof Bike) {
				bikes++;
			} else if (vehicle instanceof Car) {
				cars++;
			} else if (vehicle instanceof Bus) {
				buses++;
			} else if (vehicle instanceof Lorry) {
				lorries++;
			}
		}
		String status = "\n--------------------\n" +
						"Lorry status:\n" +
						"Total passengers: " + countPassengers() + "\n" +
						"Total vehicles: " + vehicles.size() + "\n" +
						"Total bikes: " + bikes + "\n" +
						"Total cars: " + cars + "\n" +
						"Total buses: " + buses + "\n" +
						"Total lorries: " + lorries + "\n" +
						"Money earned: " + moneyEarned +
						"\n--------------------\n";
		return status;
	}
}

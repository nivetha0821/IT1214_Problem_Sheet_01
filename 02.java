class Vehicle{
	private String licensePlate;
    private String ownerName;
    private int hoursParked;
	
	public Vehicle(String licensePlate,String ownerName,int hoursParked){
    this.licensePlate = licensePlate;
    this.ownerName = ownerName;
    this.hoursParked = hoursParked;
	}
	
	public String getLicensePlate(){
		 return licensePlate;
		}
	public void setLicensePlate(String licensePlate){
	     this.licensePlate = licensePlate;
		}
	public String getOwnerName(){
		return ownerName;
		}
	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
		}
	public int getHoursParked(){
		return hoursParked;
		}
	public void setHoursParked(int hoursParked){
		this.hoursParked = hoursParked;
		}
}

class ParkingLot{
	Vehicle[]  v1= new Vehicle[5];  
    int count = 0;
	
	public void parkVehicle(Vehicle pv){
    if (count < 5){
        v1[count] = pv;
        count++;
    }
	else{
        System.out.println("Parking lot is full.");
		}
	}	
		
	public void removeVehicle(String licensePlate){
    boolean found = false;
    for (int i = 0; i < count; i++){
        if (v1[i].getLicensePlate().equals(licensePlate)){
            for (int j = i; j < count - 1; j++){
                v1[j] = v1[j + 1];
            }
            v1[count - 1] = null;
            count--;
            found = true;
            System.out.println("Vehicle removed.");
            }
		}
    if (!found){
        System.out.println("Vehicle not found.");
		}
	}
	
	public void displayVehicles(){
    for (int i = 0; i < count; i++){
        System.out.println("Plate: " + v1[i].getLicensePlate() + ", Owner: " + v1[i].getOwnerName() +", Hours : " + v1[i].getHoursParked());
		}
	}
}

class Main{
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));
        lot.removeVehicle("XYZ789");
        lot.displayVehicles();
    }
}
package carNonFactory;

public class Client {
	public static void main(String[] args) {
		HonDa honDa= new HonDa();
		honDa.viewCar();
		honDa.driveCar();
		
		Toyota toyota= new Toyota();
		toyota.viewCar();
		toyota.driveCar();
	}

}


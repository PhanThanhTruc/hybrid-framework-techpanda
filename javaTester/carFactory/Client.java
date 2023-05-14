package carFactory;

public class Client {
	public static void main(String[] args) {
		Car car= CarFactory.getCartype(CarType.HONDA);
		car.driveCar();
		car.viewCar();
		car= CarFactory.getCartype(CarType.TOYOTA);
		car.driveCar();
		car.viewCar();
	}

}


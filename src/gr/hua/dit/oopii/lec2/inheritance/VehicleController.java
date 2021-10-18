//slide 48
package gr.hua.dit.oopii.lec2.inheritance;



public class VehicleController {
	public static void main(String args[] ){
		Car objCar = new Car();
		Bike objBike = new Bike();
		VehicleController vehicleControllerObj = new VehicleController();
		vehicleControllerObj.unifiedRun(objCar);
		vehicleControllerObj.unifiedRun(objBike);
	}
	
	public void unifiedRun(Vehicle inObj) {
		inObj.run();
	}
}

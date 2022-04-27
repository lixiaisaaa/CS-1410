package a1; 
//CS1410 Assignment 1: Driving Cost Calculator.
//Author name: Xia Li

public class DrivingCostCalculator{
	public static double calculateGasTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		double costOfDrivingInGas = (milesToDrive * dollarsPerGallon / milesPerGallon);
		return costOfDrivingInGas;
	}
	public static double calculateElectricTripCost(double milesToDrive, double milesPerKwh, double dollarsPerKwh) {
		double costOfDrivingInEle = (milesToDrive * dollarsPerKwh / milesPerKwh);
		return costOfDrivingInEle;
	}
	public static void displayBanner() {
		System.out.println("*****************************************");
		System.out.println("*          Driving Cost Calculator      *");
		System.out.println("*****************************************");
	}
	
public static void main(String[] args) {
	displayBanner();
	
double milesToDrive = 100.00;
double milesPerGallon = 28.00;
double dollarsPerGallon = 2.50;
double milesPerKwh = 4.00;
double dollarsPerKwh =  0.106;
double gasTripCost = calculateGasTripCost(milesToDrive,milesPerGallon,dollarsPerGallon );
double electricTripCost =  calculateElectricTripCost(milesToDrive, milesPerKwh, dollarsPerKwh);
String formattedGasTripCost = String.format("%.2f", gasTripCost);
String formattedElectricTripCost  = String.format("%.2f", electricTripCost );



System.out.println("The cost of a " + milesToDrive + "mile trip by gas is $" + formattedGasTripCost + " and by electric is $" + formattedElectricTripCost );
}	

}

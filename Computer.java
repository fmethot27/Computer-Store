package Assigmnent1;

public class Computer {


	private String brand;
	private String model;
	private double price;

	private long serialNumber;
	private long serialnumbercounter = 1000000;
	private int numOfComp = 0;

	public Computer(String cn, String br, String md, double pr) {
		
		
		brand = br;
		model = md;
		price = pr;
		serialNumber = serialnumbercounter;
		serialnumbercounter++;
		numOfComp++;
	}

		public String getBrand() {
		return brand;
	}

	public void setBrand(String br) {
		brand = br;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String md) {
		model = md;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "brand: " + brand + " \n " + "model: " + model + "\n " + "price: " + price + "\n" + "Serial Number: "
				+ serialNumber;
	}

	public int NumberOfCreatedComputers() {
		return numOfComp;
	}

	public boolean equal(Computer c) {
		if (brand == c.brand && model == c.model && price == c.price && numOfComp == c.numOfComp) {
			return true;
		} else {
			return false;
		}
	}

	public void displayInfo(int index) {
		// TODO Auto-generated method stub
		 System.out.println("Computer # " + numOfComp);
	        System.out.println("Brand: " + brand);
	        System.out.println("Model: " + model);
	        System.out.println("SN: " + serialNumber);
	        System.out.println("Price: $" + price);
	}

	public void displayInfo() {
		// TODO Auto-generated method stub
			System.out.println("Computer # " + numOfComp);
	        System.out.println("Brand: " + brand);
	        System.out.println("Model: " + model);
	        System.out.println("SN: " + serialNumber);
	        System.out.println("Price: $" + price);
	}
}


class Car extends Vehicle{
	
	 // variabler
	 protected String vehSize;
	 protected int nrOfDoors;
	 	
	    // konstruktorer
	    Car()
	    {
	        super(); // arv fr�n Vehicle
	        this.vehSize = "";
	        this.nrOfDoors = 0;
	    }
	    
	    Car(String brand, String registration, int price, String size, int doors)
	    {
	        super(brand, registration, price);
	        this.vehSize = size;
	        this.nrOfDoors = doors;
	    }
	     // get set metoder
	    public String getSize()
	    {
	        return this.vehSize;
	    }
	    
	    public int getDoors()
	    {
	        return this.nrOfDoors;
	    }
	     // klassmetoder
	    public void writeInfo()
	    {
	        super.writeInfo();
	        System.out.println("Fordonsstorlek: " + this.vehSize);
	        System.out.println("Antal d�rrar: " + this.nrOfDoors);
	    }
	    
	    public String toString()
	    {
	        String str = "";
	        str = super.toString();
	        str += "Fordonsstorlek: " + vehSize + "\n";
	        str += "Antal d�rrar: " + nrOfDoors + "\n";
	        
	        return str;
	    }
}


class Motorbike extends Vehicle {
	
	// variabler
	 protected int engineVolume;
	    
	 	// konstruktorer
	    Motorbike()
	    {
	        super();
	        this.engineVolume = 0;
	    }
	    
	    Motorbike(String brand, String registration, int price, int volume)
	    {
	        super(brand, registration, price);
	        this.engineVolume  = volume;
	    }
	    	  
	     // get
	    public int getVolume()
	    {
	        return this.engineVolume;
	    }
	    
	    // klassmetoder
	    public void writeInfo()
	    {
	        super.writeInfo();
	        System.out.println("Engine volume: " + this.engineVolume);
	    }
	    public String toString()
	    {
	        String str = "";
	        str = super.toString();
	        
	        str += "Engine volume: " + engineVolume + "\n";
	        
	        return str;
	    }
}


public class Vehicle {
	
	// variabler
	protected String vehBrand;
    protected String vehReg;
    protected int vehPrice;
    
    // konstruktorer
    
    Vehicle()
    {
        this.vehBrand = "";
        this.vehReg = "";
        this.vehPrice = 0;
    }
    
    Vehicle(String brand, String registration, int price)
    {
        this.vehBrand = brand;
        this.vehReg = registration;
        this.vehPrice = price;
    }   
    
    
    // get set metoder
    public String getBrand()
    {
        return this.vehBrand;
    }
    
    public String getReg()
    {
        return this.vehReg;
    }
    
    public int getPrice()
    {
        return this.vehPrice;
    }
    
    // klass-funktioner
    public void writeInfo()
    {
        System.out.println("Märke: " + this.vehBrand);
        System.out.println("Registreringsnummer: " + this.vehReg);
        System.out.println("Pris: " + this.vehPrice);
    }
    
    public boolean inPriceRange(int startPrice, int endPrice)
    {
        boolean inRange = false;
        if(this.vehPrice > startPrice && this.vehPrice < endPrice)
        {
            inRange = true;
            return inRange;
        }        
        return inRange;
    }
    
    public boolean includesBrand(String brandName)
    {
        boolean includes = false;
        if(this.vehBrand.compareToIgnoreCase(brandName) == 0)
        {
            includes = true;
            return includes;
        }        
        return includes;
    }
    
    public String toString()
    {
        String str = "Märke: " + vehBrand + "\n";
        str += "Registreringsnummer: " + vehReg + "\n";
        str += "Pris: " + vehPrice + "\n";
        
        return str;
    }
}

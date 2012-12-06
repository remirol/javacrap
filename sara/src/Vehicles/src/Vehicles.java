import java.util.ArrayList;
import java.util.Scanner; 

public class Vehicles 
{
	
	 // instans variabler
	protected String brand; // märke
	protected String licPlate; // registreringsnummer, string för att våra svenska nummer innehåller både bokstäver och siffror
	protected int  price;  // pris
	
	
	// konstruktor
	public Vehicles()
	{
		brand = "";
		licPlate = "";
		price = 0; 
	}
	public Vehicles(String brand, String licPlate, int price)
	{
		this.brand = brand; 
		this.licPlate = licPlate;
		this.price = price; 
	}

	// get och set metoder
	public void setBrand(String brand)
	{
		this.brand = brand; 
	}

	public void setPrice(int price)
	{
		this.price = price; 
	}

	public void setLicPlate(String licPlate)
	{
		this.licPlate = licPlate; 
	}

	public String getBrand()
	{
		return this.brand; 
	}

	public int getPrice()
	{
		return this.price; 
	}

	public String getLicPlate()
	{
		return this.licPlate; 
	}

	// övriga metoder

	public String toString()
	{
		String str = "Märke: " + brand + "\n";
		str += "Registreringsnummer: " + licPlate + "\n";
		str += "Pris: " + price + "\n";
		
		return str;
	}

	public boolean includes(String searchStr)
	{
		boolean search = false;
		return search; 
	}
	
	// sök på märke
	public boolean isbrand(String requestedBrand)
	{
		boolean searchBrand = false;
		if(brand.equalsIgnoreCase(requestedBrand))
		{
			searchBrand = true; 
		}
		return searchBrand;
	}
	
	// sök på prisintervall
	public boolean inPriceRange(int fromPrice, int toPrice)
	{
		boolean inPrice = false;
			if (price >= fromPrice && price <= toPrice) 
			{
				inPrice = true; 
			}
			return inPrice; 
	}	



}



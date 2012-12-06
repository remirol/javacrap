import java.util.ArrayList;
import java.util.Scanner; 

public class Vehicles 
{
	
	 // instans variabler
	protected String brand; // m�rke
	protected String licPlate; // registreringsnummer, string f�r att v�ra svenska nummer inneh�ller b�de bokst�ver och siffror
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

	// �vriga metoder

	public String toString()
	{
		String str = "M�rke: " + brand + "\n";
		str += "Registreringsnummer: " + licPlate + "\n";
		str += "Pris: " + price + "\n";
		
		return str;
	}

	public boolean includes(String searchStr)
	{
		boolean search = false;
		return search; 
	}
	
	// s�k p� m�rke
	public boolean isbrand(String requestedBrand)
	{
		boolean searchBrand = false;
		if(brand.equalsIgnoreCase(requestedBrand))
		{
			searchBrand = true; 
		}
		return searchBrand;
	}
	
	// s�k p� prisintervall
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



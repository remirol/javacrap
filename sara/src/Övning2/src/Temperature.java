import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		// deklaration av variabler

		double temp = 0;
		double minTemp = 0;
		double maxTemp = 0;
		double avarage = 0;
		double tempSum = 0;
		int nrOfDays = 0;
		Scanner keyboard = new Scanner(System.in);

		// start
		System.out.print("Antal dagar att mäta temperaturen: ");
		keyboard.nextInt();

		// bearbetning

		for (int day = 1; day <= day; day++)
		{
			System.out.println("Mata in temperaturen för dagen" + day + ": ");
			temp = keyboard.nextDouble();

			if (day == 1) {
				maxTemp = temp;
				minTemp = temp;
			}

			// maxTemp
			if (maxTemp < temp) {
				maxTemp = temp;
			}
			// minTemp
			if (minTemp > temp) {
				minTemp = temp;

			}
			// tempSum
			// tempSum = tempSum + temp; alternativt följande
			tempSum += temp;
		}

		avarage = tempSum / nrOfDays;

		// skriv ut

		System.out.print("Antal dagar: " + nrOfDays);
		System.out.print("Minsta temperaturen: " + minTemp);
		System.out.print("Minsta temperaturen: " + maxTemp);
		System.out.print("Medeltemperatur: : " + avarage);
	}

}

// Inl�mningsuppgift 4 @Christian �hl�n
package bankomat;
import java.util.Scanner;


public class Bankomat
{
    private static int balance = 0;

    public static int menu()
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Meny:\n" + "1. Ins�ttning\n"
            + "2. Uttag\n" + "3. Saldobesked" + '\n'
            + "4. Avsluta");
        System.out.print("Ditt val: ");
        choice = input.nextInt();
        return choice;
    }
    
    public static void showTransactions(int [] transactions, double balance)
    {
        System.out.println("Transaktioner:");
        for(int i = 0; i <= transactions.length-1; i++)
        {
            if(transactions[i] == 0)
            {
                System.out.print("");
            }
        
            else
            {
                for( i = 0;i < transactions.length-1; i++)
                {
                    System.out.println(transactions[i]);
                }
            }
        }
        System.out.println("Saldo: " + balance + " kr" + "\n" );
    }    
    
    public static void makeTransactions(int amount, int [] transactions)
    {
        int position = findNr(transactions);
        if(position == -1)
        {
            moveTrans(transactions);
            position = findNr(transactions);
            transactions[position] = amount;
        }
        transactions[position] = amount;
        balance += amount;
    }
    
    public static int findNr(int [] transactions)
    {
        int position = -1;

        for(int i = 0; i < transactions.length-1; i++)
        {
            if(transactions[i] == 0)
            {
                position = i;
                break;
            }
        }           
        return position;
    }    
    
    public static void moveTrans(int [] transactions)
    {
        for(int i = 0; i < transactions.length-1; i++)
        {
            transactions[i] = transactions[i + 1];
        }
        transactions[transactions.length-1] = 0;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int amount = 0;
        int choice = 0;
        int [] transactions = new int[11];
        int sum;


        while (choice != 4)
        {
            choice = menu();

            switch(choice)
            {

                case 1:
                System.out.print("Ange belopp f�r ins�ttning: ");
                sum = input.nextInt();

                if(sum <= 0)
                {
                    System.out.println("Felaktigt belopp. Ange ett positivt v�rde.");
                }

                else
                {
                    amount = (int) + sum;
                    makeTransactions(amount, transactions);
                    System.out.println("Du har satt in " + sum + " kr p� kontot.\n");
                }
                break;


                case 2:
                System.out.print("Ange belopp f�r uttag: ");
                sum = input.nextInt();
                
                if (sum > balance)
                {
                    System.out.println("Beloppet " + sum + " kr �r f�r stort. Du har " + balance + " kr p� kontot.\n");}
                
                else if(sum <= 0)
                {
                    System.out.println("Felaktigt belopp. Ange ett positivt v�rde.");
                }

                else
                {
                    amount = (int) - sum;
                    makeTransactions(amount, transactions);
                    System.out.println("Du har tagit ut " + sum + " kr fr�n kontot.");
                }
                break;

                case 3:
                showTransactions(transactions, balance);
                break;

                case 4:
                System.out.println("Programmet har avslutats.");
                break;
            }
        }
    }
}
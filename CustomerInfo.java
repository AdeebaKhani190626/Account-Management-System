package BMS;

import java.util.Random;
import java.util.Scanner;

/* ___________________________________________________________________________________________*/
/* --------------------------------------- Class 2 ----------------------------------------- */
public class CustomerInfo {

	protected String Name;
	protected String Address;
	protected long PhoneNo;
	protected int AccountNo;
	protected int AccPIN;
	protected String AccountType;
	protected float balance;
	protected String datecreated;
	protected float TransactionAmount;
	protected int TransactionCount;
	protected double zakat;
	protected float interest;
	protected float tax;
	protected float deductions; 
	
	CustomerInfo()
	{
		Name = "";
		Address = "";
		PhoneNo = 0;
		AccountNo = 0;
		AccPIN = 0;
		AccountType = "";
		balance = 0;
		datecreated = "";
		TransactionAmount = 0;
		TransactionCount = 0;
		zakat = 0;
		interest = 0;
		tax = 0;
		deductions = 0;
	}
	
	public void OpenAccount()
	{
		Scanner input= new Scanner(System.in);
		Scanner inputS= new Scanner(System.in);
		
		System.out.println("_________________________________________________________________________\n");                  
		System.out.println("         ----------- Enter the following Information --------------        ");
		System.out.print("\nName : ");
		String TName = input.nextLine();
		
		System.out.print("Account Type (Checking or Saving): ");
		String TAccountType = input.next();

		Name = TName;
		AccountType = TAccountType;
		
		BankManagementSystem BMS = new BankManagementSystem();
		boolean flag = BMS.CheckAccount(TName, TAccountType);
		
		if (flag == false)
		{
			System.out.print("Address : ");
			Address = inputS.nextLine();
			
			System.out.print("Phone Number : ");
			PhoneNo = input.nextLong();  
			
			System.out.print("Initial Balance : Rs ");
			balance = input.nextFloat();
			
			Random randNo = new Random();
			AccountNo = randNo.nextInt(100000);
			AccPIN = randNo.nextInt(10000);
			
			System.out.println("\n          **** YOUR ACCOUNT HAS BEEN CREATED SUCCESSFULLY ****     ");
			System.out.println("\nAccount No : " + AccountNo);
			System.out.println("Account PIN : " + AccPIN);	
		}
		else
		{
			System.out.println("\n          **** YOU ALREADY HAVE TWO ACCOUNTS ****     ");
		}
		
	}
	
	public void DisplayAccountInfo(int c)
	{
		System.out.println("_________________________________________________________________________\n");                  
		System.out.println("                  DISPLAYING ALL ACCOUNTS INFORMATION                      ");
		System.out.println("_________________________________________________________________________\n");
		
		System.out.println("Account " + (c) + " : ");
		System.out.println("Name         : " + Name );
		System.out.println("Address      : " + Address);
		System.out.println("PhoneNo      : " + PhoneNo);
		System.out.println("Account Type : " + AccountType);
		System.out.println("Account #    : " + AccountNo);
		System.out.println("PIN          : " + AccPIN);
		System.out.println("Date Created : " + java.time.LocalDate.now());
		System.out.println("Balance      : Rs " + balance);
	}
	
	public void DisplayAllDeductions(int c) // Zakat for Saving and Tax for Checking
	{
		System.out.println("_________________________________________________________________________\n");                  
		System.out.println("                  DISPLAYING ALL ACCOUNTS DEDUCTIONS                     ");
		System.out.println("_________________________________________________________________________\n");
		
		if (AccountType.equals("Saving"))
		{
			System.out.println("Account " + (c) + " : ");
			System.out.println("Name                    : " + Name );
			System.out.println("Address                 : " + Address);
			System.out.println("PhoneNo                 : " + PhoneNo);
			System.out.println("Account Type            : " + AccountType);
			System.out.println("Account #               : " + AccountNo);
			System.out.println("PIN                     : " + AccPIN);
			System.out.println("Date Created            : " + java.time.LocalDate.now());
			System.out.println("Balance                 : Rs " + balance);
			System.out.println("Transaction Amount      : Rs " + TransactionAmount);
			System.out.println("Zakat                   : Rs " + zakat);
			System.out.println("Total Deductions        : Rs " + (deductions+zakat));
			System.out.println("----------------------------------------------------");
			System.out.println("\nRemaining Balance     : Rs " + (balance-deductions));
			
		}
		else if (AccountType.equals("Checking"))
		{
			System.out.println("Account " + (c) + " : ");
			System.out.println("Name                    : " + Name );
			System.out.println("Address                 : " + Address);
			System.out.println("PhoneNo                 : " + PhoneNo);
			System.out.println("Account Type            : " + AccountType);
			System.out.println("Account #               : " + AccountNo);
			System.out.println("PIN                     : " + AccPIN);
			System.out.println("Date Created            : " + java.time.LocalDate.now());
			System.out.println("Balance                 : Rs " + balance);
			System.out.println("Transaction Amount      : Rs " + TransactionAmount);
			System.out.println("Tax                     : Rs " + tax);
			System.out.println("Total Deductions        : Rs " + (deductions+tax));
			System.out.println("----------------------------------------------------");
			System.out.println("\nRemaining Balance     : Rs " + (balance-deductions));
		}
		else
		{
			System.out.println("\n ** ACCOUNT TYPE NOT DETERMINED");
		}
	}
}

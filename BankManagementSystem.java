package BMS;

import java.util.Scanner;

/* ___________________________________________________________________________________________*/
/* --------------------------------------- Class 1 ----------------------------------------- */

public class BankManagementSystem extends CustomerInfo{
	
	public CustomerInfo data[]= new CustomerInfo[50]; // 50 Owners at Maximum at one run-time
	public int count = 0;
	
	/*  -------------  MENU ------------------ */
	public void BankMenu()
	{
		for (int i=0 ;i<50 ; i++){
			data[i] = new CustomerInfo();}
		int choice;
		
		do
		{	
			System.out.println("\n-------------------------------------------------------------------------");
			System.out.println("               WELCOME TO OUR BANK MANAGEMENT SYSTEM                     ");
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.println("1. Open an Account");
			System.out.println("2. Close an Account");
			System.out.println("3. Login to a specific Account");
			System.out.println("4. Operations for Saving Account");
			System.out.println("5. Operations for Checking Account");
			System.out.println("6. Interest Rate");
			System.out.println("7. All Account Details");
			System.out.println("8. All Account Deductions");
			System.out.println("0. To Exit the System Press 0\n");
			
			Scanner input = new Scanner(System.in);
			Scanner inputS = new Scanner(System.in);
			
			System.out.print("Enter any operation : ");
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
			{	
				data[count].OpenAccount();
				count++;
				break;
			}
			case 2:
			{
				if (count == 0)
				{
					System.out.println("\n ** There are no Accounts in our DataBase. Create one to Close it.");
				}
				else
				{
					System.out.println("_________________________________________________________________________\n");                  
					System.out.println("         ----------- Enter the following Information --------------        ");
					
					System.out.print("Account No : ");
					int AccNo = input.nextInt();
					System.out.print("Account PIN : ");
					int AccPIN = input.nextInt();
					
					int check = 0;
					/*  -------------  SEARCH ACCOUNT ------------------ */
					System.out.println(count + "total");
					for (int i = 0; i<count ; i++){
						if (data[i].AccountNo == AccNo){
							data[i] = data[count - 1];
							count = count-1;
							check = 1;
							break;}
					}
					
					if (check == 1)
					{System.out.println("\n          **** YOUR ACCOUNT HAS BEEN CLOSED SUCCESSFULLY ****     ");}
					else
					{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
				}
					break;
			}
			case 3:
			{
				System.out.println("_________________________________________________________________________\n");                  
				System.out.println("         ----------- Enter the following Information --------------        ");
				
				System.out.print("Account No : ");
				int AcNo = input.nextInt();
				System.out.print("Account PIN : ");
				int AcPIN = input.nextInt();
				
				int check = 0;
				/*  -------------  SEARCH ACCOUNT ------------------ */
				for (int i = 0; i<count ; i++){
					if (data[i].AccountNo == AcNo){
						check = 1;
						break;}
				}
				
				if (check == 1)
				{System.out.println("\n          **** YOUR ACCOUNT HAS BEEN LOGGED IN SUCCESSFULLY ****     ");}
				else
				{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
			
				break;
			}
			case 4:
			{
				int ch;
				do
				{	
					System.out.println("_________________________________________________________________________\n");                  
					System.out.println("        ------------- OPERATIONS FOR SAVING ACCOUNT--------------          ");
					
					System.out.println("\n1. Check Balance ");
					System.out.println("2. Print Statement ");
					System.out.println("3. Make Deposit ");
					System.out.println("4. Make Withdrawal ");
					System.out.println("5. Transfer Amount ");
					System.out.println("6. Calculate Zakat ");
					System.out.println("7. Calculate Interest ");
					System.out.println("0. To Go Back to Main Menu ");
					
					Scanner i1 = new Scanner(System.in);
					
					System.out.print("\nEnter any operation : ");
					ch = i1.nextInt();
					
					switch(ch)
					{
					case 1:
					{
						System.out.println("\n >> CHECKING ACCOUNT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving"))
							{	SavingAccount S1 = new SavingAccount();
								S1.CheckBalance(data[an]);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
					
						break;
					}
					case 2:
					{
						System.out.println("\n >> PRINTING STATEMENT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving")) {
							SavingAccount S1 = new SavingAccount();
							S1.PrintStatement(data[an]);}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 3:
					{
						System.out.println("\n >> MAKING DEPOSIT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving")) {
							System.out.print("\nEnter the amount you want to deposit : Rs");
							float am = input.nextFloat();
							SavingAccount S1 = new SavingAccount();
							S1.MakeDeposit(data[an],am);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 4:
					{
						System.out.println("\n >> MAKING WITHDRAWAL ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving")) {
							System.out.print("\nEnter the amount you want to withdraw : Rs");
							float am = input.nextFloat();
							SavingAccount S1 = new SavingAccount();
							S1.WithdrawAmount(data[an],am);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 5:
					{
						System.out.println("\n >> TRANSFERRING MONEY ");
						
						System.out.print("\nYour Account No : ");
						int AcNo = input.nextInt();
						System.out.print("Account No (to which you want to transfer) : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0; int ab = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcPIN){
								an = i;
								check += 1;
								break;}
						}
						
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								ab = i;
								check += 1;
								break;}
						}
						
						if (check == 2)
						{
							if (data[ab].AccountType.equals("Saving")){
							System.out.print("\nEnter the amount you want to deposit : Rs");
							float am = input.nextFloat();
							SavingAccount S1 = new SavingAccount();
							S1.TransferAmount(data[an],am,data[ab]);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** YOUR OR THE ACCOUNT YOU WANT TO TRANSFER MONEY TO DOES NOT EXIST ****     ");}
						
						break;
					}
					case 6:
					{
						System.out.println("\n >> CALCULATING ZAKAT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving"))
							{
							SavingAccount S1 = new SavingAccount();
							S1.CalculateZakat(data[an]);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 7:
					{
						System.out.println("\n >> CALCULATING INTEREST ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Saving"))
							{
								System.out.print("\nEnter the Interest Rate : ");
								float am = input.nextFloat();
								SavingAccount S1 = new SavingAccount();
								S1.CalculateInterest(data[an],am);
							}
							else
							{System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 0:
					{
						break;
					}
					default:
					{
						if (ch == 0)
						{
							break;
						}
						else
						{	
						System.out.println("\nYou entered an invalid operation !!! TRY AGAIN \n");
						}
						break;
					}
					}
					
				}while(ch != 0);
			}
			case 5:
			{
				int ch;
				do
				{	
					System.out.println("_________________________________________________________________________\n");                  
					System.out.println("        ------------- OPERATIONS FOR CHECKING ACCOUNT--------------          ");
					
					System.out.println("\n1. Check Balance ");
					System.out.println("2. Print Statement ");
					System.out.println("3. Make Deposit ");
					System.out.println("4. Make Withdrawal ");
					System.out.println("5. Transfer Amount ");
					System.out.println("0. To Go Back to Main Menu ");
					
					Scanner i1 = new Scanner(System.in);
					
					System.out.print("\nEnter any operation : ");
					ch = i1.nextInt();
					
					switch(ch)
					{
					case 1:
					{
						System.out.println("\n >> CHECKING ACCOUNT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Checking"))
							{	CheckingAccount S1 = new CheckingAccount();
								S1.CheckBalance(data[an]);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A CHECKING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
					
						break;
					}
					case 2:
					{
						System.out.println("\n >> PRINTING STATEMENT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Checking")) {
							CheckingAccount S1 = new CheckingAccount();
							S1.PrintStatement(data[an]);}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A CHECKING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 3:
					{
						System.out.println("\n >> MAKING DEPOSIT ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Checking")) {
							System.out.print("\nEnter the amount you want to deposit : Rs");
							float am = input.nextFloat();
							CheckingAccount S1 = new CheckingAccount();
							S1.MakeDeposit(data[an],am);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A CHECKING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 4:
					{
						System.out.println("\n >> MAKING WITHDRAWAL ");
						
						System.out.print("\nAccount No : ");
						int AcNo = input.nextInt();
						System.out.print("Account PIN : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								an = i;
								check = 1;
								break;}
						}
						
						if (check == 1)
						{
							if (data[an].AccountType.equals("Checking")) {
							System.out.print("\nEnter the amount you want to withdraw : Rs");
							float am = input.nextFloat();
							CheckingAccount S1 = new CheckingAccount();
							S1.WithdrawAmount(data[an],am);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A CHECKING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
						
						break;
					}
					case 5:
					{
						System.out.println("\n >> TRANSFERRING MONEY ");
						
						System.out.print("\nYour Account No : ");
						int AcNo = input.nextInt();
						System.out.print("Account No (to which you want to transfer) : ");
						int AcPIN = input.nextInt();
						
						int check = 0; int an = 0; int ab = 0;
						/*  -------------  SEARCH ACCOUNT ------------------ */
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcPIN){
								an = i;
								check += 1;
								break;}
						}
						
						for (int i = 0; i<count ; i++){
							if (data[i].AccountNo == AcNo){
								ab = i;
								check += 1;
								break;}
						}
						
						if (check == 2)
						{
							if (data[ab].AccountType.equals("Checking")){
							System.out.print("\nEnter the amount you want to deposit : Rs");
							float am = input.nextFloat();
							CheckingAccount S1 = new CheckingAccount();
							S1.TransferAmount(data[an],am,data[ab]);
							}
							else
							{
								System.out.println("\n          **** YOU DO NOT HAVE A CHECKING ACCOUNT ****     ");
							}
						}
						else
						{System.out.println("\n          **** YOUR OR THE ACCOUNT YOU WANT TO TRANSFER MONEY TO DOES NOT EXIST ****     ");}
						
						break;
					}
					case 0:
					{
						break;
					}
					default:
					{
						if (ch == 0)
						{
							break;
						}
						else
						{	
						System.out.println("\nYou entered an invalid operation !!! TRY AGAIN \n");
						}
						break;
					}
					}
					
				}while(ch != 0);
				break;
			}
			case 6:
			{
				System.out.println("\n >> CALCULATING INTEREST ");
				
				System.out.print("\nAccount No : ");
				int AcNo = input.nextInt();
				System.out.print("Account PIN : ");
				int AcPIN = input.nextInt();
				
				int check = 0; int an = 0;
				/*  -------------  SEARCH ACCOUNT ------------------ */
				for (int i = 0; i<count ; i++){
					if (data[i].AccountNo == AcNo){
						an = i;
						check = 1;
						break;}
				}
				
				if (check == 1)
				{
					if (data[an].AccountType.equals("Saving"))
					{
						System.out.print("\nEnter the Interest Rate : ");
						float am = input.nextFloat();
						SavingAccount S1 = new SavingAccount();
						S1.CalculateInterest(data[an],am);
					}
					else
					{System.out.println("\n          **** YOU DO NOT HAVE A SAVING ACCOUNT ****     ");}
				}
				else
				{System.out.println("\n          **** THIS ACCOUNT DOES NOT EXIST ****     ");}
			
				break;
			}
			case 7:
			{
				if (count == 0)
				{
					System.out.println("\n ** There are no Accounts in our DataBase. Create one to Display it.");
				}
				for(int i=0 ; i<count ; i++)
				{
					data[i].DisplayAccountInfo(i+1);
				}
				break;
			}
			
			case 8:
			{
				SavingAccount sa = new SavingAccount();
				if (count == 0)
				{
					System.out.println("\n ** There are no Accounts in our DataBase. Create one to Display it.");
				}
				for(int i=0 ; i<count ; i++)
				{
					//sa.CalculateZakat(data[i]);
					data[i].DisplayAllDeductions(i+1);
				}
				break;
			}
			default:
			{
				if (choice == 0)
				{
					break;
				}
				else
				{	
				System.out.println("\nYou entered an invalid operation !!! TRY AGAIN \n");
				break;
				}
			}
			}
		}while(choice != 0);	
	}
	
	/*  -------------  CHECK ACCOUNTS ------------------ */
	public boolean CheckAccount(String n, String t)
	{
		boolean check = false;
		for(int i=0 ; i<count ; i++)
		{
			System.out.println(data[i].Name);
			
			if (data[i].Name.equals(n))
			{
				System.out.println("\nThere is already an account with this name.");
				if (data[i].AccountType.equals(t))
				{
					System.out.println("\nThere is already a " + t + "account with your name.");
					check = true;
					break;
				}
			}
		}
		return check;
	}

}
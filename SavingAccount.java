package BMS;

/* Adeeba Khan
   i190626 (E)
   AP - Task 01 */

/* __________________________________________________________________________________________________________*/
/* --------------------------------------- Class 3 : SAVING ACCOUNT -----------------------------------------*/
/* __________________________________________________________________________________________________________*/

public class SavingAccount extends CustomerInfo{
	
	public void CheckBalance(CustomerInfo obj) // name and balance
	{
		System.out.println("\nName : " + obj.Name);
		System.out.println("Balance : Rs " + obj.balance);
	}
	
	public void PrintStatement(CustomerInfo obj) // customer, account no, time and date of transaction, transaction amount, remaining balance
	{
		System.out.println("\n--------------------------------------------------------------------------");
		System.out.println("\nName                :  " + obj.Name);
		System.out.println("Account #           :  " + obj.AccountNo);
		System.out.println("Date of Transaction :  " + java.time.LocalDate.now());
		System.out.println("Time of Transaction :  " + java.time.LocalTime.now());
		System.out.println("Transaction Amount  :  " + obj.TransactionAmount);
		System.out.println("Remaining Amount    :  Rs " + obj.balance);
	}
	
	public void MakeDeposit(CustomerInfo obj,float amount) // deposits the desired amount
	{
		obj.balance = obj.balance + amount;
		obj.TransactionAmount = obj.TransactionAmount + amount;
	}
	
	public void TransferAmount(CustomerInfo obj1, float amount, CustomerInfo obj2) // transfers the desired amount
	{
		if(amount<=obj2.balance)
		{
			obj1.balance = obj1.balance + amount;
			obj2.balance = obj2.balance - amount;
			obj1.TransactionAmount = obj1.TransactionAmount + amount;
			obj2.TransactionAmount = obj2.TransactionAmount + amount;
		}
		else
		{
			System.out.println(" ** You do not have enough Balance in your account for making a Transfer !!!");
		}
	}
	
	public void CalculateZakat(CustomerInfo obj) // For saving account only
	{
		if (obj.balance >= 20000)
		{
			obj.zakat = obj.balance*2.5;
			obj.zakat = obj.zakat/100;
			System.out.println("\nZakat : Rs " + obj.zakat);
		}
		else
		{
			System.out.println(" ** You do not have enough Balance in your account for Zakat Calculation !!!");
		}
	}
	
	public void WithdrawAmount(CustomerInfo obj,float amount) // no more than the balance
	{
		if (amount <= obj.balance)
		{
			obj.balance = obj.balance - amount;
			obj.TransactionAmount = obj.TransactionAmount + amount;
		}
		else
		{
			System.out.println(" ** You do not have enough Balance in your account for making a Withdrawal !!!");
		}
	}	
	
	public void CalculateInterest(CustomerInfo obj, float in)
	{
		obj.interest = (obj.balance*in)/100;
		System.out.println("\nInterest : Rs " + obj.interest);
	}
}

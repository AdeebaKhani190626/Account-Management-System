package BMS;

/* _____________________________________________________________________________________________________________*/
/* --------------------------------------- Class 4 : CHECKING ACCOUNT ----------------------------------------- */
/* _____________________________________________________________________________________________________________*/

public class CheckingAccount extends SavingAccount{
	
	public void WithdrawAmount(CustomerInfo obj,float amount)
	{
		obj.TransactionCount++;
		if(obj.TransactionCount > 2) {
		if (obj.balance-amount <= 5000)
		{
			obj.balance = obj.balance - amount;
			obj.TransactionAmount = obj.TransactionAmount + amount;
			obj.tax += 10;
		}
		else
		{
			System.out.println(" ** You do not have enough Balance in your account for making a Withdrawal !!!");
		}
		}	
		else
		{
			obj.balance = obj.balance - amount;
			obj.TransactionAmount = obj.TransactionAmount + amount;
		}
	}
	
	public void MakeDeposit(CustomerInfo obj,float amount) // deposits the desired amount
	{
		obj.TransactionCount++;
		if(obj.TransactionCount > 2)
		{
			obj.balance = obj.balance + amount;
			obj.TransactionAmount = obj.TransactionAmount + amount;
			obj.tax += 10;
		}
		else
		{
			obj.balance = obj.balance + amount;
			obj.TransactionAmount = obj.TransactionAmount + amount;
		}
	}
}

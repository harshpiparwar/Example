package AccountSystemDemo;
import AccountSystem.Account;
import AccountSystemExceptions.InsufficientBalanceException;
import TypesOfAccounts.*;
class AccountSystemDemo
{
	public static void main(String[]args)
	{
		/*
		Account Act1=new Account(1);
		
		Act1.DepositeAmount(1000.00);
		System.out.println("Initial balance of "+Act1.Get_AccountNo()+" is Rs."+Act1.GetBalance()+"/-");
		try
		{
			Act1.WithdrawAmount(500.00);
			System.out.println("After withdrawal balance of "+Act1.Get_AccountNo()+" is Rs."+Act1.GetBalance()+"/-");
		}
		catch(InsufficientBalanceException Ex)
		{
			System.out.println("Sorry..you don't have sufficient balance in AccountNo: "+Act1.Get_AccountNo());	
		}
		Account Act2=new Account(2);	
		Act2.DepositeAmount(5000.00);
		System.out.println("Initial balance of "+Act2.Get_AccountNo()+" is Rs."+Act2.GetBalance()+"/-");

		*/		

		SavingsAccount Sact3=new SavingsAccount(3,1000.00);
		Sact3.OpenAccount();
		System.out.println("Initial balance of "+Sact3.Get_AccountNo()+" is Rs."+Sact3.GetBalance()+"/-");
		Sact3.DepositeAmount(5000.00);
		System.out.println("After 1st deposite balance of AccountNo: "+Sact3.Get_AccountNo()+" is Rs. "+Sact3.GetBalance());		
		Sact3.EarnInterest();
		System.out.println("After earning interest balance of AccountNo: "+Sact3.Get_AccountNo()+" is Rs. "+Sact3.GetBalance());		
		try
		{
			Sact3.WithdrawAmount(6000.00);
			System.out.println("After withdrawal balance of "+Sact3.Get_AccountNo()+" is Rs."+Sact3.GetBalance()+"/-");
		}
		catch(InsufficientBalanceException Ex)
		{
			System.out.println("Sorry..you don't have sufficient balance in AccountNo: "+Sact3.Get_AccountNo());	
		}
		Sact3.CloseAccount();

	
		SalaryAccount Sact4=new SalaryAccount(4);
		Sact4.OpenAccount();
		System.out.println("Initial balance of "+Sact4.Get_AccountNo()+" is Rs."+Sact4.GetBalance()+"/-");
		Sact4.DepositeAmount(10000.00);
		System.out.println("After crediting 1st salary balance of AccountNo: "+Sact4.Get_AccountNo()+" is Rs. "+Sact4.GetBalance());		
		Sact4.EarnInterest();
		System.out.println("After earning interest balance of AccountNo: "+Sact4.Get_AccountNo()+" is Rs. "+Sact4.GetBalance());		
		
		try
		{
			Sact4.WithdrawAmount(11000.00);
			System.out.println("After withdrawal balance of "+Sact4.Get_AccountNo()+" is Rs."+Sact4.GetBalance()+"/-");
		}
		catch(InsufficientBalanceException Ex)
		{
			System.out.println("Sorry..you don't have sufficient balance in AccountNo: "+Sact4.Get_AccountNo());	
		}
		Sact3.CloseAccount();
		

		/*
			We want to excercise same flow using same data on 2 objects
		*/

		System.out.println("++++++++++++++++++RUNTIME POLYMORPHISM IS IN PROGRESS:+++++++");
		Account Sact31=GetAccountType(args[0]);
		Sact31.OpenAccount();
		System.out.println("Initial balance of "+Sact31.Get_AccountNo()+" is Rs."+Sact31.GetBalance()+"/-");
		Sact31.DepositeAmount(5000.00);
		System.out.println("After 1st deposite balance of AccountNo: "+Sact31.Get_AccountNo()+" is Rs. "+Sact31.GetBalance());		
		Sact31.EarnInterest();
		System.out.println("After earning interest balance of AccountNo: "+Sact31.Get_AccountNo()+" is Rs. "+Sact31.GetBalance());		
		try
		{
			Sact31.WithdrawAmount(6000.00);
			System.out.println("After withdrawal balance of "+Sact31.Get_AccountNo()+" is Rs."+Sact31.GetBalance()+"/-");
		}
		catch(InsufficientBalanceException Ex)
		{
			System.out.println("Sorry..you don't have sufficient balance in AccountNo: "+Sact31.Get_AccountNo());	
		}
		Sact31.CloseAccount();

	}

	static Account GetAccountType(String AccountType)
	{
		switch(AccountType)
		{
			case "Savings":
				return new SavingsAccount(5,1000);
				

			case "Salary":
				return new SalaryAccount(6);
				
		}
		return null;
	}

}
public class ATM {
	
	private Account userAct;
	
	public ATM(Account userAct) {
		this.userAct = userAct;
	}
	
	public void Withdraw(double amount) {
		
		if(userAct.Withdraw(amount)) {
			System.out.printf("You withdrew $%.2f.\n\n", amount);
			System.out.printf("Your current balance is $%.2f.\n", userAct.getBalance());
		}
		else {
			System.out.println("The amount you are attempting to withdraw is too great for your bank balance.\n");
		}
		
	}
	public void Deposit(double amount) {
		System.out.printf("You have deposited $%.2f into your bank account.\n", amount);
		System.out.printf("Your new balance is $%.2f.\n\n", userAct.Deposit(amount));
			
	}
}




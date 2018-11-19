public class Account {
	
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public boolean Withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public double Deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double getBalance() {
		return balance;
	}
}
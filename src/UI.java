import java.util.Scanner;

public class UI {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[]args) {
		User ek = new User("Eshita Kar", 1234, 00000001);
		Account ekAct = new Account(0);
		ATM atmOne = new ATM(ekAct);
		System.out.println("Welcome to your ATM!");
		boolean validAct = false;
		boolean validPin = false;
		while(!validAct || !validPin) {
			System.out.print("Please enter your account number and pin number.\n Account #: ");
			long temAct = in.nextLong();
			System.out.print(" Pin: ");
			int temPin = in.nextInt();
			if(temAct != ek.getAcctNum() || temPin != ek.getPin()) {
				System.out.println("\nInvalid account number or pin number. Try again.");
			}
			else {
				validAct = true;
				validPin = true;
			}
		}
		atmFunction(ek, ekAct, atmOne);
		System.out.println("\nThank you for using this ATM!");
		in.close();
	}
	
	public static void atmFunction(User user, Account userAct, ATM atm) {
		boolean endTask = false;
		while(!endTask) {
			System.out.println("\n\nHello, " + user.getName() + "! What can I help you with?\n");
			System.out.println("[1] Deposit\n[2] Withdraw\n[3] View Balance\n[4] Exit.");
			int userInput = in.nextInt();
			if(userInput == 1) {
				System.out.println("How much would you like to deposit?\nDeposit Amount: ");
				double amount = in.nextDouble();
				if(amount <= 0) {
					System.out.println("Invalid amount.");
					Continue();
				}
				else {
					atm.Deposit(amount);
					Continue();
				}
			}
			else if(userInput == 2) {
				System.out.println("How much would you like to withdraw?\nWithdraw Amount: ");
				double amount = in.nextDouble();
				if(amount <= 0) {
					System.out.println("Invalid amount.");
					Continue();
				}
				else {
					atm.Withdraw(amount);
					Continue();
				}
			}
			else if(userInput == 3) {
				System.out.printf("Your current balance is: $%.2f.\n", userAct.getBalance());
				Continue();
			}
			else if(userInput == 4){
				System.out.println("You have been signed out of your account.");
				endTask = true;
			}
			else {
				System.out.println("Invalid input. Try again.\n");
			}
		}
	}
	
	public static void Continue() {
		System.out.println("Press enter to continue.\n");
		in.nextLine();
		in.nextLine();
		//System.out.println("\n\n\n\n\n\n\n\n\n");
	}
}
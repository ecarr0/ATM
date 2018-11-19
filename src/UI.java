import java.util.Scanner;

public class UI {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[]args) {
		User ek = new User(00000001,"Eshita Kar", 1234, 123456, 00000000, "123 Street Road, City, State", 1234567890);
		Account ekAct = new Account(0);
		ATM atmOne = new ATM(ekAct);
		long previousAcctNum = ek.getAcctNum();
		long previousUserNum = ek.getUserNum();
		System.out.println("Welcome to your ATM!");
		boolean validAct = false;
		boolean validPin = false;
		boolean moveOn = false;
		while(!moveOn) {
			System.out.println("\n\nPress [1] to sign in.\nPress [2] to sign up for a new account.");
			int option = in.nextInt();
			if(option == 2) {
				in.nextLine();
				System.out.printf("Enter your full legal name: ");
				String newName = in.nextLine();
				//in.next();
				System.out.printf("\nEnter your address: ");
				String newAddress = in.nextLine();
				//in.next();
				System.out.printf("\nEnter your phone number: ");
				long newPhoneNum = in.nextLong();
				//in.next();
				System.out.printf("\nEnter your SSN: ");
				long newSSN = in.nextLong();
				long newAcctNum = previousAcctNum + 1;
				previousAcctNum = newAcctNum;
				long newUserNum = previousUserNum + 1;
				previousUserNum = newUserNum; 
				System.out.printf("\nThank you for setting up your account. Your account number is %08d", newAcctNum);
				System.out.printf("\nEnter a pin for this account: ");
				int newPin = in.nextInt();
				ek = new User(newUserNum, newName, newPin, newAcctNum, newSSN, newAddress, newPhoneNum);
				ekAct = new Account(0);
				atmOne = new ATM(ekAct);
				System.out.println("Please sign in again using your new account credentials.");
				moveOn = false;
			}
			else if (option == 1) { 
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
					moveOn = true;
				}
				
			}
			else {
				System.out.println("Invalid response. Try again.");
				moveOn = false;
			}
		}
		if(moveOn) {
			atmFunction(ek, ekAct, atmOne);
			System.out.println("\nThank you for using this ATM!");
			in.close();
		}
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
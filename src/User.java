public class User {
	
	private String name;
	private int pin;
	private long acctNum;
	//private int SSN;
	//private String username;
	//private String password;
	//private String address;
	//private int phoneNum;
	
	public User(String name, int pin, long acctNum) {
		this.name = name;
		this.pin = pin;
		this.acctNum = acctNum;
		//this.SSN = SSN;
		//this.username = username;
		//this.password = password;
		//this.address = address;
		//this.phoneNum = phoneNum;
	}
	
	public int getPin() {
		return pin;
	}
	public long getAcctNum() {
		return acctNum;
	}
	public String getName() {
		return name;
	}
}
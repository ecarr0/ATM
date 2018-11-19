public class User {
	
	private String name;
	private int pin;
	private long acctNum;
	private long SSN;
	private long userNum;
	//private String username;
	//private String password;
	private String address;
	private long phoneNum;
	
	public User(long userNum, String name, int pin, long acctNum, long SSN, String address, long phoneNum) {
		this.userNum = userNum;
		this.name = name;
		this.pin = pin;
		this.acctNum = acctNum;
		this.SSN = SSN;
		//this.username = username;
		//this.password = password;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	public int getPin() {
		return this.pin;
	}
	public long getAcctNum() {
		return this.acctNum;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public long getUserNum() {
		return this.userNum;
	}
	public long getPhoneNum() {
		return this.phoneNum;
	}
	public void setPhoneNum(int newPhoneNum) {
		this.phoneNum = newPhoneNum;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	public long getSSN() {
		return this.SSN;
	}
}
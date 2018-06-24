class Customer
{
	private final String custNum;
	private String firstName;
	private String lastName;
	private String address;
	private int kilos;

	public Customer(String cn, String fn, String ln, String ad, int kg) {
		custNum = cn;
		firstName = fn;
		lastName = ln;
		address = ad;
		kilos = kg;
	}

	public String getCustNum() {
		return(custNum);
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getFirstName() {
		return(firstName);
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public String getLastName() {
		return(lastName);
	}

	public void setAddress(String ad) {
		address = ad;
	}

	public String getAddress() {
		return(address);
	}

	public void setKilos(int kg) {
		kilos = kg;
	}

	public int getKilos() {
		return(kilos); 
	}

	public String toString() {
		return("<custnum>" + custNum + "</custnum>" + "<firstname>" + firstName + "</firstname>" + "<lastname>" + lastName + "</lastname>" + "<address>" + address + "</address>" + "<kilos>" + kilos + "</kilos>");
	}

	public String getDetails() {
		return( custNum + "@" + firstName + "@" + lastName + "@" + address + "@" + kilos);
	}
}

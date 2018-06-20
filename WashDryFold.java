public class WashDryFold extends Service implements ServiceWithLocation, ServiceWithCustomer, SpecialToString
{
	private int custNum;
	private String branch;

	public WashDryFold (int cn, String b, String d, int c, String sd) {
		custNum = cn;
		branch = b;
		setDate(d);
		setCost(c);
		servDetails(sd);
	}

	public void setCustNum(int cn) {
		custNum = cn;
	}

	public int getCustNum() {
		return(custNum);
	}

	public void setBranch(String b) {
		bracnch = b;
	}

	public String getBranch() {
		return(branch);
	}

	public String toString() {
		return(toString() + ", Branch: " + branch + custNum);
	}

	@Override
	public String getDetails() {
		return(super.getDetails() + "@" + branch + "@" + custNum + "@WashDryFold");
	}
}

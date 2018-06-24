public class DryFold extends Service implements SpecialToString
{
	private String custNum;
	private String branch;

	public DryFold (String sd, int c, String d) {
		setServDetails(sd);
		setCost(c);
		setDate(d);
		custNum = "";
		branch = "";
	}

	public DryFold (String cn, String b, String d, int c, String sd) {
		custNum = cn;
		branch = b;
		setDate(d);
		setCost(c);
		setServDetails(sd);
	}

	public void setCustNum(String cn) {
		custNum = cn;
	}

	public String getCustNum() {
		return(custNum);
	}

	public void setBranch(String b) {
		branch = b;
	}

	public String getBranch() {
		return(branch);
	}

	public String toString(ServiceManagerDatabase smd) {
		String customerDetails = "";
		Customer customer = smd.getCustomerById(custNum);
		if(customer != null) {
			customerDetails = "\nCustomer Num: " + customer.toString();
		}
		return(toString() + ", Branch: " + branch + customerDetails);
	}

	@Override
	public String getDetails() {
		return(super.getDetails() + "@" + branch + "@" + custNum + "@DryFold");
	}
}

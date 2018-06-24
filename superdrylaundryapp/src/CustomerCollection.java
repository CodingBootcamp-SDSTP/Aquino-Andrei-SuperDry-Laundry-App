import java.util.ArrayList;

class CustomerCollection
{
	ArrayList<Customer> customers;

	public CustomerCollection() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void removeCustomer(Customer customer) {
		customers.remove(customer);
	}

	public ArrayList<Customer> getAllCustomers() {
		return(customers);
	}

	public Customer getCustomerByIndex(int n) {
		return(customers.get(n));
	}

	public int getCustomerCount() {
		return(customers.size());
	}

	public Customer getCustomerById(String id) {
		Customer customer = null;
		for(int i=0 ; i<getCustomerCount(); i++ ) {
			if(getCustomerByIndex(i).getCustNum().equalsIgnoreCase(id)) {
				customer = getCustomerByIndex(i);
			}
		}
		return(customer);
	}

	public ArrayList<Customer> search (String s) {
		Customer c = null;
		ArrayList<Customer> cl = new ArrayList<Customer>();
		String str = s.toLowerCase();
		for( int i = 0; i <getCustomerCount() ; i++) {
			c = getCustomerByIndex(i);
			if(matches(c, str)) {
				cl.add(c);
			}
		}
		return(cl);
	}

	public boolean matches(Customer c, String str) {
		String cnum = c.getCustNum();
		String firstName = c.getFirstName().toLowerCase();
		String lastName = c.getLastName().toLowerCase();
		String address = c.getAddress().toLowerCase();
		int wt = c.getKilos();
		String w = Integer.toString(wt);
		if(cnum.contains(str) || firstName.contains(str) || lastName.contains(str) || address.contains(str) || w.contains(str)) {
			return(true);
		}
		return(false);
	}
}

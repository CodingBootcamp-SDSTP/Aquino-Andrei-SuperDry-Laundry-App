import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.sql.*;

public class ServiceManagerDatabase
{
	private ServiceCollection services;
	private CustomerCollection customers;
	private LocationCollection locations;
	Connection conn;

	public ServiceManagerDatabase() {
		services = new ServiceCollection();
		customers = new CustomerCollection();
		locations = new LocationCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/superdrylaundrydb?user=andrei&password=bloom&serverTimezone=UTC&useSSL=false");
			readFromDB();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addService(Service service) {
		if(insertToDB(service)) {
			services.addService(service);
		}
	}

	boolean insertToDB(Service service) {
		PreparedStatement stmt = null;
		try {
			if(service instanceof WashDryFold) {
				WashDryFold washdryfold = (WashDryFold)service;
				stmt = conn.prepareStatement("INSERT INTO services ( custNum, branch, date, cost, service ) VALUES ( ?, ?, ?, ?, ? );");
				stmt.setString(1, washdryfold.getCustNum());
				stmt.setString(2, washdryfold.getBranch());
				stmt.setString(3, washdryfold.getDate());
				stmt.setInt(4, washdryfold.getCost());
				stmt.setString(5, "WashDryFold");
				stmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public ServiceCollection getServiceCollection() {
		return(services);
	}

	public CustomerCollection getCustomerCollection() {
		return(customers);
	}

	public LocationCollection getLocationCollection() {
		return(locations);
	}

	public Customer getCustomerById(String id) {
		return(customers.getCustomerById(id));
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> ao = new ArrayList<Object>();
		ArrayList<Customer> cs = customers.search(s);
		ArrayList<Service> ss = services.search(s);
		ArrayList<Location> ls = locations.search(s);
		ao.addAll(cs);
		ao.addAll(ss);
		ao.addAll(ls);
		return(ao);
	}

	public boolean readFromDB() {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM customers;");
			while(rs.next()) {
				System.out.println(rs.getString("custNum"));
				String[] str = {
					rs.getString("custNum"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("address"),
					rs.getString("kilos"),
					"customers"
				};
				createObject(str);
			}

			rs = stmt.executeQuery("SELECT * FROM locations;");
			while(rs.next()) {
				String[] str = {
					rs.getString("zip"),
					rs.getString("street"),
					rs.getString("brgy"),
					rs.getString("city"),
					rs.getString("units"),
					"locations"
				};
				createObject(str);
			}

			rs = stmt.executeQuery("SELECT * FROM services;");
			while(rs.next()) {
				String[] str = {
					rs.getString("custNum"),
					rs.getString("branch"),
					rs.getString("date"),
					rs.getString("cost"),
					rs.getString("servDetails"),
				};
				createObject(str);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt != null) {stmt = null;}} catch(Exception e) {};
			try { if(rs != null) {rs=null;}} catch(Exception e) {};
		}
		return(true);
	}

	public boolean readFromFile(String filename) {
		boolean f = false;
		try {
			FileReader file = new FileReader(filename);
			BufferedReader fbr = new BufferedReader(file);
			String fileLine;
			while((fileLine = fbr.readLine()) != null) {
				createObject(fileLine);
			}
			f = true;
			fbr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(f);
	}

	public void createObject(String... details) {
		int len = details.length - 1;
		String d = details[len];
		if("customer".equals(d)) {
			Customer c = new Customer(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]));
			customers.addCustomer(c);
		}
		else if("location".equals(d)) {
			Location l = new Location(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]));
			locations.addLocation(l);
		}
		else if("washdryfold".equals(d)) {
			WashDryFold wdf = new WashDryFold(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4]);
			services.addService(wdf);
		}
		else if("washdry".equals(d)) {
			WashDry wd = new WashDry(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4]);
			services.addService(wd);
		}
		else if("dryfold".equals(d)) {
			DryFold df = new DryFold(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4]);
			services.addService(df);
		}
	}

	public boolean writeToFile(String filename) {
		boolean f = false;
		try {
			FileWriter fwriter = new FileWriter(filename);
			BufferedWriter fbw = new BufferedWriter(fwriter);
			fbw.write(getCollectionContent());
			fbw.close();
			f = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(f);
	}

	public String getCollectionContent() {
		ArrayList<Customer> c = customers.getAllCustomers();
		ArrayList<Location> l = locations.getAllLocations();
		ArrayList<Service> s = services.getAllServices();
		StringBuffer sb = new StringBuffer("");
			for(int i=0; i < c.size() ; i++) {
				Customer customer = c.get(i);
				sb.append(customer.getDetails() + "\n");
			}
			for(int i=0; i < l.size() ; i++) {
				Location location = l.get(i);
				sb.append(location.getDetails() + "\n");
			}
			for(int i=0; i > s.size() ; i++) {
				Service service = s.get(i);
				sb.append(service.getDetails());
				if( i < s.size()-1) {
					sb.append("\n");
				}
			}
		return(sb.toString());
	}
}

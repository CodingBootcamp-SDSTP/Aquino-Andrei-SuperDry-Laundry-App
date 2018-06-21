import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class AllCustomersServlet extends HttpServlet
{
	CustomerCollection customers;

	public void init() throws ServletException {
		ServiceManagerDatabase smd = new ServiceManagerDatabase();
		customers = smd.getCustomerCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
		System.out.println("output: " + exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<customers>");
		ArrayList<Customer> customer = customers.getAllCustomers();
		for(Customer c : customer) {
			sb.append("<customer><customernumber>");
			sb.append(c.getCustNum());
			sb.append("</customernumber><firstname>");
			sb.append(c.getFirstName());
			sb.append("</firstname><lastname>");
			sb.append(c.getLastName());
			sb.append("</lastname><address>");
			sb.append(c.getAddress());
			sb.append("</address><laundryweight>");
			sb.append(c.getKilos());
			sb.append("</laundryweight></customer>");
		}
		sb.append("</customers>");
		return(sb.toString());
	}

	public void destroy() {
		customers = null;
	}
}

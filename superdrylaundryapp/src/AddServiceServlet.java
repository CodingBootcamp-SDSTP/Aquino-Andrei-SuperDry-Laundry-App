import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class AddServiceServlet extends HttpServlet
{
	ServiceManagerDatabase smd;

	public void init() throws ServletException {
		smd = new ServiceManagerDatabase();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST request from nodejs na may tamang value");
		InputStreamReader isr = new InputStreamReader(req.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		String[] details = line.split("&");
		String[] custnum = details[0].split("=");
		String[] date = details[1].split("=");
		String[] branch = details[2].split("=");
		String[] cost = details[3].split("=");
		String[] servicedetails = details[4].split("=");
		if("washdryfold".equals(type[1])) {
			WashDryFold washdryfold = new WashDryFold(custnum[1], date[1], branch[1], Integer.parseInt(cost[1]), servicedetails[1]);
			smd.addService(washdryfold);
		}
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		out.close();
	}

	public void destroy() {
		smd = null;
	}
}

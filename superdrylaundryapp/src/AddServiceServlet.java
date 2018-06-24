import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class AddServiceServlet extends HttpServlet
{
	ServiceCollection serv;
	ServiceManagerDatabase smd;

	public void init() throws ServletException {
		smd = new ServiceManagerDatabase();
		serv = smd.getServiceCollection();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST request from nodejs na may tamang value");
		InputStreamReader isr = new InputStreamReader(req.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		String[] details = line.split("&");
		String[] custNum = details[0].split("=");
		String[] date = details[1].split("=");
		String[] branch = details[2].split("=");
		String[] cost = details[3].split("=");
		String[] servDetails = details[4].split("=");
		if("washdryfold".equals(servDetails[1])) {
			WashDryFold washdryfold = new WashDryFold(custNum[1], date[1], branch[1], Integer.parseInt(cost[1]), servDetails[1]);
			smd.addService(washdryfold);
		}
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		out.close();
	}

	public void destroy() {
		serv =  null;
		smd = null;
	}
}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class AllLocationsServlet extends HttpServlet
{
	LocationCollection locations;

	public void init() throws ServletException {
		ServiceManagerDatabase smd = new ServiceManagerDatabase();
		locations = smd.getLocationCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
		System.out.println("output: " + exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<locations>");
		ArrayList<Location> location = locations.getAllLocations();
		for(Location l : location) {
			sb.append("<location><zip>");
			sb.append(l.getZip());
			sb.append("</zip><street>");
			sb.append(l.getStreet());
			sb.append("</street><barangay>");
			sb.append(l.getBrgy());
			sb.append("</barangay><city>");
			sb.append(l.city());
			sb.append("</city><units>");
			sb.append(l.getUnits());
			sb.append("</units></location>");
		}
		sb.append("</locations>");
		return(sb.toString());
	}

	public void destroy() {
		locations = null;
	}
}

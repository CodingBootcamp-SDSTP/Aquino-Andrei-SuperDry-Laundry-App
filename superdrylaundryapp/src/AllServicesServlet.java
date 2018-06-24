import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class AllServicesServlet extends HttpServlet
{
	ServiceCollection services;

	public void init() throws ServletException {
		ServiceManagerDatabase smd = new ServiceManagerDatabase();
		services = smd.getServiceCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<services>");
		ArrayList<Service> service = services.getAllServices();
		for(Service s : service) {
			if(s instanceof WashDryFold) {
				WashDryFold wdf = (WashDryFold)s;
				sb.append("<washdryfold><customernumber>");
				sb.append(wdf.getCustNum() + "</customernumber><date>");
				sb.append(wdf.getDate() + "</date><branch>");
				sb.append(wdf.getBranch() + "</branch><cost>");
				sb.append(wdf.getCost() + "</cost><servicedetails>");
				sb.append(wdf.getServDetails() + "</servicedetails></washdryfold>");
			}
			else if(s instanceof WashDry) {
				WashDry wd = (WashDry)s;
				sb.append("<washdry><customernumber>");
				sb.append(wd.getCustNum() + "</customernumber><date>");
				sb.append(wd.getDate() + "</date><branch>");
				sb.append(wd.getBranch() + "</branch><cost>");
				sb.append(wd.getCost() + "</cost><servicedetails>");
				sb.append(wd.getServDetails() + "</servicedetails></washdry>");
			}
			else if(s instanceof DryFold) {
				DryFold df = (DryFold)s;
				sb.append("<dryfold><customernumber>");
				sb.append(df.getCustNum() + "</customernumber><date>");
				sb.append(df.getDate() + "</date><branch>");
				sb.append(df.getBranch() + "</branch><cost>");
				sb.append(df.getCost() + "</cost><servicedetails>");
				sb.append(df.getServDetails() + "</servicedetails></dryfold>");
			}
		}
		sb.append("</services>");
		return(sb.toString());
	}

	public void destroy() {
		services = null;
	}
}

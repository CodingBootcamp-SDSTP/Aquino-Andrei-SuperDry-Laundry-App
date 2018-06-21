import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class SearchServlet extends HttpServlet
{
	ServiceCollection services;
	ServiceManagerDatabase smd;

	public void init() throws ServletException {
		smd = new ServiceManagerDatabase();
		services = smd.getServiceCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		String str = req.getQueryString();
		String[] stra = str.split("=");
		out.print(search(stra));
	}

	public String search(String[] s) {
		StringBuilder sb = new StringBuilder("<services>\n");
		ArrayList<Service> service = services.getAllServices();
		String text = s[0];
		if("text".contains(text)) {
			String value = s[1];
			ArrayList<Object> o = smd.search(value);
			for(int i=0; i < o.size() ; i++) {
				sb.append("<service>");
				sb.append(o.get(o));
				sb.append("</service>");
			}
		}
		sb.append("</services>");
		return(sb.toString());
	}
	public void destroy() {
		services = null;
	}
}

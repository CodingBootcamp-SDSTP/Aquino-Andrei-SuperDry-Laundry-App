public class Service
{
	private String date;
	private int cost;
	private String servDetails;
	
	public void setDate(String d) {
		date = d;
	}

	public String getDate() {
		return(date);
	}

	public void setCost(int c) {
		cost = c;
	}

	public int getCost() {
		return(cost);
	}

	public void setServDetails(String dt) {
		servDetails = dt;
	}

	public String getServDetails() {
		return(servDetails);
	}

	public String toString() {
		return("<date>" + date + "</date>" + "<cost>" + cost + "</cost>" + "<details>" + servDetails + "</details>");
	}

	public String getDetails() {
		return(date + "@" + cost + "@" + servDetails);
	}
}

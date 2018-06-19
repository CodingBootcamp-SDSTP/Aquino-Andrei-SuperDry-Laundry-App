public class Location
{
	private final String zip;
	private String street;
	private String brgy;
	private String city;
	private int units;

	public Location(String zz, String s, String b, String c, int u) {
		zip = zz;
		street = s;
		brgy = b;
		city = c;
		units = u;
	}

	public String getZip() {
		return(zip);
	}

	public String getStreet() {
		return(street);
	}

	public void setStreet(String s) {
		street = s;
	}

	public String getBrgy() {
		return(brgy);
	}

	public void setBrgy(String b) {
		brgy = b;
	}

	public String getCity() {
		return(city);
	}

	public void setCity(String c) {
		city = c;
	}

	public int getUnits() {
		return(units);
	}

	public void setUnits(int u) {
		units = u;
	}

	public String toString() {
		return("<zip>" + zip + "</zip>" + "<street>" + street + "</street>" + "<brgy>" + brgy + "</brgy>" + "<city>" + city + "</city>" + "<units>" + units + "</units>");
	}

	public String getDetails() {
		return(zip + "@" + street + "@" + brgy + "@" + city + "@" + units);
	}
}

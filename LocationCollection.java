import java.util.ArrayList;

public class LocationCollection
{
	ArrayList<Location> locations;

	public LocationCollection() {
		locations = new ArrayList<Location>();
	}

	public void addLocation(Location location) {
		locations.add(location);
	}

	public void removeLocation(Location location) {
		locations.add(location);
	}

	public ArrayList<Location> getAllLocations() {
		return(locations);
	}

	public Location getLocationByIndex(int n) {
		return(locations.get(n));
	}

	public int getLocationCount() {
		return(locations.size());
	}

	public ArrayList<Location> search(String s) {
		Location l = null;
		ArrayList<Location> al = new ArrayList<Location>();
		String str = s.toLowerCase();
		for(int i = 0; i<getLocationCount() ; i++ ) {
			if(matches(l, str)) {
				ad.add(l);
			}
		}
		return(al);
	}

	public boolean matches(Location l, String str) {
		String zip = l.getZip().toLowerCase();
		String street = l.getStreet().toLowerCase();
		String brgy = l.getBrgy().toLowerCase();
		String city = l.getCity().toLowerCase();
		String units = l.getUnits().toString();
		if(zip.contains(str) || street.contains(str) || brgy.contains(str) || city.contains(str) || units.contains(str)) {
			return(true);
		}
		return(false);
	}
}

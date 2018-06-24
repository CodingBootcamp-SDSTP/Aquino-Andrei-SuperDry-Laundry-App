import java.util.ArrayList;

public class ServiceCollection
{
	private ArrayList<Service> services;

	public ServiceCollection() {
		services = new ArrayList<Service>();
	}

	public void addService(Service service) {
		services.add(service);
	}

	public void removeService(Service service) {
		services.remove(service);
	}

	public ArrayList<Service> getAllServices() {
		return(services);
	}

	public Service getServiceByIndex(int n) {
		return(services.get(n));
	}

	public int getServiceCount() {
		return(services.size());
	}

	public ArrayList<Service> search(String s) {
		Service sv = null;
		ArrayList<Service> sl = new ArrayList<Service>();
		String str = s.toLowerCase();
		for(int i=0 ; i<getServiceCount() ; i++) {
			sv = getServiceByIndex(i);
			if(matches(sv, str)) {
				sl.add(sv);
			}
		}
		return(sl);
	}

	public boolean matches(Service s, String str) {
		String servDetails = s.getServDetails().toLowerCase();
		//int cost = Integer.toString(cost);
		int cost = s.getCost();
		String ab = Integer.toString(cost);
		String date = s.getDate().toLowerCase();
		if(servDetails.contains(str) || ab.contains(str) || date.contains(str)) {
			return(true);
		}
		return(false);
	}
}

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
			sv = getAssetByIndex(i);
			if(matches(sv, str)) {
				sl.add(sv);
			}
		}
		return(sl);
	}

	public boolean matches(Service s, String str) {
		String service = s.getServDetails().toLowerCase();
		int presyo = Integer.toString(cost);
		int petsa = Integer.toString(date);
		if(service.contains(str) || presyo.contains(str) || petsa.contains(str)) {
			return(true);
		}
		return(false);
	}
}

package router;

public class Packet {
	private String data;
	private IPAddress source;
	private IPAddress destination;
	private int limit;

	public static int INIT_TTL = 50;

	public Packet(String data, int limit, IPAddress source, IPAddress destination) {
		this.data = data;
		this.limit = limit;
		this.source = source;
		this.destination = destination;
	}

	public Packet(String data, IPAddress source, IPAddress destination) {
		this.data = data;
		this.source = source;
		this.destination = destination;
		this.limit = INIT_TTL;
	}

	public IPAddress getDestination() {
		return destination;
	}

	public IPAddress getSource() {
		return source;
	}

	public String getData() {
		return data;
	}

	public void decreaseTTL() {
		limit--;
	}

	public boolean isLive() {
		if (limit > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return source + " -> " + destination + " , " + data;
	}
}
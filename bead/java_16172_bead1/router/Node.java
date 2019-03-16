package router;

public class Node {
	private IPAddress ownIP;
	private IPAddress minIP;
	private IPAddress maxIP;
	private Node[] neighbors = new Node[4];
	private Buffer buffer = new Buffer(10);

	public Node(IPAddress ownIP, IPAddress minIP, IPAddress maxIP) {
		this.ownIP = ownIP;
		this.minIP = minIP;
		this.maxIP = maxIP;
	}

	public static void connect(Node node1, int node2index, Node node2, int node1index) {
		if (node1index < 4 && node2index < 4 && node1index >= 0 && node2index >= 0) {
			node1.neighbors[node2index] = node2;
			node2.neighbors[node1index] = node1;
		}
	}

	public String getPackets() {
		String packets = "";
		while (!buffer.isEmpty()) {
			packets += (buffer.removeFirst().toString() + "\n");
		}
		return packets;
	}

	public void route(Packet packet) {
		if (packet.getDestination().isTheSame(this.ownIP)) {
			buffer.append(packet);
		} else {
			if (packet.isLive()) {
				int i = 0;
				while (i < neighbors.length) {
					if (neighbors[i] != null && packet.getDestination().insideRng(neighbors[i].minIP,neighbors[i].maxIP)) {
							packet.decreaseTTL();
							neighbors[i].route(packet);
							return;
						}
					i++;
				}
				route(new Packet("Destination is unreachable", ownIP, packet.getSource()));
			} else {
				route(new Packet("Time is exceeded", ownIP, packet.getSource()));
			}
		}
	}

	public String traceRoute(IPAddress destination) {
		int i = 1;
		String result = ownIP + " , ";
		while (true) {
			route(new Packet("traceroute", i, ownIP, destination));
			Packet temp = buffer.removeFirst();
			if (temp != null) {
				result = result + temp.getSource().toString() + " , ";
				i++;
			} else {
				break;
			}
		}
		return result + destination;
	}
}
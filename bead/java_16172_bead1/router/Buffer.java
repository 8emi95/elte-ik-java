package router;

public class Buffer {
	private Packet[] packets;
	private int indexOfFirst;
	private int capacity;
	private int counter;

	public Buffer(int capacity) {
		this.capacity = capacity;
		packets = new Packet[capacity];
	}

	public boolean isEmpty() {
		for (int i = 0; i < packets.length; ++i) {
			if (packets[i] != null) {
				return false;
			}
		}
		indexOfFirst = 0;
		counter = 0;
		return true;
	}

	public boolean isFull() {
		for (int i = 0; i < packets.length; ++i) {
			if (packets[i] == null) {
				return false;
			}
		}
		return true;
	}

	public void append(Packet packet) {
		if (!isFull()) {
			packets[counter] = packet;
			counter++;
			if (counter == capacity){
				counter = 0;
			}
		}
	}

	public Packet removeFirst() {
		if (!isEmpty()) {
			Packet first = packets[indexOfFirst];
			packets[indexOfFirst] = null;
			indexOfFirst++;
			return first;
		} else {
			return null;
		}
	}
}
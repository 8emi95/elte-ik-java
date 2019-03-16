package flow;

import nodes.base.Receiver;
import nodes.base.Sender;

public class Wire {
	
	private Receiver end;
	private Bit value;
	
	public Wire() {
		end = null;
		value = Bit.ZERO;
	}
	
	public Receiver getEnd() {
		Receiver returnEnd = end;
		return returnEnd;
	}
	
	public Bit getValue() {
		Bit returnValue = value;
		return returnValue;
	}
	
	public void setValue(Bit bit) {
		if (bit != value && end != null) {
			end.update();
		}
		value = bit;
	}
	
	public static void connect(Sender start, int outputIndex, Receiver end, int inputIndex) {
		Wire wire = start.getOutput(outputIndex);
		end.setInput(inputIndex, wire);
		wire.end = end;
		end.update();
	}
	
	@Override
	public String toString() {
		if (end == null) {
			return "Wire to <> [" + value + "]";
		}
		return "Wire to " + end + " [" + value + "]";
	}
}
package nodes;

import nodes.base.*;
import flow.*;
import exceptions.*;

public class Led extends AbstractNode implements Receiver {
	
	private Wire input;
	private boolean on;
	
	public Led() {
		input = null;
		on = false;
	}
	
	@Override
	public String getType() {
		return "LED";
	}
	
	public boolean isOn() {
		boolean returnOn = on;
		return returnOn;
	}
	
	@Override
	public void setInput(int index, Wire wire) {
		if (index != 0) {
			throw new LogicException();
		} else {
			input = wire;
		}
	}
	
	@Override
	public void update() {
		if (input.getValue() == Bit.ONE) {
			on = true;
		} else {
			on = false;
		}
	}
}
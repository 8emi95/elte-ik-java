package nodes;

import flow.*;
import nodes.base.*;
import exceptions.*;

public class Source extends AbstractNode implements Sender {
	
	private Wire output;
	
	public Source() {
		output = new Wire();
	}

	
	@Override
	public String getType() {
		return "SOURCE";
	}
	
	public void switchOn() {
		output.setValue(Bit.ONE);
	}
	
	public void switchOff() {
		output.setValue(Bit.ZERO);
	}
	
	@Override
	public Wire getOutput(int param) {
		if (param != 0) {
			throw new LogicException();
		}
		
		return output;
	}
}
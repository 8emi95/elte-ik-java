package nodes;

import flow.Bit;
import nodes.base.*;

public class Not extends AbstractGate {
	
	public Not() {
		super(1, 1);
	}
	
	@Override
	public String getType() {
		return "NOT";
	}
	
	@Override
	protected Bit calculateResult(Bit[] bits) {
		return bits[0].invert();
	}
}
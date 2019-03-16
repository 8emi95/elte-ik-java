package nodes;

import flow.Bit;
import nodes.base.*;

public class Junction extends AbstractGate {
	
	public Junction(int param) {
		super(1, param);
	}
	
	public Junction() {
		super(1, 2);
	}
	
	@Override
	public String getType() {
		return "JUNCTION";
	}
	
	@Override
	protected Bit calculateResult(Bit[] bits) {
		return bits[0];
	}
}
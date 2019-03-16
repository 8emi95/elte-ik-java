package nodes;

import nodes.base.*;
import flow.Bit;

public class And extends AbstractGate {
	
	public And(int param) {
		super(param, 1);
	}
	
	public And() {
		super(2, 1);
	}
	
	@Override
	public String getType() {
		return "AND";
	}
	
	@Override
	protected Bit calculateResult(Bit[] bits) {
		int numberOfOnes = 0;
		
		for (int i = 0; i < bits.length; ++i) {
			if (bits[i] == Bit.ONE) {
				numberOfOnes += 1;
			}
		}
		
		if (numberOfOnes == bits.length) {
			return Bit.ONE;
		}
		return Bit.ZERO;
	}
}
package nodes.base;

import flow.Wire;
import flow.Bit;
import exceptions.LogicException;
import java.util.List;
import java.util.ArrayList;

public abstract class AbstractGate extends AbstractNode implements Gate{
	
	private List<Wire> inputs;
	private List<Wire> outputs;
	
	public AbstractGate(int inputCount, int outputCount) {	
		if (inputCount <= 0 || outputCount <= 0) {
			throw new LogicException();
		} else {
			inputs = new ArrayList<>(inputCount);
			outputs = new ArrayList<>(outputCount);
			
			for (int i = 0; i < inputCount; ++i) {
				inputs.add(null);
			}
		
			for (int i = 0; i < outputCount; ++i) {
				outputs.add(new Wire());
			}
		}
	}
	
	@Override
	public void setInput(int index, Wire wire) {
		if (index >= inputs.size() || index < 0) {
			throw new LogicException();
		} else {
			inputs.set(index, wire);	
		}
	}
	
	@Override
	public Wire getOutput(int index) {
		if (index >= outputs.size() || index < 0) {
			throw new LogicException();
		} return outputs.get(index);
	}
	
	@Override
	public boolean isOperable() {
		for (int i = 0; i < inputs.size(); ++i) {
			if (inputs.get(i) == null) {
				return false;
			}
		}
		
		return true;
	}
	
	protected abstract Bit calculateResult(Bit[] bits);
	
	@Override
	public void update() {
		if (this.isOperable() != false) {
			Bit[] bits = new Bit[inputs.size()];
			
			int i = 0;
			for (Wire wire: inputs) {
				Bit bit = wire.getValue();
				bits[i] = bit;
				i += 1;
			}
			
			Bit bit = calculateResult(bits);
			
			for (Wire wire: outputs) {
				wire.setValue(bit);
			}
		}
		
	}
}
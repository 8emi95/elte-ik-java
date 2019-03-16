package flow;

public enum Bit{
	ZERO, ONE;
	
	public Bit invert() {
		if (this == Bit.ZERO) {
			return Bit.ONE;
		} else {
			return Bit.ZERO;
		}
	}
}
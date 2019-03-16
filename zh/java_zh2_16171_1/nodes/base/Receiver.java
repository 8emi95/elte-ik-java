package nodes.base;

import flow.Wire;

public interface Receiver extends Node{
	
	public void setInput(int param1, Wire param2);
	public void update();
}
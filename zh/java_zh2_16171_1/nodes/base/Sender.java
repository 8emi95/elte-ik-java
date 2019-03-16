package nodes.base;

import flow.Wire;

public interface Sender extends Node{
	
	public Wire getOutput(int param);
}
import uno.Game;

public class TestGame extends Game {

	private String[] inputs;
	int inputLine = 0;
	
	public TestGame(String[] playerNames, String[] inputs) {
		super(playerNames);
		this.inputs = inputs;
	}

	@Override
	protected String readLine() {
		return inputs[inputLine++];
	}
	
}


import java.util.ArrayList;

import game.items.Gem;
import game.players.Player;
import game.utils.Position;

public class DummyPlayer extends Player {
	
	public DummyPlayer(){super(new ArrayList<Gem>(), new Position(1,1));}
	
	@Override
	public String display(){return "My achievements...";}
	
}
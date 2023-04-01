package backpackhero.donjon;

import backpackhero.Coordinates;

public interface DungeonRoom {
	Coordinates coordinate();
	
	int id();
	
	String tab();
	
}

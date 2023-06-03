package backpackhero.donjon;

import backpackhero.Coordinates;

public interface DungeonRoom {
	Coordinates coordinates();
	
	int id();
	
	String tab();
}

package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class HealerRoom implements DungeonRoom {
	private final Coordinates coordinates;
	private final int id;
	
	public HealerRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 3;
	}
	
	@Override
	public Coordinates coordinates() {
		return coordinates;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	@Override
	public String tab() {
		return "G";
	}
	
	@Override
	public String toString() {
		return "un guérisseur ";
	}
}

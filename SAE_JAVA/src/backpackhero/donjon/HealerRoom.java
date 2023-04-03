package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class HealerRoom implements DungeonRoom {
	private final Coordinates coordinate;
	private final int id;
	
	public HealerRoom(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = 3;
	}
	
	public Coordinates coordinate() {
		return coordinate;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	public String tab() {
		return "G";
	}
	
	@Override
	public String toString() {
		return "un guérisseur ";
	}
}

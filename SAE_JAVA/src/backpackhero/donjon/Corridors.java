package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class Corridors implements DungeonRoom {
	private final Coordinates coordinate;
	private final int id;
	
	public Corridors(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = 1;
	}
	
	@Override
	public int id() {
		return id;
	}

	@Override
	public Coordinates coordinate() {
		return coordinate;
	}
	
	public String tab() {
		return "=";
	}
}

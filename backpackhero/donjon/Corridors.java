package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class Corridors implements DungeonRoom {
	private final Coordinates coordinates;
	private final int id;
	
	public Corridors(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 0;
	}
	
	@Override
	public int id() {
		return id;
	}

	@Override
	public Coordinates coordinates() {
		return coordinates;
	}
	
	@Override
	public String tab() {
		return "=";
	}
}

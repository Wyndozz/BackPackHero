package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class TreasureRoom implements DungeonRoom{
	private final Coordinates coordinates;
	private final int id;
	
	public TreasureRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 5;
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
		return "T";
	}
	
	@Override
	public String toString() {
		return "un trésor ";
	}
}

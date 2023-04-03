package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class TreasureRoom implements DungeonRoom{
	private final Coordinates coordinate;
	private final int id;
	
	public TreasureRoom(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = 5;
	}

	@Override
	public Coordinates coordinate() {
		return coordinate;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	public String tab() {
		return "T";
	}
	
	@Override
	public String toString() {
		return "un trésor ";
	}
}

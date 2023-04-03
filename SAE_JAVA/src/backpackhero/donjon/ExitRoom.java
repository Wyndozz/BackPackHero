package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class ExitRoom implements DungeonRoom{
	private final Coordinates coordinate;
	private final int id;
	
	public ExitRoom(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = 2;
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
		return "S";
	}
	
	@Override
	public String toString() {
		return "une sortie ";
	}
}

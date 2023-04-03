package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class InaccessibleRoom implements DungeonRoom{
	private final Coordinates coordinate;
	private final int id;
	
	public InaccessibleRoom(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = -1;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	public String tab() {
		return ".";
	}

	@Override
	public Coordinates coordinate() {
		return coordinate;
	}

}

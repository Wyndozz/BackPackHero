package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class InaccessibleRoom implements DungeonRoom{
	private final Coordinates coordinates;
	private final int id;
	
	public InaccessibleRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = -1;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	@Override
	public String tab() {
		return ".";
	}

	@Override
	public Coordinates coordinates() {
		return coordinates;
	}

}

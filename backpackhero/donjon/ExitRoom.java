package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class ExitRoom implements DungeonRoom{
	private final Coordinates coordinates;
	private final int id;
	
	public ExitRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 1;
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
		return "S";
	}
	
	@Override
	public String toString() {
		return "une sortie ";
	}
}

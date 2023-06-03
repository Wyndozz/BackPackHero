package backpackhero.donjon;

import backpackhero.Coordinates;

public class StartRoom implements DungeonRoom {
	private final Coordinates coordinates;
	private final int id;
	
	public StartRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 6;
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
		return "D";
	}
	
}

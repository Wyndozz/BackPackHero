package backpackhero.donjon;

import java.util.Objects;

public class MapCell {
	private final int id;
	private final DungeonRoom room;
	
	public MapCell(DungeonRoom room) {
		Objects.requireNonNull(room);
		id = room.id();
		this.room = room;
	}
	
	public DungeonRoom room() {
		return room;
	}
	
	@Override
	public String toString() {
		return "La pièce n°" + id + " qui contient " + room.toString();
	}
}

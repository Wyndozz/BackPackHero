package backpackhero.donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import backpackhero.Coordinates;

public class Floor {
	private final MapCell[][] floor;
	private final int level;
	private int id;
	
	public Floor(int level) {
		floor =	new MapCell[5][11];
		this.level = level;
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<11; j++) {
				floor[i][j] = new MapCell(new InaccessibleRoom(new Coordinates(i, j)));
			}
		}
	}
	
	public void add(DungeonRoom room) {
		Objects.requireNonNull(room);
		floor[room.coordinate().i()][room.coordinate().j()] = new MapCell(room);
	}
	
	public void addCorridors(List<Coordinates> corridors) {
		for (var coordinate : corridors) {
			floor[coordinate.i()][coordinate.j()] = new MapCell(new Corridors(new Coordinates(coordinate.i(), coordinate.j())));
		}
	}
	
	public String tab() {
		var string = new StringBuilder();
		for (int i = 0; i<5; i++) {
			if (i != 0) {
				string.append("\n");
			}
			for (int j = 0; j<11; j++) {
				if (j != 10) {
					string.append(floor[i][j].room().tab() + " ");
				}
				else {
					string.append(floor[i][j].room().tab());
				}
			}
		}
		return string + "\n";
	}
	
	@Override
	public String toString() {
		var string = new StringBuilder("L'étage n°" + level + " contient : \n");
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<11; j++) {
				if (floor[i][j].room().id() != -1 && floor[i][j].room().id() != 1) {
					string.append("- " + floor[i][j] + "ayant pour coordonnées : (" + i + ", " + j + ")\n");
				}
			}
		}
		return string + "";
	}
}

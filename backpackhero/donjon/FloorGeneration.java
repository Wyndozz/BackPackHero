package backpackhero.donjon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import backpackhero.Coordinates;

public class FloorGeneration {
	private final int id;
	private final MapCell[][] floor;
	private final int nbRooms;
	private final ArrayList<Coordinates> corridorsCoordinates;
	
	public FloorGeneration(int id, int nbRooms) {
		floor =	new MapCell[5][11];
		this.nbRooms = nbRooms;
		corridorsCoordinates = new ArrayList<>();
		floorInitialization();
		corridorsGeneration();
		addCorridors(corridorsCoordinates);
		roomsGeneration();
		this.id = id;
	}
	
	public void add(DungeonRoom room) {
		Objects.requireNonNull(room);
		floor[room.coordinates().i()][room.coordinates().j()] = new MapCell(room);
	}
	
	public void addCorridors(List<Coordinates> corridors) {
		for (var coordinates : corridors) {
			this.add(new Corridors(coordinates));
		}
	}
	
	public void floorInitialization() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 11; j++) {
				floor[i][j] = new MapCell(new InaccessibleRoom(new Coordinates(i, j)));
			}
		}
	}
	
	public void corridorsGeneration() {
		Coordinates firstRoomCoordinates = new Coordinates(0, 0);
		int nbCorridors = 0;
		while (nbCorridors < nbRooms) {
			/* Placement du 1er couloir en extrémité du Donjon*/
			if (nbCorridors == 0) {
				int randomNumber = ThreadLocalRandom.current().nextInt(1, 3);
				/* placement sur l'extremité gauche ou droite du Donjon */
				if (randomNumber == 1) {
					int randomLine = ThreadLocalRandom.current().nextInt(0, 5);
					List<Integer> extremityColumn = Arrays.asList(0, 10);
					int randomColumn = this.randomInteger(extremityColumn);
					firstRoomCoordinates = new Coordinates(randomLine, randomColumn);
					corridorsCoordinates.add(firstRoomCoordinates);
					add(new StartRoom(firstRoomCoordinates));
				}
				/* placement sur l'extremité haut ou bas du Donjon */
				else {
					int randomColumn = ThreadLocalRandom.current().nextInt(0, 11);
					List<Integer> extremityLine = Arrays.asList(0, 4);
					int randomLine = this.randomInteger(extremityLine);
					firstRoomCoordinates = new Coordinates(randomLine, randomColumn);
					corridorsCoordinates.add(firstRoomCoordinates);
					add(new StartRoom(firstRoomCoordinates));
				}
			}
			/* Placement des autres couloirs en fonction du couloir précédemment placé */
			else {
				corridorsCoordinates.add(this.randomNextRoom());
			}
			nbCorridors ++;
		}
		corridorsCoordinates.remove(firstRoomCoordinates);
	}
	
	public int randomInteger(List<Integer> values) {
		int randomIndex = ThreadLocalRandom.current().nextInt(0, values.size());
		return values.get(randomIndex);
	}
	
	public Coordinates randomNextRoom() {
		int nextRoomIndex = corridorsCoordinates.size()-1;
		ArrayList<Coordinates> possibleCoordinates = this.possibleCoordinates(corridorsCoordinates.get(nextRoomIndex));
		while (possibleCoordinates.size() == 0) {
			nextRoomIndex --;
			possibleCoordinates = this.possibleCoordinates(corridorsCoordinates.get(nextRoomIndex));
		}
		int randomIndex = ThreadLocalRandom.current().nextInt(0, possibleCoordinates.size());
		return possibleCoordinates.get(randomIndex);
	}
	
	public ArrayList<Coordinates> possibleCoordinates(Coordinates room) {
		ArrayList<Coordinates> possibleCoordinates = new ArrayList<>();
		for (int i = -1; i < 2; i++) {
			if (i == 0) {
				for (int j = -1; j < 2; j+=2) {
					if (!(room.j() == 10 && j == 1) && !(room.j() == 0 && j == -1)) {
						Coordinates nextRoom = new Coordinates(room.i(), room.j()+j);
						if (!corridorsCoordinates.contains(nextRoom)) {
							possibleCoordinates.add(nextRoom);
						}
					}
				}
			}
			else {
				if (!(room.i() == 4 && i == 1) && !(room.i() == 0 && i == -1)) {
					Coordinates nextRoom = new Coordinates(room.i()+i, room.j());
					if (!corridorsCoordinates.contains(nextRoom)) {
						possibleCoordinates.add(nextRoom);
					}
				}
			}
		}
		return possibleCoordinates;
	}
	
	public void roomsGeneration() {
		for (int i = 1; i < 6; i++) {
			int roomNumber = roomNumbers(i);
			for (int j = 0; j < roomNumber; j++) {
				Coordinates randomCoordinates = randomCoordinates(corridorsCoordinates);
				corridorsCoordinates.remove(randomCoordinates);
				switch (i) {
					case 1 : add(new ExitRoom(randomCoordinates)); break;
					case 2 : add(new EnemyRoom(randomCoordinates)); break;
					case 3 : add(new HealerRoom(randomCoordinates)); break;
					case 4 : add(new MerchantRoom(randomCoordinates)); break;
					case 5 : add(new TreasureRoom(randomCoordinates)); break;
				}
			}
		}
	}
	
	public int roomNumbers(int roomId) {
		int min;
		int max;
		switch (roomId) {
			case 1 : min = 1; max = 1; break;
			case 2 : min = 1; max = 3; break;
			default: min = 1; max = 2;
		}
		int randomInt = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomInt;
	}
	
	public Coordinates randomCoordinates(List<Coordinates> values) {
		int randomIndex = ThreadLocalRandom.current().nextInt(0, values.size());
		return values.get(randomIndex);
	}
	
	public String tab() {
		var string = new StringBuilder();
		for (int i = 0; i < 5; i++) {
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
	
	public MapCell[][] floor() {
		return floor;
	}
	
	@Override
	public String toString() {
		var string = new StringBuilder("L'étage n°" + id + " contient : \n");
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

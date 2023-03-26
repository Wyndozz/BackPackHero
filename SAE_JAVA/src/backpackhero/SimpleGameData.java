package backpackhero;

import java.util.ArrayList;

import backpackhero.equipment.Equipment;
import backpackhero.inventory.InventoryCell;
import backpackhero.map.MapCell;

public class SimpleGameData {
	private final InventoryCell[][] inventory;
	private final MapCell[][] map;
	private final Coordinates currentRoom;
	private final ArrayList<Equipment> equipment;
	
	public SimpleGameData(int x, int y) {
		inventory = new InventoryCell[3][5];
		map = new MapCell[5][11];
		currentRoom = new Coordinates(x, y);
		equipment = new ArrayList<>();
	}
}

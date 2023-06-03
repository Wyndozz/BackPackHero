package backpackhero;

import java.awt.Color;
import java.util.ArrayList;

import backpackhero.equipment.Equipment;
import backpackhero.inventory.InventoryCell;
import backpackhero.donjon.FloorGeneration;
import backpackhero.donjon.InaccessibleRoom;
import backpackhero.donjon.MapCell;

public class SimpleGameData {
	private final InventoryCell[][] inventory;
	private MapCell[][] map;
	private final ArrayList<Equipment> equipment;
	
	public SimpleGameData(int i, int j, int nbRooms) {
		inventory = new InventoryCell[3][5];
		equipment = new ArrayList<>();
		map = new FloorGeneration(1, nbRooms).floor();
	}
	
	public Color colorCell(int i, int j) {
		int id = map[i][j].id();
		switch(id) {
			case 0 : return new Color(238, 211, 185);
			case 1 : return Color.GREEN;
			case 2 : return Color.RED;
			case 3 : return Color.YELLOW;
			case 4 : return Color.BLUE;
			case 5 : return Color.orange;
		 	case 6 : return Color.white;
			default : return Color.BLACK;
		}
	}
	
	public int lines() {
		return map.length;
	}
	
	public int columns() {
		return map[0].length;
	}
}

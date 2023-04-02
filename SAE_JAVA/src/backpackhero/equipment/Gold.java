package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Gold {
	private final ArrayList<Coordinates> coordinates;
	private final int rarity;
	private int quantity;
	
	public Gold() {
		coordinates = new ArrayList<>();
		coordinates.add(new Coordinates(0, 0));
		rarity = 1;
		quantity = 0;
	}
	
	public void addGold(int value) {
		quantity += value;
	}
	
	public boolean removeGold(int value) {
		if (quantity < value) {
			return false;
		}
		quantity -= value;
		return true;
	}
	
	public int getQuanity() {
		return quantity;
	}
}

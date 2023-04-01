package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Gold {
	private final ArrayList<Coordinates> list;
	private int quantity;
	
	public Gold() {
		list = new ArrayList<>();
		list.add(new Coordinates(0, 0));
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
}

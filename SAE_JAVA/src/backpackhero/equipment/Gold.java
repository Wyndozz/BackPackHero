package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Gold {
	private final ArrayList<Coordinates> list;
	private int quantity;
	
	public Gold() {
		list = new ArrayList<>();
		list.add(new Coordinates(0, 0));
		quantity = 1;
	}
}

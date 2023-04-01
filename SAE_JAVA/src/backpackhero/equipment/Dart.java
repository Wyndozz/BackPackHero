package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Dart implements Equipment{
	private final int damagePoint;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public Dart() {
		damagePoint = 10;
		rarity = 1;
		list = new ArrayList<>();
		list.add(new Coordinates(0, 0));
	}
}

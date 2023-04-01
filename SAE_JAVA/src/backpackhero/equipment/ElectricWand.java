package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class ElectricWand implements Equipment{
	private final int manaCost;
	private final int damagePoint;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public ElectricWand() {
		manaCost = 1;
		damagePoint = 7;
		rarity = 2;
		list = new ArrayList<>();
	}
}

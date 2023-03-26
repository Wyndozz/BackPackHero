package backpackhero.equipment.shield;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class RoughBuckler implements Shields{
	private final int blockPoint;
	private final int energyCost;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public RoughBuckler() {
		blockPoint = 7;
		energyCost = 1;
		rarity = 1;
		list = new ArrayList<>();
	}
}

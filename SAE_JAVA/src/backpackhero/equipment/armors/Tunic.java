package backpackhero.equipment.armors;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Tunic implements Armors{
	private final int blockPoint;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public Tunic() {
		blockPoint = 5;
		rarity = 1;
		list = new ArrayList<>();
		
	}
	
}

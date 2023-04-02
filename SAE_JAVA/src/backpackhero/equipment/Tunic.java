package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Tunic implements Equipment{
	private final int blockPoint;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	private final int id;
	
	public Tunic() {
		blockPoint = 5;
		rarity = 1;
		coordinates = new ArrayList<>();
		id = 21;
		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int classId() {
		return 2;
	}
	
}

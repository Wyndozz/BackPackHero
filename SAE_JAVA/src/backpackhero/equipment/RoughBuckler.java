package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class RoughBuckler implements Equipment, Shields{
	private final int blockPoint;
	private final int energyCost;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	private final int id;
	
	public RoughBuckler() {
		blockPoint = 7;
		energyCost = 1;
		rarity = 1;
		coordinates = new ArrayList<>();
		id = 20;
	}

	@Override
	public int classId() {
		return 0;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getBlock() {
		return blockPoint;
	}

	@Override
	public int getEnergy() {
		return energyCost;
	}
	
	@Override
	public String toString() {
		return "le bouclier rugueux";
	}

}

package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Tunic implements Armors, Equipment{
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
	
	@Override
	public int getShield() {
		return blockPoint;
	}
	
	@Override
	public boolean needsMana() {
		return false;
	}
	
	@Override
	public boolean needsEnergy() {
		return false;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public boolean isTargetable() {
		return false;
	}
	
	@Override
	public String toString() {
		return "la tunique";
	}

	@Override
	public int getEnergy() {
		return 0;
	}

	@Override
	public int getMana() {
		return 0;
	}
	
}

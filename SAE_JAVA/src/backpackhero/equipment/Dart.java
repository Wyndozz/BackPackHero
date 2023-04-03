package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class Dart implements Equipment, Weapon{
	private final int damagePoint;
	private final int energyCost;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	private final int id;
	
	public Dart() {
		damagePoint = 10;
		energyCost = 0;
		rarity = 1;
		coordinates = new ArrayList<>();
		coordinates.add(new Coordinates(0, 0));
		id = 2;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getDamage() {
		return damagePoint;
	}

	@Override
	public int getEnergy() {
		return energyCost;
	}
	
	@Override
	public int getMana() {
		return 0;
	}

	@Override
	public int classId() {
		return 1;
	}
	
	@Override
	public boolean needsMana() {
		return false;
	}
	
	@Override
	public boolean needsEnergy() {
		return true;
	}
	
	@Override
	public String toString() {
		return "la fléchette";
	}

	@Override
	public boolean isSelectable() {
		return true;
	}

	@Override
	public boolean isTargetable() {
		return false;
	}
	
}

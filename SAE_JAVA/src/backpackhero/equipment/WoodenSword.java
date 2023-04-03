package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class WoodenSword implements Weapon, Equipment {
	private final int damageDealt;
	private final int energyCost;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	private final int id;

	public WoodenSword() {
		damageDealt = 7;
		energyCost = 1;
		rarity = 1;
		coordinates = new ArrayList<>();
		id = 1;
	}

	@Override
	public int getDamage() {
		return damageDealt;
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
	public int getId() {
		return id;
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
	public boolean isSelectable() {
		return true;
	}

	@Override
	public boolean isTargetable() {
		return true;
	}
	
	@Override
	public String toString() {
		return "l'épée en bois";
	}
}

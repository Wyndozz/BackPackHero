package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class WoodenSword implements Weapon, Equipment {
	private final int damageDealt;
	private final int energyCost;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public WoodenSword() {
		damageDealt = 7;
		energyCost = 1;
		rarity = 1;
		list = new ArrayList<>();
	}

	@Override
	public int getDamage() {
		return damageDealt;
	}

	@Override
	public int getEnergy() {
		return energyCost;
	}
}

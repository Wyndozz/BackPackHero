package backpackhero.equipment.melee;

import java.util.ArrayList;

import backpackhero.Coordinates;
import backpackhero.equipment.Equipment;

public class WoodenSword implements MeleeWeapons, Equipment{
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
}

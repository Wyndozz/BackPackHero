package backpackhero.equipment;

import java.util.ArrayList;

import backpackhero.Coordinates;

public class ElectricWand implements Equipment, Weapon {
	private final int manaCost;
	private final int damagePoint;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	private final int id;
	
	public ElectricWand() {
		manaCost = 1;
		damagePoint = 7;
		rarity = 2;
		coordinates = new ArrayList<>();
		id = 3;
	}

	@Override
	public int getDamage() {
		return damagePoint;
	}

	@Override
	public int getEnergy() {
		return 0;
	}

	@Override
	public int getMana() {
		return manaCost;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int classId() {
		return 1;
	}
}

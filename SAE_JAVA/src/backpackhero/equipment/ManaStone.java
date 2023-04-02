package backpackhero.equipment;

import java.util.ArrayList;
import backpackhero.Coordinates;

public class ManaStone {
	private final int manaMax;
	private int mana;
	private final int rarity;
	private final ArrayList<Coordinates> coordinates;
	
	public ManaStone(int mana) {
		manaMax = mana;
		this.mana = manaMax;
		rarity = 1;
		coordinates = new ArrayList<>();
		coordinates.add(new Coordinates(0, 0));
	}
	
	public void removeMana(int mana) {
		this.mana -= mana;
	}
	
	public void refreshMana() {
		mana = manaMax;
	}
	
	public int getManaMax() {
		return manaMax;
	}
	
	public int getMana() {
		return mana;
	}
	
}

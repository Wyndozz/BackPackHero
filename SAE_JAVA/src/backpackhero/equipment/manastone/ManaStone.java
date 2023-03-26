package backpackhero.equipment.manastone;

import java.util.ArrayList;
import backpackhero.Coordinates;

public class ManaStone {
	private final int manaMax;
	private final int rarity;
	private final ArrayList<Coordinates> list;
	
	public ManaStone(int mana) {
		manaMax = mana;
		rarity = 1;
		list = new ArrayList<>();
		list.add(new Coordinates(0, 0));
	}
}

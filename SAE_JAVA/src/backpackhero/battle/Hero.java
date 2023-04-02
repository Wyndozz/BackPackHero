package backpackhero.battle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import backpackhero.equipment.Equipment;
import backpackhero.equipment.Gold;
import backpackhero.equipment.ManaStone;
import backpackhero.equipment.Shields;
import backpackhero.equipment.Weapon;

public class Hero {
	private int maxHealPoint;
	private int healPoint;
	private int attackPoint;
	private int shieldPoint;
	private int energy;
	private final ArrayList<ManaStone> mana;
	private Gold gold;
	private final ArrayList<Equipment> equipment;

	public Hero() {
		maxHealPoint = 40;
		healPoint = 40;
		attackPoint = 7;
		shieldPoint = 0;
		energy = 3;
		mana = new ArrayList<>();
		equipment = new ArrayList<>();
	}

	public int getAction() {
		var action = new Scanner(System.in);
		return action.nextInt();
	}

	public void dammageReceived(int dammage) {
		int remainingShield = shieldPoint - dammage;
		if (remainingShield < 0) {
			shieldPoint = 0;
			healPoint += remainingShield;
		} else {
			shieldPoint -= dammage;
		}
		if (healPoint < 0) {
			healPoint = 0;
		}
	}

	public boolean canAction(int e) {
		return energy >= e;
	}

	public boolean canAction(ManaStone manaStone, int m) {
		return manaStone.getMana() >= m;
	}

	public Equipment equipmentChoice(Equipment e) {
		Objects.requireNonNull(e);
		if (equipment.contains(e)) {
			return e;
		}
		return null;
	}
	public int attack(Weapon w) {
		Objects.requireNonNull(w);
		if (this.canAction(w.getEnergy())) {
			energy -= w.getEnergy();
			attackPoint = w.getDamage();
			return attackPoint;
		}
		return 0;
	}

	public int attack(Weapon w, ManaStone manaStone) {
		Objects.requireNonNull(w);
		if (this.canAction(manaStone, w.getMana())) {
			manaStone.removeMana(w.getMana());
			attackPoint = w.getDamage();
			return attackPoint;
		}
		return 0;
	}

	public int attackChoice() {
		var choice = new Scanner(System.in);
		return choice.nextInt();
	}

	public void shield(Shields shield) {
		Objects.requireNonNull(shield);
		if (this.canAction(shield.getEnergy())) {
			shieldPoint += shield.getBlock();
			energy -= shield.getEnergy();
		}
	}
	
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public int energy() {
		return energy;
	}

	public void endTurn() {
		shieldPoint = 0;
		energy = 3;
	}

	public boolean alive() {
		return healPoint > 0;
	}
	
	public void newGold() {
		gold = new Gold();
	}
	
	public void addManaStone(int mana) {
		this.mana.add(new ManaStone(mana));
	}

	public boolean addHealPoint() {
		if (gold.removeGold(5) && healPoint != maxHealPoint) {
			int diff = maxHealPoint - healPoint;
			if (diff < 25) {
				healPoint += diff;
			} else {
				healPoint += 25;
			}
			return true;
		}
		return false;
	}

	public boolean addMaxHealPoint() {
		if (gold.removeGold(8)) {
			maxHealPoint += 5;
			return true;
		}
		return false;
	}

	public void addEquipment(Equipment e) {
		Objects.requireNonNull(e);
		equipment.add(e);
	}

	public boolean removeEquipment(Equipment e) {
		Objects.requireNonNull(e);
		return equipment.remove(e);
	}

	public void getShield() {
		System.out.println("Vous avez " + shieldPoint + " point d'armure");
	}

	public void getHealthPoint() {
		System.out.println("Vous avez " + healPoint + " hp");
	}
}

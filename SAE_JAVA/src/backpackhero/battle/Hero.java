package backpackhero.battle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import backpackhero.equipment.Equipment;
import backpackhero.equipment.Gold;
import backpackhero.equipment.ManaStone;
import backpackhero.equipment.Shields;
import backpackhero.equipment.Weapon;
import backpackhero.equipment.Armors;

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
	
	public boolean canAction() {
		for (var item : equipment) {
			if (item.classId() == 1) {
				if (energy > ((Weapon) item).getEnergy()) {
					return true;
				}
				for (var manaStone : mana) {
					if (manaStone.getMana() > ((Weapon) item).getMana()) {
						return true;
					}
				}
			}
			if (item.classId() == 0) {
				if (energy > ((Shields) item).getEnergy()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean canAction(Equipment equipment) {
		if (equipment.needsEnergy()) {
			return this.canActionEnergy(equipment.getEnergy());
		}
		else if (equipment.needsMana()) {
			return this.canActionMana(equipment.getMana());
		}
		return true;
	}
	
	public boolean canActionEnergy(int e) {
		return energy >= e;
	}

	public boolean canActionMana(int m) {
		for (var manaStone : mana) {
			if (manaStone.getMana() >= m) {
				return true;
			}
		}
		return false;
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
		if (this.canActionEnergy(w.getEnergy())) {
			energy -= w.getEnergy();
			attackPoint = w.getDamage();
			return attackPoint;
		}
		return 0;
	}

	public int attack(Weapon w, ManaStone manaStone) {
		Objects.requireNonNull(w);
		if (this.canActionMana(w.getMana())) {
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
	
	public void turnShield() {
		shieldPoint = 0;
		for (var armor : equipment) {
			if (armor.classId() == 2) {
				shieldPoint +=  ((Armors) armor).getShield();
			}
		}
	}

	public void shield(Shields shield) {
		Objects.requireNonNull(shield);
		if (this.canActionEnergy(shield.getEnergy())) {
			shieldPoint += shield.getBlock();
			energy -= shield.getEnergy();
		}
	}
	
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	
	public Equipment getItem(int id) {
		for (var item : equipment) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public int energy() {
		return energy;
	}

	public void endTurn() {
		this.turnShield();
		energy = 3;
	}

	public boolean alive() {
		return healPoint > 0;
	}
	
	public void newGold() {
		gold = new Gold();
	}
	
	public void addManaStone(ManaStone manaStone) {
		this.mana.add(manaStone);
	}
	
	public int numberOfManaStone() {
		return mana.size();
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
	
	public ArrayList<ManaStone> getMana() {
		return mana;
	}

	public void getShield() {
		System.out.println("Vous avez " + shieldPoint + " point d'armure");
	}

	public void getHealthPoint() {
		System.out.println("Vous avez " + healPoint + " hp");
	}
}

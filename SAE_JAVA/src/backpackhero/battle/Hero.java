package backpackhero.battle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import backpackhero.equipment.Equipment;
import backpackhero.equipment.Gold;
import backpackhero.equipment.Weapon;

public class Hero {
	private int maxHealPoint;
	private int healPoint;
	private int attackPoint;
	private int shieldPoint;
	private int energy;
	private Gold gold;
	private ArrayList<Equipment> equipment;

	public Hero() {
		maxHealPoint = 40;
		healPoint = 40;
		attackPoint = 7;
		shieldPoint = 0;
		energy = 3;
		gold = new Gold();
		var equipment = new ArrayList<Equipment>();
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
	
	public boolean canAttack(int e) {
		return energy >= e;
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
		if (this.canAttack(w.getEnergy())) {
			attackPoint = w.getDamage();
			energy -= w.getEnergy();
			return attackPoint;
		}
		return 0;
	}

	public int attackChoice() {
		var choice = new Scanner(System.in);
		return choice.nextInt();
	}

	public void shield() {
		energy -= 1;
		shieldPoint += 14;
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
	
	public boolean addHealPoint() {
		if (gold.removeGold(5) && healPoint != maxHealPoint) {
			int diff = maxHealPoint - healPoint;
			if (diff < 25) {
				healPoint += diff;
			}
			else {
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
		equipment.add(e);
	}
	
	public boolean removeEquipment(Equipment e) {
		return equipment.remove(e);
	}

 	public void getShield() {
		System.out.println("Vous avez " + shieldPoint + " point d'armure");
	}

	public void getHealthPoint() {
		System.out.println("Vous avez " + healPoint + " hp");
	}
}

package backpackhero.battle;

import java.util.ArrayList;

import backpackhero.Coordinates;
import backpackhero.donjon.EnemyRoom;
import backpackhero.equipment.Dart;
import backpackhero.equipment.ElectricWand;
import backpackhero.equipment.Equipment;
import backpackhero.equipment.ManaStone;
import backpackhero.equipment.RoughBuckler;
import backpackhero.equipment.Tunic;
import backpackhero.equipment.Weapon;
import backpackhero.equipment.WoodenSword;

public class Main {
	public static void mobStats(EnemyRoom enemies) {
		for (var mob : enemies.monsters()) {
			if (mob.alive() ) {
				mob.getHp();
				mob.getShield();
			}
		}
	}
	
	public static ArrayList<Integer> allMobActions(Hero hero, EnemyRoom enemies) {
		var actions = new ArrayList<Integer>();
		for (var mob : enemies.monsters()) {
			if (mob.alive()) {
				var action = mob.getAction();
				dataFutureAction(mob, action);
				printAction(mob, action);
				actions.add(action);
			}
		}
		return actions;
	}
	
	public static void mobAction(Hero hero, Monsters mob, int action) {
		if (action == 0) {
			mob.shield();
		} else {
			hero.dammageReceived(mob.attackTurn());
		}
	}

	public static void printAction(Monsters mob, int action) {
		if (action == 0) {
			mob.getFutureShield();
		} else {
			mob.getFutureAttack();
		}
	}

	public static void dataFutureAction(Monsters mob, int action) {
		if (action == 0) {
			shield(mob);
		} else {
			attack(mob);
		}
	}

	public static void attack(Monsters mob) {
		mob.attack();
	}

	public static void shield(Monsters mob) {
		mob.addedShield();
	}
	
	public static void attackChosableTarget(Hero hero, EnemyRoom enemies, Weapon w, ManaStone mana) {
		var string = new StringBuilder("Choisissez une cible :");
		int i = 1;
		for (var mob : enemies.monsters()) {
			if (mob.alive()) {
				string.append("\n- " + i + " pour " + mob);
				i++;
			}
		}
		System.out.println(string);
		boolean accurateChoice = false;
		do {
			var choice = hero.attackChoice();
			accurateChoice = targetChoice(hero, enemies, choice, w, mana);
			if (!accurateChoice) {
				System.out.println("Veuillez choisir une cible valide !");
			}
		} while (!accurateChoice);
	}

	public static boolean targetChoice(Hero hero, EnemyRoom enemies, int choice, Weapon w, ManaStone mana) {
		int i = 1;
		for (var mob : enemies.monsters()) {
			if (choice == i) {
				if (((Equipment) w).needsMana()) {
					mob.dammageReceived(hero.attack(w, mana));
				}
				else if (((Equipment) w).needsEnergy()) {
					mob.dammageReceived(hero.attack(w));
				}
				if (!mob.alive()) {
					System.out.println(mob + " est mort");
				}
				return true;
			}
			i++;
		}
		return false;
	}
	
	public static void mobEndTurn(Hero hero, EnemyRoom enemies, ArrayList<Integer> actions) {
		int i = 0;
		for (var mob : enemies.monsters()) {
			if (mob.alive()) {
				mob.endTurn();
				var action = actions.get(i);
				mobAction(hero, mob, action);
			}
			else {
				enemies.removeMonster(mob);
			}
			i++;
		}
	}

	public static void main(String[] args) {
		var enemies = new EnemyRoom(new Coordinates(1, 8));
		var mob1 = new SmallRatwolf(1);
		var mob2 = new Ratwolf(1);
		enemies.add(mob1);
		enemies.add(mob2);
		var hero = new Hero();
		var sword = new WoodenSword();
		var shield = new RoughBuckler();
		var dart = new Dart();
		var armor = new Tunic();
		var wand = new ElectricWand();
		var mana = new ManaStone(2);
		hero.newGold();
		hero.addEquipment(sword);
		hero.addEquipment(dart);
		hero.addEquipment(armor);
		hero.addEquipment(wand);
		hero.addEquipment(shield);
		hero.addManaStone(mana);
		while (enemies.oneAlive() && hero.alive()) {
			hero.getHealthPoint();
			mobStats(enemies);
			var actions = allMobActions(hero, enemies);
			while (true) {
				if ((!mob1.alive() && !mob2.alive()) || !hero.alive()) {
					break;
				}
				System.out.println("Il vous reste " + hero.energy() + " points d'énergie");
				var manaString = new StringBuilder("Vous avez " + hero.numberOfManaStone() + " pierres de mana :");
				for (var manaStone : hero.getMana()) {
					manaString.append("\n- " + manaStone.getMana() + "/" + manaStone.getManaMax());
				}
				System.out.println(manaString);
				var string = new StringBuilder("Choisissez un équipement : ");
				for (var equipment : hero.getEquipment()) {
					if (equipment.isSelectable() && hero.canAction(equipment)) {
						string.append("\n- tapez '" + equipment.getId() + "' pour " + equipment);
						if (equipment.needsEnergy()) {
							string.append(" qui nécessite " + equipment.getEnergy() + " énergies");
						}
						else if (equipment.needsMana()) {
							string.append(" qui nécessite " + equipment.getMana() + " mana");
						}
					}
				}
				System.out.println(string);
				System.out.println("Ou tapez '0' pour finir votre tour");
				var id = hero.getAction();
				if (id == 0) {
					break;
				}
				var equipment = hero.getItem(id);
				if (equipment != null && hero.canAction(equipment)) {
					if (equipment.isTargetable() && equipment.classId() == 1) {
						attackChosableTarget(hero, enemies, (Weapon) equipment, mana);
					} else if (!equipment.isTargetable() && equipment.classId() == 1) {
						for (var mob : enemies.monsters()) {
							mob.dammageReceived(hero.attack(dart));
						}
					} else if (equipment.classId() == 0) {
						hero.shield(shield);
					}
					if (equipment.getId() == 2) {
						hero.removeEquipment(dart);
					}
				}
				else {
					System.out.println("*** Veuillez choisir un équipement valide ! ***");
				}
				
			}
			mobEndTurn(hero, enemies, actions);
			hero.endTurn();
		}
		if (!enemies.oneAlive()) {
			System.out.println("Vous avez gagné ! :)");
		} else {
			System.out.println("Vous avez perdu ! :(");
		}
	}
}

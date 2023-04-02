package backpackhero.battle;

import java.util.ArrayList;

import backpackhero.Coordinates;
import backpackhero.donjon.EnemyRoom;
import backpackhero.equipment.Dart;
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
	
	public static void attackChosableTarget(Hero hero, EnemyRoom enemies, Weapon w) {
		System.out.println("Choisissez une cible : - 1 pour attaquer SmallRatwolf \n - 2 pour attaquer Ratwolf");
		boolean accurateChoice = false;
		do {
			var choice = hero.attackChoice();
			accurateChoice = targetChoice(hero, enemies, choice, w);
			if (!accurateChoice) {
				System.out.println("Veuillez choisir une cible valide !");
			}
		} while (!accurateChoice);
		
	}

	public static boolean targetChoice(Hero hero, EnemyRoom enemies, int choice, Weapon w) {
		int i = 1;
		for (var mob : enemies.monsters()) {
			if (choice == i) {
				mob.dammageReceived(hero.attack(w));
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
				System.out.println(mob + " est mort");
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
		hero.addEquipment(shield);
		hero.addEquipment(sword);
		hero.addEquipment(dart);
		while (enemies.oneAlive() && hero.alive()) {
			hero.getHealthPoint();
			mobStats(enemies);
			var actions = allMobActions(hero, enemies);
			while (hero.energy() > 0) {
				if ((!mob1.alive() && !mob2.alive()) || !hero.alive()) {
					break;
				}
				System.out.println("Il vous reste " + hero.energy() + " points d'énergie");
				var string = new StringBuilder("Choisissez un équipement : ");
				for (var equipment : hero.getEquipment()) {
					string.append("\n- tapez '" + equipment.getId() + "' pour " + equipment);
				}
				System.out.println(string);
				var equipment = hero.getAction();
				if (equipment == shield.getId()) {
					hero.shield(shield);
				} else if (equipment == sword.getId()) {
					attackChosableTarget(hero, enemies, sword);
				} 
				else if (equipment == dart.getId()) {
					for (var mob : enemies.monsters()) {
						mob.dammageReceived(hero.attack(dart));
					}
					hero.removeEquipment(dart);
				} else {
					System.out.println("Veuillez choisir un équipement valide !");
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

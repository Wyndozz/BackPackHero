package backpackhero.battle;

import backpackhero.equipment.WoodenSword;

public class Main {
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

	public static void main(String[] args) {
		var mob1 = new SmallRatwolf(1);
		var mob2 = new Ratwolf(1);
		var hero = new Hero();
		var sword = new WoodenSword();
		hero.addEquipment(sword);
		int action1 = 0;
		int action2 = 0;
		while ((mob1.alive() || mob2.alive()) && hero.alive()) {
			hero.getHealthPoint();
			mob1.getHp();
			mob1.getShield();
			mob2.getHp();
			mob2.getShield();
			if (mob1.alive()) {
				action1 = mob1.getAction();
				dataFutureAction(mob1, action1);
				printAction(mob1, action1);
			}
			if (mob2.alive()) {
				action2 = mob2.getAction();
				dataFutureAction(mob2, action2);
				printAction(mob2, action2);
			}
			while (hero.energy() > 0) {
				if ((!mob1.alive() && !mob2.alive()) || !hero.alive()) {
					break;
				}
				System.out.println("Il vous reste " + hero.energy() + " points d'énergie");
				var action = hero.getAction();
				if (action == 0) {
					hero.shield();
				} else {
					var choice = hero.attackChoice();
					if (choice == 1) {
						mob1.dammageReceived(hero.attack(sword));
					} else {
						mob2.dammageReceived(hero.attack(sword));
					}
				}
			}
			if (mob1.alive()) {
				mob1.endTurn();
				mobAction(hero, mob1, action1);
			}
			if (mob2.alive()) {
				mob2.endTurn();
				mobAction(hero, mob2, action2);
			}
			hero.endTurn();
		}
		if (!mob1.alive() && !mob2.alive()) {
			System.out.println("Vous avez gagner ! :)");
		} else {
			System.out.println("Vous avez perdu ! :(");
		}
	}
}

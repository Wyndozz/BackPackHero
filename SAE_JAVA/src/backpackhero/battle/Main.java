package backpackhero.battle;

public class Main {
	public static void mobAction(Hero hero, Monsters mob, int action) {
		if (action == 0) {
			mob.shield();
		}
		else {
			hero.dammageReceived(mob.attackTurn());
		}
	}
	
	public static void printAction(Monsters mob, int action) {
		if (action == 0) {
			mob.getFutureShield();
		}
		else {
			mob.getFutureAttack();
		}
	}
	
	public static void dataFutureAction(Monsters mob, int action) {
		if (action == 0) {
			attack(mob);
		}
		else {
			shield(mob);
		}
	}
	
	public static int attack(Monsters mob) {
		mob.attack();
		return mob.attackTurn();
	}
	
	public static int shield(Monsters mob) {
		return mob.shieldTurn();
	}

	public static void main(String[] args) {
		var mob1 = new SmallRatwolf(1);
		var mob2 = new SmallRatwolf(2);
		var hero = new Hero();
		int action1 = 0;
		int action2 = 0;
		while ((mob1.alive() || mob2.alive()) && hero.alive()) {
			hero.getHealthPoint();
			hero.getShield();
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
					hero.getShield();
				}
				else {
					var choice = hero.attackChoice();
					if (choice == 1) {
						mob1.dammageReceived(hero.attack());
						hero.getShield();
					}
					else {
						mob2.dammageReceived(hero.attack());
						hero.getShield();
					}
				}
			}
			if (mob1.alive()) {
				mobAction(hero, mob1, action1);
			}
			if (mob2.alive()) {
				mobAction(hero, mob2, action2);
			}
			hero.finTour();
		}
		if (!mob1.alive() && !mob2.alive()) {
			System.out.println("Vous avez gagner ! :)");
		}
		else {
			System.out.println("Vous avez perdu ! :(");
		}

	}

}

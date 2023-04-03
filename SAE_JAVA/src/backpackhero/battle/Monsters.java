package backpackhero.battle;

public interface Monsters {

	default int getAction() {
		int action = (int) Math.round(Math.random());
		return action;
	}

	default int getFutureAttack() {
		System.out.println(this + "va vous attaquer avec " + attackTurn() + " points de dégâts");
		return attackTurn();
	}

	default int getFutureShield() {
		System.out.println(this + "s'ajoute " + shieldTurn() + " points de bouclier");
		return shieldTurn();
	}

	void endTurn();

	default boolean alive() {
		return healthPoint() > 0;
	}

	void attack();

	int attackTurn();

	void shield();

	int shieldTurn();

	void dammageReceived(int dammage);

	int healthPoint();

	void addedShield();
	
	void getHp();
	void getShield();
}

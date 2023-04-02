package backpackhero.battle;

public interface Monsters {

	default int getAction() {
		int action = (int) Math.round(Math.random());
		return action;
	}

	default int getFutureAttack() {
		System.out.println("Attack " + this + " = " + attackTurn());
		return attackTurn();
	}

	default int getFutureShield() {
		System.out.println("Shield " + this + " +" + shieldTurn());
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

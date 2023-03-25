package backpackhero.battle;

public interface Monsters {

	default int getAction() {
		int action = (int) Math.round(Math.random());
		return action;
	}
	
	default int getFutureAttack() {
		System.out.println("Attack Small Ratwolf " + number() + " = " + attackTurn());
		return attackTurn();
	}
	
	default int getFutureShield() {
		System.out.println("Shield Small Ratwolf " + number() + " +14");
		return shieldTurn();
	}
	
	default boolean alive() {
		return healthPoint() > 0;
	}

	void attack();
	
	int attackTurn();
	
	void shield();
	
	void shieldAdd();
	
	int shieldTurn();
	
	void dammageReceived(int dammage);
	
	int number();
	
	int healthPoint();
}

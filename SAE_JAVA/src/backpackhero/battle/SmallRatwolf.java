package backpackhero.battle;

public class SmallRatwolf implements Monsters {
	private int healthPoint;
	private int shieldPoint;
	private int addedShield;
	private int attackPoint;
	private final int number;

	public SmallRatwolf(int number) {
		healthPoint = 32;
		shieldPoint = 0;
		attackPoint = (int) (Math.random() * 3) + 7;
		this.number = number;
	}

	@Override
	public void attack() {
		attackPoint = (int) (Math.random() * 3) + 7;
	}

	@Override
	public int attackTurn() {
		return attackPoint;
	}

	@Override
	public void shield() {
		shieldPoint = addedShield;
	}

	@Override
	public void addedShield() {
		addedShield = 14;
	}

	@Override
	public int shieldTurn() {
		return addedShield;
	}

	@Override
	public void dammageReceived(int dammage) {
		int remainingShield = shieldPoint - dammage;
		if (remainingShield < 0) {
			shieldPoint = 0;
			healthPoint += remainingShield;
		} else {
			shieldPoint -= dammage;
		}
		if (healthPoint < 0) {
			healthPoint = 0;
		}
	}

	@Override
	public int healthPoint() {
		return healthPoint;
	}

	@Override
	public void endTurn() {
		shieldPoint = 0;
	}

	@Override
	public String toString() {
		return "Small Ratwolf " + number;
	}

	public void getHp() {
		System.out.println("HealthPoint Small Ratwolf " + number + " = " + healthPoint);
	}

	public void getShield() {
		System.out.println("Shield Small Ratwolf " + number + " = " + shieldPoint);
	}
}

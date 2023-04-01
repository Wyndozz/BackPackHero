package backpackhero.battle;

public class Ratwolf implements Monsters {
	private int healthPoint;
	private int shieldPoint;
	private int addedShield;
	private int attackPoint;
	private final int id;

	public Ratwolf(int id) {
		healthPoint = 45;
		shieldPoint = 0;
		attackPoint = 0;
		this.id = id;
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
		addedShield = (int) (Math.random() * 4) + 13;
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

	public void endTurn() {
		shieldPoint = 0;
	}

	@Override
	public String toString() {
		return "Ratwolf n°" + id;
	}

	public void getHp() {
		System.out.println("HealthPoint Ratwolf n°" + id + " = " + healthPoint);
	}

	public void getShield() {
		System.out.println("Shield Ratwolf n°" + id + " = " + shieldPoint);
	}
}

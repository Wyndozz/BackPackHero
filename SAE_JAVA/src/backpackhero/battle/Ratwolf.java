package backpackhero.battle;

public class Ratwolf implements Monsters{
	private int healthPoint;
	private int shieldPoint;
	private int shieldAdd;
	private int attackPoint;
	private final int number;
	
	public Ratwolf(int number) {
		healthPoint = 45;
		shieldPoint = 0;
		shieldAdd = 0;
		attackPoint = (int) (Math.random()*3) + 7;
		this.number = number;
	}
	@Override
	public void attack() {
		attackPoint = (int) (Math.random()*3) + 7;
	}
	
	@Override
	public int attackTurn() {
		return attackPoint;
	}

	@Override
	public void shield() {
		shieldPoint += shieldAdd;
	}
	
	public void shieldAdd() {
		shieldAdd = (int) (Math.random()*4) + 13;
	}
	
	@Override
	public int shieldTurn() {
		return shieldPoint;
	}

	@Override
	public void dammageReceived(int dammage) {
		int remainingShield = shieldPoint-dammage;
		if (remainingShield < 0) {
			shieldPoint = 0;
			healthPoint += remainingShield;
		}
		else {
			shieldPoint -= dammage ;
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
	public int number() {
		return number;
	}
	
	public void getHp() {
		System.out.println("HealthPoint Small Ratwolf " + number + " = " + healthPoint);
	}
	
	public void getShield() {
		System.out.println("Shield Small Ratwolf " + number + " = " + shieldPoint);
	}
}

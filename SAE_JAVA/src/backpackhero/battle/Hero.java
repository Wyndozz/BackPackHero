package backpackhero.battle;

import java.util.Scanner;

public class Hero {
	private int healthPoint;
	private int attackPoint;
	private int shieldPoint;
	private int energy;

	public Hero() {
		healthPoint = 40;
		attackPoint = 7;
		shieldPoint = 0;
		energy = 3;
	}
	
	public int getAction() {
		var action = new Scanner(System.in);
		return action.nextInt();
	}
	
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
	
	public int attack() {
		energy -= 1;
		return attackPoint;
	}

	public int attackChoice() {
		var choice = new Scanner(System.in);
		return choice.nextInt();
	}
	
	public void shield() {
		energy -= 1;
		shieldPoint += 14;
	}
	
	public int energy() {
		return energy;
	}
	
	public void finTour() {
		energy = 3;
	}
	
	public boolean alive() {
		return healthPoint > 0;
	}
	
	public void getShield() {
		System.out.println("Vous avez " + shieldPoint + " point d'armure");
	}
	
	public void getHealthPoint() {
		System.out.println("Vous avez "+ healthPoint + " hp");
	}
}

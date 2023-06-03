package backpackhero.donjon;

import java.util.ArrayList;
import java.util.Objects;

import backpackhero.Coordinates;
import backpackhero.battle.Monsters;

public class EnemyRoom implements DungeonRoom {
	private final ArrayList<Monsters> monsters;
	private final Coordinates coordinates;
	private final int id;
	
	public EnemyRoom(Coordinates coordinates) {
		monsters = new ArrayList<Monsters>();
		this.coordinates = coordinates;
		id = 2;
	}
	
	public void add(Monsters monster) {
		Objects.requireNonNull(monster);
		monsters.add(monster);
	}
	
	public boolean oneAlive() {
		for (var enemy : monsters) {
			if (enemy.alive()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removeMonster(Monsters mob) {
		return monsters.remove(mob);
	}
	
	public ArrayList<Monsters> monsters() {
		return monsters;
	}
	
	@Override
	public Coordinates coordinates() {
		return coordinates;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	@Override
	public String tab() {
		return "E";
	}
	
	@Override
	public String toString() {
		var string = new StringBuilder();
		for (var monster : monsters) {
			if (monsters.indexOf(monster) < monsters.size()-1) {
				string.append(monster + ", ");
			}
			else {
				string.append(monster);
			}
		}
		return "des ennemies : [" + string + "] ";
	}
}

package backpackhero.donjon;

import java.util.List;

import backpackhero.Coordinates;
import backpackhero.battle.Ratwolf;
import backpackhero.battle.SmallRatwolf;

public class Main {

	public static void main(String[] args) {
		var enemy = new EnemyRoom(new Coordinates(1, 2));
		var enemy2 = new EnemyRoom(new Coordinates(1, 5));
		var enemy3 = new EnemyRoom(new Coordinates(1, 8));
		enemy.add(new SmallRatwolf(1));
		enemy.add(new SmallRatwolf(2));
		enemy2.add(new Ratwolf(1));
		enemy3.add(new SmallRatwolf(1));
		enemy3.add(new Ratwolf(1));
		Floor etage1 = new Floor(1);
		etage1.add(enemy);
		etage1.add(new ExitRoom(new Coordinates(4, 1)));
		etage1.add(new TreasureRoom(new Coordinates(0, 8)));
		etage1.add(new TreasureRoom(new Coordinates(1, 4)));
		etage1.add(new HealerRoom(new Coordinates(2, 1)));
		etage1.add(new MerchantRoom(new Coordinates(3, 5)));
		etage1.add(enemy2);
		etage1.add(enemy3);
		var corridors = List.of(new Coordinates(4, 9), new Coordinates(3, 9), new Coordinates(3, 8), new Coordinates(2, 8), new Coordinates(2, 7), new Coordinates(2, 6), new Coordinates(2, 5), new Coordinates(2, 4), new Coordinates(2, 3), new Coordinates(2, 2), new Coordinates(3, 2), new Coordinates(4, 2));
		etage1.addCorridors(corridors);
		System.out.println(etage1);
		System.out.println(etage1.tab());
	}

}

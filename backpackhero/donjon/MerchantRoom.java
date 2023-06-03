package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class MerchantRoom implements DungeonRoom {
	private final Coordinates coordinates;
	private final int id;
	
	public MerchantRoom(Coordinates coordinates) {
		this.coordinates = coordinates;
		id = 4;
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
		return "M";
	}
	
	@Override
	public String toString() {
		return "un marchand ";
	}

}

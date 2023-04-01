package backpackhero.donjon;

import java.util.Objects;

import backpackhero.Coordinates;

public class MerchantRoom implements DungeonRoom {
	private final Coordinates coordinate;
	private final int id;
	
	public MerchantRoom(Coordinates coordinate) {
		Objects.requireNonNull(coordinate);
		this.coordinate = coordinate;
		id = 4;
	}

	@Override
	public Coordinates coordinate() {
		return coordinate;
	}
	
	@Override
	public int id() {
		return id;
	}
	
	public String tab() {
		return "M";
	}
	
	@Override
	public String toString() {
		return "un marchand ";
	}

}

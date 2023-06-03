package backpackhero.equipment;

public interface Weapon {
	default int classId() {
		return 1;
	}

	int getId();

	int getDamage();

	int getEnergy();
	
	int getMana();
}

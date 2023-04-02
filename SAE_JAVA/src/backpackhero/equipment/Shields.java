package backpackhero.equipment;

public interface Shields {
	default int classId() {
		return 0;
	}
	
	int getId();
	
	int getBlock();

	int getEnergy();

}

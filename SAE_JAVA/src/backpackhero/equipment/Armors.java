package backpackhero.equipment;

public interface Armors {
	default int classId() {
		return 2;
	}

	int getId();

}

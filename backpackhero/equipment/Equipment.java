package backpackhero.equipment;

public interface Equipment {
	int getId();
	int classId();
	
	int getEnergy();
	int getMana();
	
	boolean needsEnergy();
	boolean needsMana();
	
	boolean isSelectable();
	
	boolean isTargetable();
}

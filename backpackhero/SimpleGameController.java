package backpackhero;

import java.awt.Color;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;

public class SimpleGameController {
	
	public SimpleGameController() {
	
	}
	
	private static void mapGenerator(ApplicationContext context) {
		int xOrigin = 1000;
		int yOrigin = 50;
		int nbRooms = 25;
		
		SimpleGameData data = new SimpleGameData(5, 11, nbRooms);
		SimpleGameView view = SimpleGameView.initGameGraphics(xOrigin, yOrigin, 885, 405, 75, 5, data);
		SimpleGameView.draw(context, data, view);
	}
	
	public static void main(String[] args) {
		Application.run(new Color(185, 122, 87), SimpleGameController::mapGenerator);
	}
}

package backpackhero;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;

public record SimpleGameView(int xOrigin, int yOrigin, int width, int height, int cellSize, int cellMargin) {
	/*50, 50, 825/11, 375/5*/

	public static SimpleGameView initGameGraphics(int xOrigin, int yOrigin, int width, int height, int cellSize, int cellMargin, SimpleGameData data) {
		Objects.requireNonNull(data);
		return new SimpleGameView(xOrigin, yOrigin, width, height, cellSize, cellMargin);
	}
	
	private float xFromJ(int j) {
		return xOrigin + j * cellSize + cellMargin*(j+1);
	}
	
	private float yFromI(int i) {
		return yOrigin + i * cellSize + cellMargin*(i+1);
	}
	
	private void drawCell(Graphics2D graphics, SimpleGameData data, int i, int j, Color color) {
		var x = xFromJ(j);
		var y = yFromI(i);
		graphics.setColor(color);
		graphics.fill(new Rectangle2D.Float(x, y, cellSize, cellSize));
		/*var transform = new AffineTransform();
		var image = data.visible(i, j) ? loader.image(data.id(i, j)) : loader.blank();
		drawImage(graphics, image, x + 2, y + 2, squareSize - 4, squareSize - 4);*/
	}
	
	private void draw(Graphics2D graphics, SimpleGameData data) {
		graphics.setColor(new Color(56, 35, 7));
		graphics.fill(new Rectangle2D.Float(xOrigin, yOrigin, width, height));
		
		for (int i = 0; i < data.lines(); i++) {
			for (int j = 0; j < data.columns(); j++) {
				drawCell(graphics, data, i, j, data.colorCell(i, j));
			}
		}
	}
	
	public static void draw(ApplicationContext context, SimpleGameData data, SimpleGameView view) {
		context.renderFrame(graphics -> view.draw(graphics, data));
	}
}

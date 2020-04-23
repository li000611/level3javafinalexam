package lissajous.animator;

import java.util.function.BiConsumer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lissajous.entity.property.Entity;

public class Animator extends AbstractAnimator {
	private Color background = Color.ANTIQUEWHITE;
	private long lastTime;
	
	@Override
	protected void handle(GraphicsContext gc, long now) {
		if(now - lastTime > 1000000000 / 30) {
			this.lastTime = now;
			this.clearAndFill(gc, background);
			this.drawEntities(gc);
		}
	}
	
	public void drawEntities(GraphicsContext graphicsContext) {
		BiConsumer<Entity, GraphicsContext> draw = (Entity e, GraphicsContext gc) -> {
			if(e != null && e.isDrawable()) {
				e.getDrawable().draw(gc);
			}
		};
		
		draw.accept(map.getBackground(), graphicsContext);
		
		for(Entity e : map.entities()) {
			draw.accept(e, graphicsContext);
		}
	}

}

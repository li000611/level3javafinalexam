package lissajous.scene;

import javafx.scene.paint.Color;
import lissajous.entity.GenericEntity;

public class ShiftingScene extends AbstractScene {

	@Override
	public AbstractScene createScene() {
		CurveBuilder cb = CurveBuilder.instance();
		cb.setStroke(Color.BLACK, 1)
			.setRadiusValue(100)
			.setStepIncrement(2)
			.setPhaseShiftInDegrees(90)
			.setSpriteName("shifting");
		
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				GenericEntity entity = cb.setPosition(i*200-50, j*200-75)
					.setABRatio(i, j)
					.build();
				
				this.entities.add(entity);
			}
		}
		return this;
	}
	
}





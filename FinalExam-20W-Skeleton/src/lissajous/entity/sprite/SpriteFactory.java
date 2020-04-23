package lissajous.entity.sprite;

public class SpriteFactory {
	private SpriteFactory() { }
	public static <T> T getSprite(String name) {
		if(name == null) {
			throw new NullPointerException();
		}
		
		if(name.equals("tracing")) {
			TracingCurveSprite tracing = new TracingCurveSprite();
			return (T) tracing;
		} else if(name.equals("shifting")) {
			ShiftingCurveSprite shifting = new ShiftingCurveSprite();
			return (T) shifting;
		} else {
			throw new UnsupportedOperationException();
		}
	}
}

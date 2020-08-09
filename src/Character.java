import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Character implements GameObject{
	private DoubleProperty x = new SimpleDoubleProperty(0);
	private DoubleProperty y = new SimpleDoubleProperty(0);

	Character(double x, double y) {
		this.x.set(x);
		this.y.set(y);
	}
	
	public double getX() {
		return x.get();
	};

	public void setX(double x) {
		this.x.set(x);
	}

	public DoubleProperty getObservableX() {
		return x;
	};

	public double getY() {
		return y.get();
	};

	public void setY(double y) {
		this.y.set(y);
	}

	public DoubleProperty getObservableY() {
		return y;
	};

	public abstract void update(double windowHeight);

	public abstract void jump();
}

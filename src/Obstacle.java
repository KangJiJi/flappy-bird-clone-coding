import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Obstacle implements GameObject {
	private double windowWidth = 0;
	private double windowHeight = 0;
	private DoubleProperty x = new SimpleDoubleProperty(0);
	private DoubleProperty y = new SimpleDoubleProperty(0);

	Obstacle(double windowWidth, double windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	};

	public double getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(double windowWidth) {
		this.windowWidth = windowWidth;
	}

	public double getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(double windowHeight) {
		this.windowHeight = windowHeight;
	}
	
	public double getX() {
		return x.get();
	}

	public DoubleProperty getObservableX() {
		return x;
	};

	public void setX(double x) {
		this.x.set(x);
	};

	public double getY() {
		return y.get();
	};

	public DoubleProperty getObservableY() {
		return y;
	};

	public void setY(double y) {
		this.y.set(y);
	};
	
	public abstract void update();

	public abstract boolean isCollision(Character character);
	
	public abstract boolean isOutOfScreen();
}

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pipe extends Obstacle implements Drawable {
	private Rectangle topRect = new Rectangle();
	private Rectangle bottomRect = new Rectangle();
	private double topRectHeight = 0;
	private double bottomRectHeight = 0;

	private double width = 50;
	private double space = 350;
	private double speed = 5;

	Pipe(double windowWidth, double windowHeight) {
		super(windowWidth, windowHeight);
		
		this.setX(windowWidth);
		topRectHeight = (Math.random() * (windowHeight / 2));
		bottomRectHeight = windowHeight - topRectHeight + space;
		
		topRect.setX(this.getX());
		topRect.setY(this.getY());
		topRect.setWidth(this.width);
		topRect.setHeight(this.topRectHeight);
		topRect.setFill(Color.GREEN);

		bottomRect.setX(this.getX());
		bottomRect.setY(this.getY() + topRectHeight + space);
		bottomRect.setWidth(this.width);
		bottomRect.setHeight(this.bottomRectHeight);
		bottomRect.setFill(Color.GREEN);

		topRect.xProperty().bind(super.getObservableX());
		bottomRect.xProperty().bind(super.getObservableX());
	}
	
	Pipe() {
		this(0, 0);
	}
	
	@Override
	public Node[] getNodes() {
		Node[] tempNodeArr = {this.topRect, this.bottomRect};
		return tempNodeArr;
	}
	

	@Override
	public void update() {
		this.setX(this.getX() - speed);
	}

	@Override
	public boolean isCollision(Character character) {
		double characterXPosition = character.getX();
		double characterYPosition = character.getY();
		if (super.getX() < characterXPosition && characterXPosition < super.getX() + this.width) {
			if(super.getX() < characterYPosition && characterYPosition < super.getY() + this.topRectHeight) {
				// Top rect collision
				return true;
			}
			if(super.getX() + this.topRectHeight + this.space < characterYPosition && characterYPosition <= super.getWindowHeight()) {
				// Bottom rect collision
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isOutOfScreen() {
		if(this.getX() < 0) return true;
		else return false;
	}
}

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends Obstacle implements Drawable {
	private Image bomb = new Image("images/bomb.png");
	private ImageView bombView = new ImageView(bomb);
	private double width = 150;
	private double height = 150;
	private double speed = 9;

	Bomb(double windowWidth, double windowHeight) {
		super(windowWidth, windowHeight);
		double randBombYPosition = (Math.random() * windowHeight) - 50;

		bombView.setFitHeight(this.width);
		bombView.setFitWidth(this.height);
		bombView.setX(super.getX());
		bombView.setY(super.getY());
		
		super.setX(windowWidth);
		super.setY(randBombYPosition);
		
		bombView.xProperty().bind(super.getObservableX());
		bombView.yProperty().bind(super.getObservableY());
	}

	Bomb() {
		this(0, 0);
	}

	@Override
	public Node[] getNodes() {
		Node[] tempNodeArr = {this.bombView};
		return tempNodeArr;
	}

	@Override
	public void update() {
		this.setX(this.getX() - speed);
	}

	@Override
	public boolean isCollision(Character character) {
		if(super.getX() < character.getX() && character.getX() < super.getX() + this.width) {
			if(super.getY() + 55 < character.getY() && character.getY() < super.getY() + this.height - 55) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isOutOfScreen() {
		// TODO Auto-generated method stub
		return false;
	}
}

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bird extends Character implements Drawable {
	private Image bird = new Image("images/bird.png");
	private ImageView birdView = new ImageView(bird);
	private double gravity = 0.5;
	private double lift = -15;
	private double velocity = 0;

	Bird(double x, double y) {
		super(x, y);
		
		birdView.setFitHeight(70);
		birdView.setFitWidth(70);
		birdView.setX(super.getX() - 40);
		birdView.setY(super.getY() - 40);
		birdView.xProperty().bind(this.getObservableX().subtract(40));
		birdView.yProperty().bind(this.getObservableY().subtract(40));
	}

	Bird() {
		this(0, 0);
	}

	@Override
	public Node[] getNodes() {
		Node[] tempNodeArr = { this.birdView };
		return tempNodeArr;
	}

	@Override
	public void update(double windowHeight) {
		this.velocity += this.gravity;
		this.setY(this.getY() + this.velocity);

		if (this.isTop()) {
			this.setY(0);
			this.velocity = 0;
		}

		if (this.isBottom(windowHeight)) {
			this.setY(windowHeight);
			this.velocity = 0;
		}
	}

	@Override
	public void jump() {
		this.velocity += this.lift;
	}

	private boolean isTop() {
		if (this.getY() < 0)
			return true;
		else
			return false;
	}

	private boolean isBottom(double windowHeight) {
		if (this.getY() > windowHeight)
			return true;
		else
			return false;
	}
}

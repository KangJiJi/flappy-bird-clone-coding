import javafx.scene.layout.Pane;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.util.Duration;

public class GamePane extends Pane implements RoutablePane {
	private boolean isStart = false;
	private Bird bird = new Bird();
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private Text tipMsg = new Text();
	private Text scoreMsg = new Text();
	private Button btGameEnd = new Button("Go to Result");
	private int width, height;
	private int score = 0;

	GamePane(int width, int height) {
		this.width = width;
		this.height = height;

		btGameEnd.setLayoutX((this.width / 2) - 53);
		btGameEnd.setLayoutY((this.height / 2) + 40);

		bird.setX(width / 10);
		bird.setY(height / 2);

		tipMsg.setText("Press up to start");
		tipMsg.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
		tipMsg.setX(width / 2 - 118);
		tipMsg.setY(height / 2);

		scoreMsg.setText(Integer.toString(score));
		scoreMsg.setX(width - 45);
		scoreMsg.setY(20);

		this.getChildren().addAll(bird.getNodes()[0], tipMsg, scoreMsg);

		this.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:
				if (!isStart) {
					isStart = true;
					tipMsg.setText("");
					this.gameStart(bird, obstacles);
				}
				break;
			default:
				break;
			}
		});
	};

	GamePane() {
		this(0, 0);
	}

	private void appendNewObstacle(ArrayList<Obstacle> obstacles) {
		Obstacle newObstacle = this.getRandObstacle();
		Node[] obstacleNodes = ((Drawable) newObstacle).getNodes();
		for (Node obstacleNode : obstacleNodes) {
			this.getChildren().addAll(obstacleNode);
		}
		obstacles.add(newObstacle);
	}
	
	private void gameStart(Character character, ArrayList<Obstacle> obstacles) {
		Timeline animation = new Timeline();

		EventHandler<ActionEvent> eventHandler = e -> {
			if (score % 50 == 0) {
				appendNewObstacle(obstacles);
			}

			character.update(this.height);
			
			for (Obstacle obstacle : obstacles) {
				obstacle.update();
				
				if (obstacle.isOutOfScreen()) {
					obstacles.remove(obstacle);
					this.getChildren().removeAll(((Drawable)obstacle).getNodes());
				}

				if (obstacle.isCollision(character)) {
					// Game over
					animation.pause();
					tipMsg.setText("Game over!!!!!!!!!");
					this.getChildren().add(btGameEnd);
					break;
				}
			}
			score++;
			scoreMsg.setText(Integer.toString(score));
		};

		this.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:
				bird.jump();
				break;
			default:
				break;
			}
		});

		animation.getKeyFrames().add(new KeyFrame(Duration.millis(20), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	private Obstacle getRandObstacle() {
		if (Math.random() < 0.5) {
			return new Pipe(this.width, this.height);
		} else {
			return new Bomb(this.width, this.height);
		}
	}
	
	public int getScore() {
		return this.score;
	}

	public Button getBtGameEnd() {
		return this.btGameEnd;
	}
}

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class ResultPane extends Pane implements RoutablePane {
	private Group group = new Group();
	private Button btRestart = new Button();
	private Button btEnd = new Button();

	ResultPane(int width, int height, int lastGameScore) {
		Text scoreMsg = new Text("Score");
		scoreMsg.setX(width / 2 - 125);
		scoreMsg.setY(height / 5);
		scoreMsg.setFont(Font.font(100));
		
		Text score = new Text(Integer.toString(lastGameScore));
		score.setX(width / 2 - 10);
		score.setY((height / 5) + 40);
		score.setFont(Font.font(20));
		
		btRestart.setText("Retry game");
		btRestart.setLayoutX(width / 2 - 58);
		btRestart.setLayoutY(450);
		btRestart.setPrefSize(130, 80);
		
		btEnd.setText("Exit");
		btEnd.setLayoutX(width / 2 - 17);
		btEnd.setLayoutY(550);
		
		btEnd.setOnAction(e -> {
			System.exit(0);
		});
		
		group.getChildren().addAll(scoreMsg, score, btRestart, btEnd);
		this.getChildren().addAll(group);
	};
	
	ResultPane() {
		this(0, 0, 0);
	}
	
	public Button getBtRestart() {
		return this.btRestart;
	}
}

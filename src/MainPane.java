import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.text.*;

public class MainPane extends StackPane implements RoutablePane{
	private Group group = new Group();
	private Button btGameStart = new Button("Game Start");

	MainPane() {
		Text mainText = new Text(0, 100, "Flappy\nBird");
		mainText.setTextAlignment(TextAlignment.CENTER);
		mainText.setFont(Font.font(100));
		
		Text tipMsg = new Text(118.5, 550, "");
		
		btGameStart.setText("Game Start");
		btGameStart.setLayoutX(95);
		btGameStart.setLayoutY(450);
		btGameStart.setPrefSize(130, 80);
		
		btGameStart.setOnMouseEntered(e -> tipMsg.setText("CHEER UP!"));
		btGameStart.setOnMouseExited(e -> tipMsg.setText(""));
		
		group.getChildren().addAll(mainText, btGameStart, tipMsg);
		this.getChildren().addAll(group);
		this.setAlignment(Pos.TOP_CENTER);
	};

	public Button getBtGameStart() {
		return this.btGameStart;
	}
}

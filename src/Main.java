import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private int width = 480;
	private int height = 640;
	private int lastGameScore = 0;
	private Scene scene = new Scene(new MainPane(), width, height);

	static public void main(String args[]) {
		launch(args);
	}

	public void paneRouting(int paneRoutingIndex) {
		if (paneRoutingIndex == 0) {
			MainPane mainPane = new MainPane();
			mainPane.getBtGameStart().setOnAction(e -> {
				this.paneRouting(1);
			});
			
			this.scene.setRoot(mainPane);
			this.scene.onKeyPressedProperty().bind(mainPane.onKeyPressedProperty());
		} else if (paneRoutingIndex == 1) {
			GamePane gamePane = new GamePane(width, height);
			gamePane.getBtGameEnd().setOnAction(e -> {
				this.lastGameScore = gamePane.getScore();
				this.paneRouting(2);
			});
			
			this.scene.setRoot(gamePane);
			this.scene.onKeyPressedProperty().bind(gamePane.onKeyPressedProperty());
		} else if (paneRoutingIndex == 2) {
			ResultPane resultPane = new ResultPane(width, height, lastGameScore);
			resultPane.getBtRestart().setOnAction(e -> {
				this.paneRouting(1);
			});
			
			this.scene.setRoot(resultPane);
			this.scene.onKeyPressedProperty().bind(resultPane.onKeyPressedProperty());
		} else {}
	}

	@Override
	public void start(Stage primaryStage) {
		this.paneRouting(0);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("FlappyBird");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

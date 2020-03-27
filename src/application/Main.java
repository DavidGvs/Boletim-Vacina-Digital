package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent  = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));
			scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getScene() {
		return scene;
	}
}

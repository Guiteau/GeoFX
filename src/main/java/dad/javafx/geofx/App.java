package dad.javafx.geofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	MainController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		controller = new MainController();
		
		
		Scene escena = new Scene(controller.getMainView());
		
		primaryStage.getIcons().add(new Image("icons/SceneBuilderLogo.png"));
		primaryStage.setScene(escena);
		primaryStage.setTitle("GeoFX.fxml\t");
		primaryStage.show();
		
	}

	public static void main(String[] args) {

		launch(args);
		
	}

}

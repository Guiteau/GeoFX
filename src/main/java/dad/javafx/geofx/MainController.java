package dad.javafx.geofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.controller.ConnectionController;
import dad.javafx.controller.LocationController;
import dad.javafx.controller.SecurityController;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController implements Initializable {

	// CONTROLLERS

	private LocationController locationController = new LocationController();
	private ConnectionController connectionController = new ConnectionController();
	private SecurityController securityController = new SecurityController();

	// VIEW

	@FXML
	private TabPane mainView;

	@FXML
	private Tab tabLocation;

	@FXML
	private Tab tabConnection;

	@FXML
	private Tab tabSecurity;

	public TabPane getMainView() {
		return mainView;
	}

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tabLocation.setContent(locationController.getLocationView());
		tabConnection.setContent(connectionController.getConnectionView());
		tabSecurity.setContent(securityController.getSecurityView());

		// BINDEOS TEXTFIELD IP DE CADA CONTROLADOR

		locationController.getTextField_ipAddress().textProperty()
				.bindBidirectional(connectionController.getTextfield_ipAddress().textProperty());

		connectionController.getTextfield_ipAddress().textProperty()
				.bindBidirectional(securityController.getTextField_ipAddress().textProperty());
		
		locationController.getButton_checkIP().pressedProperty().addListener((o, ov, nv) -> onIPButton_location(o, ov, nv));
		connectionController.getButton_checkIP().pressedProperty().addListener((o, ov, nv) -> onIPButton_connection(o, ov, nv));
		securityController.getButton_checkIP().pressedProperty().addListener((o, ov, nv) -> onIPButton_security(o, ov, nv));
		

	}

	private void onIPButton_security(ObservableValue<? extends Boolean> o, Boolean ov, Boolean nv) {
		
		connectionController.getButton_checkIP().fire();
		locationController.getButton_checkIP().fire();

	}

	private void onIPButton_connection(ObservableValue<? extends Boolean> o, Boolean ov, Boolean nv) {

		locationController.getButton_checkIP().fire();
		securityController.getButton_checkIP().fire();
		
	}

	private void onIPButton_location(ObservableValue<? extends Boolean> o, Boolean ov, Boolean nv) {

		connectionController.getButton_checkIP().fire();
		securityController.getButton_checkIP().fire();
		
	}

}

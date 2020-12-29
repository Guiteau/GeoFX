package dad.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.model.IPAddressModel;
import dad.javafx.model.IPInfo;
import dad.javafx.model.Security;
import dad.javafx.services.IPapi_service;
import dad.javafx.services.Ipify_service;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SecurityController implements Initializable{
	
	// VIEW 
	
    @FXML
    private GridPane securityView;

    @FXML
    private TextField textField_ipAddress;

    @FXML
    private Button button_checkIP;

    @FXML
    private Label label_IPdiagnosis;

    @FXML
    private CheckBox checkBox_proxyDetected;

    @FXML
    private CheckBox checkBox_torDetected;
    
    @FXML
    private CheckBox checkBox_crawlerDetected;

    @FXML
    private Label label_threadLevel;

    @FXML
    private Label label_potentialThreads;

	public GridPane getSecurityView() {
		return securityView;
	}
	
	public TextField getTextField_ipAddress() {
		return textField_ipAddress;
	}

	public Button getButton_checkIP() {
		return button_checkIP;
	}
	
	// SERVICES

	IPapi_service ipapiCall = new IPapi_service();
	
	// MODEL

	private ObjectProperty<IPAddressModel> ipAddress = new SimpleObjectProperty<>();
	private ObjectProperty<IPInfo> ipInfo = new SimpleObjectProperty<>();
	
	public SecurityController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecurityView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ipAddress.set(new IPAddressModel());
		ipInfo.set(new IPInfo());
		
		ipInfo.addListener((o, ov, nv) -> onIPInfoChanged(o, ov, nv));

		try {
			ipAddress.get().IpSalida_ipActualProperty().set(Ipify_service.getPublicIp()); // obtenemos IP de salida
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ipInfo.set(ipapiCall.getIpBasicData(ipAddress.get().getIpSalida_ipActual()));
		} catch (JsonProcessingException | UnirestException e2) {
			e2.printStackTrace();
		}
		
		textField_ipAddress.setText(ipAddress.get().getIpSalida_ipActual());

		// EVENTO
		
		button_checkIP.setOnAction(e -> onCheckIpAction(e));
		
	}
	
	private void onIPInfoChanged(ObservableValue<? extends IPInfo> o, IPInfo ov, IPInfo nv) {

		if(ov != null) {
			
			checkBox_crawlerDetected.selectedProperty().unbind();
			checkBox_proxyDetected.selectedProperty().unbind();
			checkBox_torDetected.selectedProperty().unbind();
			label_threadLevel.textProperty().unbind();
			label_potentialThreads.textProperty().unbind();
			
		}
		
		if(nv != null) {
			
			checkBox_crawlerDetected.selectedProperty().bind(this.setCrawlerDetected(
					nv.getSecurity()));
			checkBox_proxyDetected.selectedProperty().bind(this.setProxyDetected(
					nv.getSecurity()));
			checkBox_torDetected.selectedProperty().bind(this.setTorDetected(
					nv.getSecurity()));
			label_threadLevel.textProperty().bind(this.setThreatLevel(nv.getSecurity()));
			label_potentialThreads.textProperty().bind(this.setThreatTypes(nv.getSecurity()));
			
		}
		
	}

	private void onCheckIpAction(ActionEvent e) {
		
		try {
			ipInfo.set(ipapiCall.getIpBasicData(textField_ipAddress.getText()));
		} catch (JsonProcessingException | UnirestException e1) {
			e1.printStackTrace();
		}

	}

	private BooleanProperty setProxyDetected(Security securityObj) {

		BooleanProperty valueReturned = new SimpleBooleanProperty();

		valueReturned.set(false);

		if (securityObj == null)
			return valueReturned;

		return securityObj.isProxyProperty();

	}
	
	private BooleanProperty setTorDetected(Security securityObj) {

		BooleanProperty valueReturned = new SimpleBooleanProperty();

		valueReturned.set(false);

		if (securityObj == null)
			return valueReturned;

		return securityObj.isTorProperty();

	}

	private BooleanProperty setCrawlerDetected(Security securityObj) {

		BooleanProperty valueReturned = new SimpleBooleanProperty();

		valueReturned.set(false);

		if (securityObj == null)
			return valueReturned;

		return securityObj.isCrawlerProperty();

	}
	
	private StringProperty setThreatLevel(Security securityObj) {

		StringProperty valueReturned = new SimpleStringProperty();

		valueReturned.set("");

		if (securityObj == null)
			return valueReturned;

		return securityObj.threatLevelProperty();

	}
	
	private ObjectProperty setThreatTypes(Security securityObj) {

		ObjectProperty valueReturned = new SimpleObjectProperty();

		valueReturned.set(null);

		if (securityObj == null)
			return valueReturned;

		return securityObj.threatTypesProperty();

	}
	
}

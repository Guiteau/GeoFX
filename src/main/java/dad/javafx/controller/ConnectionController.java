package dad.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.model.Connection;
import dad.javafx.model.IPAddressModel;
import dad.javafx.model.IPInfo;
import dad.javafx.services.IPapi_service;
import dad.javafx.services.Ipify_service;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class ConnectionController implements Initializable{

	// VIEW 
	
    @FXML
    private GridPane connectionView;

    @FXML
    private TextField textfield_ipAddress;

    @FXML
    private Button button_checkIP;

    @FXML
    private Label label_registeredISP;

    @FXML
    private Label label_asn;

    @FXML
    private Label label_protocoloIP;

    @FXML
    private Label label_hostname;

    @FXML
    private Label label_ipAddress;
    
	public GridPane getConnectionView() {
		return connectionView;
	}
	
	public TextField getTextfield_ipAddress() {
		return textfield_ipAddress;
	}
	
	public Button getButton_checkIP() {
		return button_checkIP;
	}
	
	// SERVICES

	IPapi_service ipapiCall = new IPapi_service();
	
	// MODEL

	private ObjectProperty<IPAddressModel> ipAddress = new SimpleObjectProperty<>();
	private ObjectProperty<IPInfo> ipInfo = new SimpleObjectProperty<>();

	public ConnectionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConnectionView.fxml"));
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
		
		textfield_ipAddress.setText(ipAddress.get().getIpSalida_ipActual());

		// EVENTO
		
		button_checkIP.setOnAction(e -> onCheckIpAction(e));
		
	}

	private void onIPInfoChanged(ObservableValue<? extends IPInfo> o, IPInfo ov, IPInfo nv) {

		if(ov != null) {
			
			label_ipAddress.textProperty().unbind();
			label_registeredISP.textProperty().unbind();
			label_protocoloIP.textProperty().unbind();
			label_asn.textProperty().unbindBidirectional(ov);
			label_hostname.textProperty().unbind();		
			
		}
		
		// TODO desbindeo de propiedades
	
		if(nv != null) {
			
			label_ipAddress.textProperty().bind(nv.ipProperty());
			label_registeredISP.textProperty().bind(this.setISP(nv.getConnection()));
			label_protocoloIP.textProperty().bind(nv.typeProperty());
			label_asn.textProperty().bindBidirectional(this.setASN(nv.getConnection()), new NumberStringConverter());
			label_hostname.textProperty().bind(nv.hostnameProperty());		
			
		}
		
		// TODO bindeo de propiedades

		
	}
	
	private void onCheckIpAction(ActionEvent e) {

		try {
			ipInfo.set(ipapiCall.getIpBasicData(textfield_ipAddress.getText()));
		} catch (JsonProcessingException | UnirestException e1) {
			e1.printStackTrace();
		}
		
	}     
	
	private LongProperty setASN(Connection connectionObj) {

		LongProperty valueReturned = new SimpleLongProperty();

		valueReturned.set(0);

		if (connectionObj == null)
			return valueReturned;

		return connectionObj.asnProperty();

	}
	
	private StringProperty setISP(Connection connectionObj) {

		StringProperty valueReturned = new SimpleStringProperty();

		valueReturned.set("");

		if (connectionObj == null)
			return valueReturned;

		return connectionObj.ispProperty();

	}
	
}

package dad.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.model.Currency;
import dad.javafx.model.IPAddressModel;
import dad.javafx.model.IPInfo;
import dad.javafx.model.TimeZone;
import dad.javafx.services.IPapi_service;
import dad.javafx.services.Ipify_service;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class LocationController implements Initializable {

	// VIEW

	@FXML
	private GridPane locationView;

	@FXML
	private TextField textField_ipAddress;

	@FXML
	private Button button_checkIP;

	@FXML
	private Label label_ipLocationPais;

	@FXML
	private ImageView imageView_flag;

	@FXML
	private Label label_longitude;

	@FXML
	private Label label_zipCode;

	@FXML
	private Label label_timeZone;

	@FXML
	private Label label_currency;

	@FXML
	private Label label_callingCode;

	@FXML
	private Label label_language;

	@FXML
	private Label label_cityState;

	@FXML
	private Label label_latitude;

	public GridPane getLocationView() {
		return locationView;
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

	public LocationController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LocationView.fxml"));
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

			label_latitude.textProperty().unbindBidirectional(ov.latitudeProperty());
			label_longitude.textProperty().unbindBidirectional(ov.longitudeProperty());
			label_ipLocationPais.textProperty().unbind();
			label_cityState.textProperty().unbind();
			label_language.textProperty().unbind();
			label_callingCode.textProperty().unbind();
			label_zipCode.textProperty().unbind();
			label_timeZone.textProperty().unbind();
			label_currency.textProperty().unbind();
			
			// TODO desbindeo de propiedades
			
		}
		
		if(nv != null) {
						
			label_latitude.textProperty().bindBidirectional(nv.latitudeProperty(), new NumberStringConverter());
			label_longitude.textProperty().bindBidirectional(nv.longitudeProperty(), new NumberStringConverter());
			label_ipLocationPais.textProperty().bind(nv.countryNameProperty().concat(" (")
					.concat(nv.countryCodeProperty().concat(")")));
			imageView_flag.setImage(new Image("/icons/64x42/" + nv.getCountryCode() + ".png"));
			label_cityState.textProperty().bind(nv.cityProperty().concat(" (").concat(nv.regionNameProperty())
					.concat(")"));	
			label_language.textProperty().bind(nv.getLocation().getLanguages().get(0).nameProperty()
					.concat(" (").concat(nv.getLocation().getLanguages().get(0).codeProperty().concat(")")));		
			label_callingCode.textProperty()
			.bind(Bindings.concat("+").concat(nv.getLocation().callingCodeProperty()));
			label_zipCode.textProperty().bind(nv.zipProperty());
			label_timeZone.textProperty().bind(this.setTimezone(nv.getTimezone()));
			label_currency.textProperty().bind(this.setCurrencyCode(nv.getCurrency()));
			
			// TODO bindeo de propiedades
			
		}
		
	}

	private void onCheckIpAction(ActionEvent e){
		
		try {
			ipInfo.set(ipapiCall.getIpBasicData(textField_ipAddress.getText()));
		} catch (JsonProcessingException | UnirestException e1) {
			e1.printStackTrace();
		}

	}

	private StringProperty setTimezone(TimeZone timezoneObj) {

		StringProperty valueReturned = new SimpleStringProperty();

		valueReturned.set("");

		if (timezoneObj == null)
			return valueReturned;

		return timezoneObj.codeProperty();

	}

	private StringProperty setCurrencyCode(Currency currencyObj) {

		StringProperty valueReturned = new SimpleStringProperty();

		valueReturned.set("");

		if (currencyObj == null)
			return valueReturned;

		return currencyObj.codeProperty();
	}

}

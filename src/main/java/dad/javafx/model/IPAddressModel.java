package dad.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class IPAddressModel {

	private StringProperty ipAddress = new SimpleStringProperty();
	
	public final StringProperty IpSalida_ipActualProperty() {
		return this.ipAddress;
	}
	
	public final String getIpSalida_ipActual() {
		return this.IpSalida_ipActualProperty().get();
	}
	
	public final void setIpSalida_ipActual(final String IpSalida_ipActual) {
		this.IpSalida_ipActualProperty().set(IpSalida_ipActual);
	}
	
}

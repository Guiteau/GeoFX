
package dad.javafx.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ip", "hostname", "type", "continent_code", "continent_name", "country_code", "country_name",
		"region_code", "region_name", "city", "zip", "latitude", "longitude", "location", "timezone"

})
public class IPInfo {

	@JsonProperty("ip")
	private StringProperty ip = new SimpleStringProperty();
	@JsonProperty("hostname")
	private StringProperty hostname = new SimpleStringProperty();
	@JsonProperty("type")
	private StringProperty type = new SimpleStringProperty();
	@JsonProperty("continent_code")
	private StringProperty continentCode = new SimpleStringProperty();
	@JsonProperty("continent_name")
	private StringProperty continentName = new SimpleStringProperty();
	@JsonProperty("country_code")
	private StringProperty countryCode = new SimpleStringProperty();
	@JsonProperty("country_name")
	private StringProperty countryName = new SimpleStringProperty();
	@JsonProperty("region_code")
	private StringProperty regionCode = new SimpleStringProperty();
	@JsonProperty("region_name")
	private StringProperty regionName = new SimpleStringProperty();
	@JsonProperty("city")
	private StringProperty city = new SimpleStringProperty();
	@JsonProperty("zip")
	private StringProperty zip = new SimpleStringProperty();
	@JsonProperty("latitude")
	private DoubleProperty latitude = new SimpleDoubleProperty();
	@JsonProperty("longitude")
	private DoubleProperty longitude = new SimpleDoubleProperty();
	@JsonProperty("location")
	private ObjectProperty<Location> location = new SimpleObjectProperty<>();
	@JsonProperty("time_zone")
	private ObjectProperty<TimeZone> timezone = new SimpleObjectProperty<>();
	@JsonProperty("currency")
	private ObjectProperty<Currency> currency = new SimpleObjectProperty<>();
	@JsonProperty("connection")
	private ObjectProperty<Connection> connection = new SimpleObjectProperty<>();
	@JsonProperty("security")
	private ObjectProperty<Security> security = new SimpleObjectProperty<>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IPInfo() {
	}

	/**
	 * 
	 * @param zip
	 * @param city
	 * @param ip
	 * @param regionName
	 * @param latitude
	 * @param type
	 * @param hostname
	 * @param regionCode
	 * @param countryCode
	 * @param location
	 * @param countryName
	 * @param continentName
	 * @param continentCode
	 * @param longitude
	 */
	public IPInfo(String ip, String hostname, String type, String continentCode, String continentName,
			String countryCode, String countryName, String regionCode, String regionName, String city, String zip,
			double latitude, double longitude, Location location, TimeZone timezone, Currency currency,
			Connection connection, Security security) {
		super();
		this.setIp(ip);
		this.setHostname(hostname);
		this.setType(type);
		this.setContinentCode(continentCode);
		this.setContinentName(continentName);
		this.setCountryCode(countryCode);
		this.setCountryName(countryName);
		this.setRegionCode(regionCode);
		this.setRegionName(regionName);
		this.setCity(city);
		this.setZip(zip);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setLocation(location);
		this.setTimezone(timezone);
		this.setCurrency(currency);
		this.setConnection(connection);
		this.setSecurity(security);

	}

	public final ObjectProperty<Currency> currencyProperty() {
		return this.currency;
	}

	public final Currency getCurrency() {
		return this.currencyProperty().get();
	}

	public final void setCurrency(final Currency currency) {
		this.currencyProperty().set(currency);
	}

	public final ObjectProperty<Connection> connectionProperty() {
		return this.connection;
	}

	public final Connection getConnection() {
		return this.connectionProperty().get();
	}

	public final void setConnection(final Connection connection) {
		this.connectionProperty().set(connection);
	}

	public final StringProperty ipProperty() {
		return this.ip;
	}

	public final String getIp() {
		return this.ipProperty().get();
	}

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}

	public final StringProperty hostnameProperty() {
		return this.hostname;
	}

	public final String getHostname() {
		return this.hostnameProperty().get();
	}

	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}

	public final StringProperty typeProperty() {
		return this.type;
	}

	public final String getType() {
		return this.typeProperty().get();
	}

	public final void setType(final String type) {
		this.typeProperty().set(type);
	}

	public final StringProperty continentCodeProperty() {
		return this.continentCode;
	}

	public final String getContinentCode() {
		return this.continentCodeProperty().get();
	}

	public final void setContinentCode(final String continentCode) {
		this.continentCodeProperty().set(continentCode);
	}

	public final StringProperty continentNameProperty() {
		return this.continentName;
	}

	public final String getContinentName() {
		return this.continentNameProperty().get();
	}

	public final void setContinentName(final String continentName) {
		this.continentNameProperty().set(continentName);
	}

	public final StringProperty countryCodeProperty() {
		return this.countryCode;
	}

	public final String getCountryCode() {
		return this.countryCodeProperty().get();
	}

	public final void setCountryCode(final String countryCode) {
		this.countryCodeProperty().set(countryCode);
	}

	public final StringProperty countryNameProperty() {
		return this.countryName;
	}

	public final String getCountryName() {
		return this.countryNameProperty().get();
	}

	public final void setCountryName(final String countryName) {
		this.countryNameProperty().set(countryName);
	}

	public final StringProperty regionCodeProperty() {
		return this.regionCode;
	}

	public final String getRegionCode() {
		return this.regionCodeProperty().get();
	}

	public final void setRegionCode(final String regionCode) {
		this.regionCodeProperty().set(regionCode);
	}

	public final StringProperty regionNameProperty() {
		return this.regionName;
	}

	public final String getRegionName() {
		return this.regionNameProperty().get();
	}

	public final void setRegionName(final String regionName) {
		this.regionNameProperty().set(regionName);
	}

	public final StringProperty cityProperty() {
		return this.city;
	}

	public final String getCity() {
		return this.cityProperty().get();
	}

	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}

	public final StringProperty zipProperty() {
		return this.zip;
	}

	public final String getZip() {
		return this.zipProperty().get();
	}

	public final void setZip(final String zip) {
		this.zipProperty().set(zip);
	}

	public final DoubleProperty latitudeProperty() {
		return this.latitude;
	}

	public final double getLatitude() {
		return this.latitudeProperty().get();
	}

	public final void setLatitude(final double latitude) {
		this.latitudeProperty().set(latitude);
	}

	public final DoubleProperty longitudeProperty() {
		return this.longitude;
	}

	public final double getLongitude() {
		return this.longitudeProperty().get();
	}

	public final void setLongitude(final double longitude) {
		this.longitudeProperty().set(longitude);
	}

	public final ObjectProperty<Location> locationProperty() {
		return this.location;
	}

	public final Location getLocation() {
		return this.locationProperty().get();
	}

	public final void setLocation(final Location location) {
		this.locationProperty().set(location);
	}

	public final ObjectProperty<TimeZone> timezoneProperty() {
		return this.timezone;
	}

	public final TimeZone getTimezone() {
		return this.timezoneProperty().get();
	}

	public final void setTimezone(final TimeZone timezone) {
		this.timezoneProperty().set(timezone);
	}

	public final ObjectProperty<Security> securityProperty() {
		return this.security;
	}

	public final Security getSecurity() {
		return this.securityProperty().get();
	}

	public final void setSecurity(final Security security) {
		this.securityProperty().set(security);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public IPInfo withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("ip", ip).append("hostname", hostname).append("type", type)
				.append("continentCode", continentCode).append("continentName", continentName)
				.append("countryCode", countryCode).append("countryName", countryName).append("regionCode", regionCode)
				.append("regionName", regionName).append("city", city).append("zip", zip).append("latitude", latitude)
				.append("longitude", longitude).append("location", location)
				.append("additionalProperties", additionalProperties).toString();
	}

}

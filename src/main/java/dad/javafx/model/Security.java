
package dad.javafx.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "is_proxy", "proxy_type", "is_crawler", "crawler_name", "crawler_type", "is_tor", "threat_level",
		"threat_types" })
public class Security {

	@JsonProperty("is_proxy")
	private BooleanProperty isProxy = new SimpleBooleanProperty();
	@JsonProperty("proxy_type")
	private ObjectProperty<Object> proxyType = new SimpleObjectProperty<>();
	@JsonProperty("is_crawler")
	private BooleanProperty isCrawler = new SimpleBooleanProperty();
	@JsonProperty("crawler_name")
	private ObjectProperty<Object> crawlerName = new SimpleObjectProperty<>();
	@JsonProperty("crawler_type")
	private ObjectProperty<Object> crawlerType = new SimpleObjectProperty<>();
	@JsonProperty("is_tor")
	private BooleanProperty isTor = new SimpleBooleanProperty();
	@JsonProperty("threat_level")
	private StringProperty threatLevel = new SimpleStringProperty();
	@JsonProperty("threat_types")
	private ObjectProperty<Object> threatTypes = new SimpleObjectProperty<>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Security() {
	}

	/**
	 * 
	 * @param isTor
	 * @param threatTypes
	 * @param crawlerType
	 * @param proxyType
	 * @param crawlerName
	 * @param isCrawler
	 * @param isProxy
	 * @param threatLevel
	 */
	public Security(boolean isProxy, Object proxyType, boolean isCrawler, Object crawlerName, Object crawlerType,
			boolean isTor, String threatLevel, Object threatTypes) {
		super();
		this.setIsProxy(isProxy);
		this.setProxyType(proxyType);
		this.setIsCrawler(isCrawler);
		this.setCrawlerName(crawlerName);
		this.setCrawlerType(crawlerType);
		this.setIsTor(isTor);
		this.setThreatLevel(threatLevel);
		this.setThreatTypes(threatTypes);

	}

	public final BooleanProperty isProxyProperty() {
		return this.isProxy;
	}

	public final boolean isIsProxy() {
		return this.isProxyProperty().get();
	}

	public final void setIsProxy(final boolean isProxy) {
		this.isProxyProperty().set(isProxy);
	}

	public final ObjectProperty<Object> proxyTypeProperty() {
		return this.proxyType;
	}

	public final Object getProxyType() {
		return this.proxyTypeProperty().get();
	}

	public final void setProxyType(final Object proxyType) {
		this.proxyTypeProperty().set(proxyType);
	}

	public final BooleanProperty isCrawlerProperty() {
		return this.isCrawler;
	}

	public final boolean isIsCrawler() {
		return this.isCrawlerProperty().get();
	}

	public final void setIsCrawler(final boolean isCrawler) {
		this.isCrawlerProperty().set(isCrawler);
	}

	public final ObjectProperty<Object> crawlerNameProperty() {
		return this.crawlerName;
	}

	public final Object getCrawlerName() {
		return this.crawlerNameProperty().get();
	}

	public final void setCrawlerName(final Object crawlerName) {
		this.crawlerNameProperty().set(crawlerName);
	}

	public final ObjectProperty<Object> CrawlerTypeProperty() {
		return this.crawlerType;
	}

	public final Object getCrawlerType() {
		return this.CrawlerTypeProperty().get();
	}

	public final void setCrawlerType(final Object CrawlerType) {
		this.CrawlerTypeProperty().set(CrawlerType);
	}

	public final BooleanProperty isTorProperty() {
		return this.isTor;
	}

	public final boolean isIsTor() {
		return this.isTorProperty().get();
	}

	public final void setIsTor(final boolean isTor) {
		this.isTorProperty().set(isTor);
	}

	public final StringProperty threatLevelProperty() {
		return this.threatLevel;
	}

	public final String getThreatLevel() {
		return this.threatLevelProperty().get();
	}

	public final void setThreatLevel(final String threatLevel) {
		this.threatLevelProperty().set(threatLevel);
	}

	public final ObjectProperty<Object> threatTypesProperty() {
		return this.threatTypes;
	}

	public final Object getThreatTypes() {
		return this.threatTypesProperty().get();
	}

	public final void setThreatTypes(final Object threatTypes) {
		this.threatTypesProperty().set(threatTypes);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Security withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("isProxy", isProxy).append("proxyType", proxyType)
				.append("isCrawler", isCrawler).append("crawlerName", crawlerName).append("crawlerType", crawlerType)
				.append("isTor", isTor).append("threatLevel", threatLevel).append("threatTypes", threatTypes)
				.append("additionalProperties", additionalProperties).toString();
	}

}

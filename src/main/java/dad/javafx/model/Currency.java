
package dad.javafx.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "name",
    "plural",
    "symbol",
    "symbol_native"
})
public class Currency {

    @JsonProperty("code")
    private StringProperty code = new SimpleStringProperty();
    @JsonProperty("name")
    private String name;
    @JsonProperty("plural")
    private String plural;
    @JsonProperty("symbol")
    private StringProperty symbol = new SimpleStringProperty();
    @JsonProperty("symbol_native")
    private String symbolNative;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Currency() {
    }

    /**
     * 
     * @param symbol
     * @param code
     * @param plural
     * @param symbolNative
     * @param name
     */
    public Currency(String code, String name, String plural, String symbol, String symbolNative) {
        super();
        this.setCode(code); 
        this.name = name;
        this.plural = plural;
        this.setSymbol(symbol);
        this.symbolNative = symbolNative;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Currency withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("plural")
    public String getPlural() {
        return plural;
    }

    @JsonProperty("plural")
    public void setPlural(String plural) {
        this.plural = plural;
    }

    public Currency withPlural(String plural) {
        this.plural = plural;
        return this;
    }

    @JsonProperty("symbol_native")
    public String getSymbolNative() {
        return symbolNative;
    }

    @JsonProperty("symbol_native")
    public void setSymbolNative(String symbolNative) {
        this.symbolNative = symbolNative;
    }

    public Currency withSymbolNative(String symbolNative) {
        this.symbolNative = symbolNative;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Currency withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("name", name).append("plural", plural).append("symbol", symbol).append("symbolNative", symbolNative).append("additionalProperties", additionalProperties).toString();
    }

	public final StringProperty codeProperty() {
		return this.code;
	}
	

	public final String getCode() {
		return this.codeProperty().get();
	}
	

	public final void setCode(final String code) {
		this.codeProperty().set(code);
	}
	

	public final StringProperty symbolProperty() {
		return this.symbol;
	}
	

	public final String getSymbol() {
		return this.symbolProperty().get();
	}
	

	public final void setSymbol(final String symbol) {
		this.symbolProperty().set(symbol);
	}
	

}

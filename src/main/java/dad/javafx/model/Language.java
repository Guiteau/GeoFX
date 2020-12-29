
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
    "native"
})
public class Language {

    @JsonProperty("code")
    private StringProperty code = new SimpleStringProperty();
    @JsonProperty("name")
    private StringProperty name = new SimpleStringProperty();
    @JsonProperty("native")
    private StringProperty _native = new SimpleStringProperty();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Language() {
    }

    /**
     * 
     * @param code
     * @param _native
     * @param name
     */
    public Language(String code, String name, String _native) {
        super();
        this.setCode(code.toUpperCase());
        this.setName(name);
        this.set_native(_native);
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
	

	public final StringProperty nameProperty() {
		return this.name;
	}
	

	public final String getName() {
		return this.nameProperty().get();
	}
	

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	

	public final StringProperty _nativeProperty() {
		return this._native;
	}
	

	public final String get_native() {
		return this._nativeProperty().get();
	}
	

	public final void set_native(final String _native) {
		this._nativeProperty().set(_native);
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Language withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("name", name).append("_native", _native).toString();
    }
}

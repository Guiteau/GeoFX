
package dad.javafx.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "asn",
    "isp"
})
public class Connection {

    @JsonProperty("asn")
    private LongProperty asn = new SimpleLongProperty();
    @JsonProperty("isp")
    private StringProperty isp = new SimpleStringProperty();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Connection() {
    }

    /**
     * 
     * @param isp
     * @param asn
     */
    public Connection(long asn, String isp) {
        super();
        this.setAsn(asn);
        this.setIsp(isp);
    }

	public final LongProperty asnProperty() {
		return this.asn;
	}
	
	public final long getAsn() {
		return this.asnProperty().get();
	}
	
	public final void setAsn(final long asn) {
		this.asnProperty().set(asn);
	}

	public final StringProperty ispProperty() {
		return this.isp;
	}

	public final String getIsp() {
		return this.ispProperty().get();
	}
	
	public final void setIsp(final String isp) {
		this.ispProperty().set(isp);
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Connection withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("asn", asn).append("isp", isp).append("additionalProperties", additionalProperties).toString();
    }

}

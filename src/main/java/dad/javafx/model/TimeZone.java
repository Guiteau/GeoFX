
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
    "id",
    "current_time",
    "gmt_offset",
    "code",
    "is_daylight_saving"
})
public class TimeZone {

    @JsonProperty("id")
    private String id;
    @JsonProperty("current_time")
    private String currentTime;
    @JsonProperty("gmt_offset")
    private long gmtOffset;
    @JsonProperty("code")
    private StringProperty code = new SimpleStringProperty();
    @JsonProperty("is_daylight_saving")
    private boolean isDaylightSaving;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeZone() {
    }

    /**
     * 
     * @param currentTime
     * @param code
     * @param isDaylightSaving
     * @param gmtOffset
     * @param id
     */
    public TimeZone(String id, String currentTime, long gmtOffset, String code, boolean isDaylightSaving) {
        super();
        this.id = id;
        this.currentTime = currentTime;
        this.gmtOffset = gmtOffset;
        this.setCode(code);
        this.isDaylightSaving = isDaylightSaving;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public TimeZone withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("current_time")
    public String getCurrentTime() {
        return currentTime;
    }

    @JsonProperty("current_time")
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public TimeZone withCurrentTime(String currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    @JsonProperty("gmt_offset")
    public long getGmtOffset() {
        return gmtOffset;
    }

    @JsonProperty("gmt_offset")
    public void setGmtOffset(long gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public TimeZone withGmtOffset(long gmtOffset) {
        this.gmtOffset = gmtOffset;
        return this;
    }


    @JsonProperty("is_daylight_saving")
    public boolean isIsDaylightSaving() {
        return isDaylightSaving;
    }

    @JsonProperty("is_daylight_saving")
    public void setIsDaylightSaving(boolean isDaylightSaving) {
        this.isDaylightSaving = isDaylightSaving;
    }

    public TimeZone withIsDaylightSaving(boolean isDaylightSaving) {
        this.isDaylightSaving = isDaylightSaving;
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

    public TimeZone withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("currentTime", currentTime).append("gmtOffset", gmtOffset).append("code", code).append("isDaylightSaving", isDaylightSaving).append("additionalProperties", additionalProperties).toString();
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
	

}

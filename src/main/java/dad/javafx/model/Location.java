
package dad.javafx.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "geoname_id",
    "capital",
    "languages",
    "country_flag",
    "country_flag_emoji",
    "country_flag_emoji_unicode",
    "calling_code",
    "is_eu"
})
public class Location {

    @JsonProperty("geoname_id")
	private LongProperty geonameId = new SimpleLongProperty();
    @JsonProperty("capital")
	private StringProperty capital = new SimpleStringProperty();
    @JsonProperty("languages")
	private List<Language> languages = null;
    @JsonProperty("country_flag")
	private StringProperty countryFlag = new SimpleStringProperty();
    @JsonProperty("country_flag_emoji")
	private StringProperty countryFlagEmoji = new SimpleStringProperty();
    @JsonProperty("country_flag_emoji_unicode")
	private StringProperty countryFlagEmojiUnicode = new SimpleStringProperty();
    @JsonProperty("calling_code")
	private StringProperty callingCode = new SimpleStringProperty();
    @JsonProperty("is_eu")
	private BooleanProperty isEu = new SimpleBooleanProperty();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param callingCode
     * @param capital
     * @param countryFlagEmoji
     * @param languages
     * @param geonameId
     * @param countryFlag
     * @param countryFlagEmojiUnicode
     * @param isEu
     */
    public Location(long geonameId, String capital, List<Language> languages, String countryFlag, String countryFlagEmoji, String countryFlagEmojiUnicode, String callingCode, boolean isEu) {
        super();
        this.setGeonameId(geonameId);
		this.setCapital(capital);
		this.languages = languages;
		this.setCountryFlag(countryFlag);
		this.setCountryFlagEmoji(countryFlagEmoji);
		this.setCountryFlagEmojiUnicode(countryFlagEmojiUnicode);
		this.setCallingCode(callingCode);
		this.setIsEu(isEu);
    }

	public final LongProperty geonameIdProperty() {
		return this.geonameId;
	}

	public final long getGeonameId() {
		return this.geonameIdProperty().get();
	}

	public final void setGeonameId(final long geonameId) {
		this.geonameIdProperty().set(geonameId);
	}

	public final StringProperty capitalProperty() {
		return this.capital;
	}

	public final String getCapital() {
		return this.capitalProperty().get();
	}

	public final void setCapital(final String capital) {
		this.capitalProperty().set(capital);
	}

	public final StringProperty countryFlagProperty() {
		return this.countryFlag;
	}

	public final String getCountryFlag() {
		return this.countryFlagProperty().get();
	}

	public final void setCountryFlag(final String countryFlag) {
		this.countryFlagProperty().set(countryFlag);
	}

	public final StringProperty countryFlagEmojiProperty() {
		return this.countryFlagEmoji;
	}

	public final String getCountryFlagEmoji() {
		return this.countryFlagEmojiProperty().get();
	}

	public final void setCountryFlagEmoji(final String countryFlagEmoji) {
		this.countryFlagEmojiProperty().set(countryFlagEmoji);
	}

	public final StringProperty countryFlagEmojiUnicodeProperty() {
		return this.countryFlagEmojiUnicode;
	}

	public final String getCountryFlagEmojiUnicode() {
		return this.countryFlagEmojiUnicodeProperty().get();
	}

	public final void setCountryFlagEmojiUnicode(final String countryFlagEmojiUnicode) {
		this.countryFlagEmojiUnicodeProperty().set(countryFlagEmojiUnicode);
	}

	public final StringProperty callingCodeProperty() {
		return this.callingCode;
	}

	public final String getCallingCode() {
		return this.callingCodeProperty().get();
	}

	public final void setCallingCode(final String callingCode) {
		this.callingCodeProperty().set(callingCode);
	}

	public final BooleanProperty isEuProperty() {
		return this.isEu;
	}

	public final boolean isIsEu() {
		return this.isEuProperty().get();
	}

	public final void setIsEu(final boolean isEu) {
		this.isEuProperty().set(isEu);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("geonameId", geonameId).append("capital", capital)
				.append("languages", languages).append("countryFlag", countryFlag)
				.append("countryFlagEmoji", countryFlagEmoji).append("countryFlagEmojiUnicode", countryFlagEmojiUnicode)
				.append("callingCode", callingCode).append("isEu", isEu).toString();
	}

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Location withLanguages(List<Language> languages) {
        this.languages = languages;
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

    public Location withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}

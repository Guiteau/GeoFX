package dad.javafx.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.model.IPInfo;

public class IPapi_service {
	
	@JsonIgnoreProperties(ignoreUnknown = true)

	ObjectMapper objectMapper;
	
	public IPapi_service() {
		
		objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	}
	
	public IPInfo getIpBasicData (String ip) throws UnirestException, JsonMappingException, JsonProcessingException {
		
		String response;
		
		response = Unirest
				.get("http://api.ipapi.com/"+ip)
				.queryString("access_key", "d9b461864a63c0166b5abb57edf8425c")
				.queryString("hostname", "1")
				.queryString("format", "1")
				.asString()
				.getBody();
	
		return objectMapper.readValue(response, IPInfo.class);
		
	}
	
	public String getStringBulk(String ip) throws UnirestException, JsonMappingException, JsonProcessingException {
		
		String response;
		
		response = Unirest
				.get("http://api.ipapi.com/"+ip)
				.queryString("access_key", "d9b461864a63c0166b5abb57edf8425c")
				.queryString("hostname", "1")
				.queryString("format", "1")
				.asString()
				.getBody();
	
		return response;
		
	}

}

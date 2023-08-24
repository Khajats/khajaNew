package ajith;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherEntry {
	
	    private long dt;
	    private MainData main;
	    @JsonDeserialize(using = WeatherListDeserializer.class)
	    @JsonAlias("weather")
	    private List<Weather1> weather;
	    private Clouds clouds;
	    private Wind wind;
	    private Sys sys;
	    private String dt_txt;

}

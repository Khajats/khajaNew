package ajith;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather1 {
	    private int id;
	    private String main;
	    private String description;
	    @JsonAlias("icon")
	    private String icon;
	    
//	    @JsonCreator
//	    public Weather(
//	            @JsonProperty("id") int id,
//	            @JsonProperty("main") String main,
//	            @JsonProperty("description") String description,
//	            @JsonProperty("icon") String icon) {
//	        this.id = id;
//	        this.main = main;
//	        this.description = description;
//	        this.icon = icon;
//	    }
	    
	 


}

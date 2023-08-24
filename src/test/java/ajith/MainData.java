package ajith;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainData {
	    private double temp;
	    private double temp_min;
	    private double temp_max;
	    private double pressure;
	    private double sea_level;
	    private double grnd_level;
	    private int humidity;
	    private double temp_kf;

}

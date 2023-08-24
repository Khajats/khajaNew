package ajith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class WeatherListDeserializer extends StdDeserializer<List<Weather1>> {
	
	
	public WeatherListDeserializer() {
		super(ArrayList.class); // We specify the target type as ArrayList
	}

	@Override
	public List<Weather1> deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		List<Weather1> weatherList = new ArrayList<>();
		JsonNode node = parser.getCodec().readTree(parser);
		if (node.isArray()) {
			for (JsonNode weatherNode : node) {
				int id = weatherNode.get("id").asInt();
				String main = weatherNode.get("main").asText();
				String description = weatherNode.get("description").asText();
				String icon = weatherNode.get("icon").asText();

				Weather1 weather = new Weather1(id, main, description, icon);
				weatherList.add(weather);
			}
		}
		return weatherList;
	}
}

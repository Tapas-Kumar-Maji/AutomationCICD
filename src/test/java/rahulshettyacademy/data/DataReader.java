package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) {

//		Getting JSON data as List
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(jsonFilePath), new TypeReference<List<HashMap<String, String>>>() {
			});
		} catch (IOException e) {
			System.out.println(this.getClass().getSimpleName() + ": Json file not read");
			e.printStackTrace();
		}
		return null;
	}
}

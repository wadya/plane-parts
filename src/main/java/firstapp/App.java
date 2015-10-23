package firstapp;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static firstapp.Utilites.*;

/**
 * Java console application that manages parts of a plane
 */
public class App {
	public static void main(String[] args) {

		try {

			Map<String, Object> obj = new Gson().fromJson(new FileReader("resources/data.json"),
					new TypeToken<HashMap<String, Object>>() {
					}.getType());

			LinkedHashMap<String, HashMap<String, Integer>> data =
					convertJsonObjectToMap(obj.get("allparts"));

			String mainObjectName = (String) obj.get("plane");

//			part a
			showTree(data, mainObjectName, "", 0, "key");

//			part b
			showTree(data, mainObjectName, "", 0, "value");

//			part d
			findPart(data, "Bolt");

//			part c
			removePart(data, "Engine");
			showTree(data, mainObjectName, "", 0, "key");

//			part e
			addPart(data, "Engine", 2, "Plane");
			addPart(data, "Air Intake", 1, "Engine");
			addPart(data, "Flywheel", 2, "Engine");
			addPart(data, "Bolt", 100, "Engine");
			showTree(data, mainObjectName, "", 0, "key");

//			part f
			addPart(data, "Bolt", 100, "Engine");
			showTree(data, mainObjectName, "", 0, "key");

//			part g
			renamePart(data, "Bolt", "BOLT");
			showTree(data, mainObjectName, "", 0, "key");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (JsonIOException e) {

			e.printStackTrace();
		} catch (JsonSyntaxException e) {

			e.printStackTrace();
		}
	}
}
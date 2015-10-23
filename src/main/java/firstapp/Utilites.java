package firstapp;

import com.google.gson.internal.LinkedTreeMap;

import java.util.*;

/**
 * Created by Vadym Polishchuk on 10/23/15.
 * wadyasha@gmail.com
 */
public class Utilites {

	public static void renamePart(LinkedHashMap<String, HashMap<String, Integer>> data, String oldName, String newName) {


		data.put(newName, new HashMap<String, Integer>());
		for (Map.Entry<String, HashMap<String, Integer>> parts : data.entrySet()) {

			if (parts.getValue().get(oldName) != null) {

				parts.getValue().put(newName, parts.getValue().get(oldName));
			}
		}
		removePart(data, oldName);
	}

	public static void addPart(LinkedHashMap<String, HashMap<String, Integer>> data, String part, Integer amount, String parentPart) {

		HashMap<String, Integer> pPart = data.get(parentPart);

		if (pPart != null) {

			HashMap<String, Integer> nPart = data.get(part);

			if (nPart == null) {

				data.put(part, new HashMap<String, Integer>());
			}

			Integer subPartAmount = pPart.get(part);
			if (subPartAmount != null) {

				pPart.put(part, subPartAmount + amount);
			} else {

				pPart.put(part, amount);
			}
		}
	}

	public static void findPart(LinkedHashMap<String, HashMap<String, Integer>> data, String part) {

		String result = "";

		for (Map.Entry<String, HashMap<String, Integer>> parts : data.entrySet()) {

			if (parts.getValue().get(part) != null) {

				result += " \"" + parts.getKey()+"\"";
			}
		}
		if (result.length() > 0) {

			System.out.println(part + " is present under: " + result);
		}
	}

	public static void removePart(LinkedHashMap<String, HashMap<String, Integer>> data, String part) {

		for (HashMap<String, Integer> parts : data.values()) {

			parts.remove(part);
		}
		data.remove(part);
	}

	public static LinkedHashMap<String, HashMap<String, Integer>>
	convertJsonObjectToMap(Object obj) {

		LinkedHashMap<String, HashMap<String, Integer>> parts =
				new LinkedHashMap<String, HashMap<String, Integer>>();

		for (Object item : ((LinkedTreeMap) obj).entrySet()) {

			String name = (String) ((Map.Entry) item).getKey();

			HashMap<String, Integer> part = new HashMap<String, Integer>();
			for (Object subItem : ((LinkedTreeMap) ((Map.Entry) item).getValue()).entrySet()) {

				String subName = (String) ((Map.Entry) subItem).getKey();
				Integer amount = ((Double) ((Map.Entry) subItem).getValue()).intValue();
				part.put(subName, amount);
			}
			parts.put(name, part);
		}

		return parts;
	}

	public static void showTree(LinkedHashMap<String, HashMap<String, Integer>> allParts,
								String partName, String prefix, Integer count, String sortType) {

		System.out.println(prefix + partName + (count > 0 ? " x" + count : ""));
		prefix = prefix + "	";

		HashMap<String, Integer> parts = allParts.get(partName);

		if (sortType.equals("key")) {

			parts = (HashMap<String, Integer>) sortMapByKey(allParts.get(partName));
		} else if (sortType.equals("value")) {

			parts = (HashMap<String, Integer>) sortMapByValue(allParts.get(partName));
		}

		for (Map.Entry<String, Integer> item : parts.entrySet()) {

			String name = item.getKey();
			Integer itemCount = item.getValue();
			showTree(allParts, name, prefix, itemCount, sortType);
		}

	}

	public static <K, V extends Comparable<? super V>> Map<K, V>
	sortMapByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list =
				new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			//			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V>
	sortMapByKey(Map<K, V> map) {
		Map<K, V> sortedMap = new TreeMap<K, V>(map);

		return new LinkedHashMap<K, V>(sortedMap);
	}
}

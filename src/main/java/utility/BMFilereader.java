package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class BMFilereader {

	private static Properties property = new Properties();
	//private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private BMFilereader() {}

	static {
		try (FileInputStream file = new FileInputStream(
				"E:\\Practice\\2021\\praticeMay21\\TestNG\\src\\test\\resources\\Testdata\\config.properties")) {
			property.load(file);
			/*
			 * for (Map.Entry<Object, Object> entry : property.entrySet()) {
			 * CONFIGMAP.put(String.valueOf(entry.getKey()),
			 * String.valueOf(entry.getValue()).trim()); // remove the // trailing and //
			 * leading // spaces }
			 */
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String getValue(String key) {
		if (Objects.isNull(key) || Objects.isNull(property.getProperty(key.toLowerCase()) )){
			
		}
		return property.getProperty(key.toLowerCase());
	}
}

package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import enums.ConfigProperties;
import exceptions.PropertyFileException;

import constants.FrameworkConstants;

public final class PropertyUtlis {
	
	private PropertyUtlis() {

	}

	private static Properties property= new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<>();

	static {
		//try with resources
		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath()); BufferedInputStream bfis=new BufferedInputStream(file)){
			property.load(file);
			
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces		
			}
			//property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		} catch (Exception e ) {
			//throw new InvalidPathForPropertyFileException("Please check the Path of the config.properties file");
			e.printStackTrace();
			System.exit(0);
		} 	
	}
	
	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileException("Property name "+ key +" is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	//Hashtable -- little slow, thread safe
	public static String getValue(String key){
		
		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new PropertyFileException("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return property.getProperty(key);		
	}

}

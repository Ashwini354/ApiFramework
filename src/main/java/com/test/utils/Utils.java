package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.test.constant.SourcePath;

public class Utils {
	static Properties prop = null;

	public static Properties loadProperties() {
		try {
			if (prop == null) {
				FileInputStream input = new FileInputStream(SourcePath.CONFIG);
				prop = new Properties();
				// load a properties file
				prop.load(input);
			}
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String getValues(String key) {
		return loadProperties().getProperty(key);
	}
}

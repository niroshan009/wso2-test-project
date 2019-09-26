package com.niroshan.support;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ResourceFileLoader {
	private static final String RESOURCE_DIR = "src/test/resources/testfiles/";

	public static String readResourceContent(String filename) throws IOException {
		File file = new File(RESOURCE_DIR + filename);
		return FileUtils.readFileToString(file, "UTF-8");
	}
}

/**
 *
 * har - HAR file reader, writer and viewer
 * Copyright (c) 2014, Sandeep Gupta
 * 
 * http://sangupta.com/projects/har
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.har;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FileUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.sangupta.har.model.Har;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.CheckUtils;
import com.sangupta.jerry.util.GsonUtils;

/**
 * Utility class for working with HAR files.
 * 
 * @author sangupta
 *
 */
public class HarUtils {
	
	/**
	 * Read the HAR file and create an {@link Har} model instance from the same.
	 * 
	 * @param file
	 *            the file to be read
	 * 
	 * @return the {@link Har} instance
	 * 
	 * @throws JsonSyntaxException
	 *             if the JSON is not well formed
	 * 
	 * @throws IOException
	 *             if reading the file fails
	 * 
	 * @throws IllegalArgumentException
	 *             if the file does not exist, is a directory or is not a valid
	 *             file
	 */
	public static Har read(File file) throws JsonSyntaxException, IOException {
		CheckUtils.checkFileExists(file);
		
		return GsonUtils.getGson().fromJson(FileUtils.readFileToString(file), Har.class);
	}
	
	
	public static Har read(String harJson) throws JsonSyntaxException, IOException {
		if(AssertUtils.isEmpty(harJson)) {
			throw new IllegalArgumentException("HAR Json cannot be null/empty");
		}
		
		return GsonUtils.getGson().fromJson(harJson, Har.class);
	}
	
	public static Har read(Reader harReader) throws JsonSyntaxException, IOException {
		if(harReader == null) {
			throw new IllegalArgumentException("HAR reader cannot be null");
		}
		
		return GsonUtils.getGson().fromJson(harReader, Har.class);
	}
	
	public static Har read(JsonElement jsonElement) throws JsonSyntaxException, IOException {
		if(jsonElement == null) {
			throw new IllegalArgumentException("HAR JsonElement cannot be null");
		}
		
		return GsonUtils.getGson().fromJson(jsonElement, Har.class);
	}

}

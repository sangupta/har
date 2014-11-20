package com.sangupta.har;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.sangupta.har.model.Har;

public class HarTest {

	public static void main(String[] args) throws JsonSyntaxException, IOException {
		File file = new File("/Users/sangupta/Desktop/stage.aedash.adobe.com.har");
		Har har = HarUtils.readFile(file);
		System.out.println("created by: " + har.log.creator.name);
	}
	
}

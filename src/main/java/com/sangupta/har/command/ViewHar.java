package com.sangupta.har.command;

import java.io.File;

import com.sangupta.har.HarUtils;
import com.sangupta.har.model.Har;
import com.sangupta.jerry.util.AssertUtils;

import io.airlift.command.Arguments;
import io.airlift.command.Command;

@Command(name = "view", description = "View HAR file")
public class ViewHar implements Runnable {
	
	@Arguments
	private String file;

	@Override
	public void run() {
		Har har = null;
		
		try {
			har = HarUtils.read(new File(this.file));
		} catch(Exception e) {
			System.out.println("Error reading HAR file: " + e.getMessage());
			return;
		}
		
		if(har.log == null || AssertUtils.isEmpty(har.log.pages)) {
			System.out.println("HAR file has no pages!");
			return;
		}
		
		System.out.println("Number of pages viewed: " + har.log.pages.size());
	}

}

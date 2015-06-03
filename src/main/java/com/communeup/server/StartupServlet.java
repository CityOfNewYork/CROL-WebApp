package com.communeup.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.logging.LogManager;

import javax.servlet.http.HttpServlet;

public class StartupServlet extends HttpServlet {

	private static final long serialVersionUID = -6910962661146512793L;

	@Override
	public void init() {
		InputStream logCommonFile = getClass().getResourceAsStream("logging.properties");

		try {
			LogManager logManager = java.util.logging.LogManager.getLogManager();
			if (logCommonFile != null) {
				InputStream configFile = logCommonFile;
				if (configFile != null) {
					logManager.readConfiguration(configFile);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

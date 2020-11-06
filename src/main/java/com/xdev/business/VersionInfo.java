package com.xdev.business;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VersionInfo
{
	private static final Logger LOG = LoggerFactory.getLogger(VersionInfo.class);
	
	private static final String FILE_NAME = "version.properties";
	
	private static final String PROPERTY_VERSION = "version";
	private static final String PROPERTY_BUILD_NUMBER = "buildNumber";
	

	private static VersionInfo instance = null;
	
	private final Properties properties = new Properties();
	
	private VersionInfo()
	{
		final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		
		if(stream == null)
		{
			throw new RuntimeException("VersionFile is not found!");
		}
		try
		{
			// Loading File into Properties Object
			this.properties.load(stream);
			LOG.debug("Successfully loaded Version Property: {}", this.properties.get(PROPERTY_VERSION));
		}
		catch(final IOException e)
		{
			LOG.error("Error while reading Version-File", e);
			throw new RuntimeException(e);
		}
	}
	
	public static VersionInfo getInstance()
	{
		if(instance == null)
		{
			instance = new VersionInfo();
		}
		
		return instance;
	}
	
	public String getVersion()
	{
		return this.properties.getProperty(PROPERTY_VERSION);
	}
	
	public String getBuildNumber()
	{
		return this.properties.getProperty(PROPERTY_BUILD_NUMBER);
	}
}

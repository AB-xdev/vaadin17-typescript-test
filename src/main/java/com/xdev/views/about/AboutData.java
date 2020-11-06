package com.xdev.views.about;

public class AboutData
{
	private final String version;
	private final String buildNumber;

	public AboutData(final String version, final String buildNumber)
	{
		this.version = version;
		this.buildNumber = buildNumber;
	}

	public String getVersion()
	{
		return this.version;
	}

	public String getBuildNumber()
	{
		return this.buildNumber;
	}
}

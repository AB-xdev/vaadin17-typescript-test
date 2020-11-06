package com.xdev.views.about;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;
import com.xdev.business.VersionInfo;


/**
 * The endpoint for the client-side view.
 */
@Endpoint(value = "about")
@AnonymousAllowed
public class AboutEndpoint
{
	private static final VersionInfo versionInfo = VersionInfo.getInstance();
	
	public AboutData get()
	{
		return new AboutData(versionInfo.getVersion(), versionInfo.getBuildNumber());
	}
}

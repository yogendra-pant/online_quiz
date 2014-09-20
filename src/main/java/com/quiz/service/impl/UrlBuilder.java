package com.quiz.service.impl;

import java.text.MessageFormat;

public class UrlBuilder {

	private final String webHost;

	public UrlBuilder(String webHost) {
		this.webHost = webHost;
	}

	public String getActivateUrl(String uuid) {
		return MessageFormat.format("{0}/activate/{1}", webHost, uuid);
	}

	public String getWebHostWithoutProtocol() {
		return webHost;
	}

	public String getWebHost() {
		return webHost;
	}

	public String getRecoveryUrl(String activationId) {
		return MessageFormat.format("{0}/{1}?ticket={2}", webHost, "recover", activationId);
	}

}

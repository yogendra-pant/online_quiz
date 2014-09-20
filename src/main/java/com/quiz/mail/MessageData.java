package com.quiz.mail;


import java.util.Locale;
import java.util.Map;
import org.springframework.core.io.Resource;




public class MessageData {
	private final Map<String, Object> objects = GenericsUtils.newMap();
	private final Map<String, Resource> resources = GenericsUtils.newMap();

	private String senderMail;
	private String senderName;
	private Locale locale;
	private String recipientName;
	private Object[] subjectParams = new Object[0];

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Map<String, Object> getObjects() {
		return objects;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public Map<String, Resource> getResources() {
		return resources;
	}

	public String getSenderMail() {
		return senderMail;
	}

	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Object[] getSubjectParams() {
		return subjectParams;
	}

	public void setSubjectParams(Object[] subjectParams) {
		this.subjectParams = subjectParams;
	}
}

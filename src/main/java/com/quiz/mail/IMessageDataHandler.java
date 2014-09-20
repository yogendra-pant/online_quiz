package com.quiz.mail;

import java.util.Map;

import org.springframework.context.MessageSource;


public interface IMessageDataHandler {
	/**
	 * This method is called before a message is sent to the recipient.
	 *
	 * @param templateName the name of the template
	 * @param emailAddress the mail address of the receiver
	 * @param properties optional properties to identify the exact message
	 * @return the {@link MessageData} object that contains all the required information to send a
	 *         mail
	 */
	MessageData getData(String templateName, String emailAddress, Map<String, String> properties);

	MessageSource getMessageSource();

	/**
	 * @return an array of all templates that are supported by this {@link IMessageDataHandler}
	 */
	String[] getSupportedTemplates();

	/**
	 * This method is called after an error during sending the message.
	 *
	 * @param templateName the name of the template
	 * @param emailAddress the mail address this message was sent to
	 * @param properties optional properties to identify the exact message
	 * @param ex Exception
	 */
	void messageError(String templateName, String emailAddress, Map<String, String> properties, Exception ex);

	/**
	 * This method is called after a message has been successfully handed over to the mailserver.
	 * This does not necessarily mean that it was successfully delivered to the recipient.
	 *
	 * @param templateName the name of the template
	 * @param emailAddress the mail address this message was sent to
	 * @param properties optional properties to identify the exact message
	 */
	void messageSent(String templateName, String emailAddress, Map<String, String> properties);
}

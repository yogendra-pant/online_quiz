package com.quiz.mail;

import java.util.Map;

public interface IMailJobService {

	/**
	 * @deprecated use {@link #scheduleMail(String, String, String, Map)}
	 */
	@Deprecated
	void sendMail(String templateName, String emailAddress, Map<String, String> properties);

	/**
	 * Schedules a mail to be sent after the current transaction. Job processing is included,
	 * meaning that the mail is automatically resent if an error occurs
	 *
	 * @param templateName the name of the email template for the template engine
	 * @param emailAddress the recipient of the mail
	 * @param reference an externally managed identifier that allows to correlate the mailjob with its origin
	 * @param properties properties to be injected into the template
	 */
	void scheduleMail(String templateName, String emailAddress, String reference, Map<String, String> properties);

	/**
	 * Sends the mail with the given templateName immediately. No Job processing in between, the
	 * mail is also not automatically resent for the case that errors occured (e.g. the mail server
	 * is not reachable).
	 *
	 * @param templateName the name of the email template for the template engine
	 * @param emailAddress the recipient of the mail
	 * @param properties properties to be injected into the template
	 * @throws Exception any kind of exception, e.g. from the mail server if it is not reachable
	 */
	void sendMailNow(String templateName, String emailAddress, Map<String, String> properties) throws Exception;

	/**
	 * Sends the mail with the given templateName immediately. No Job processing in between, the
	 * mail is also not automatically resent for the case that errors occured (e.g. the mail server
	 * is not reachable).
	 *
	 * @param templateName the name of the email template for the template engine
	 * @param emailAddress the recipient of the mail
	 * @param properties properties that are forwared to the {@link IMessageDataHandler} for
	 * creating template properties
	 * @param messageDataProperties objects that should be directly used as input for the template
	 * @throws Exception any kind of exception, e.g. from the mail server if it is not reachable
	 */
	void sendMailNow(String templateName, String emailAddress, Map<String, String> properties, Map<String, Object> messageDataProperties)
			throws Exception;
}
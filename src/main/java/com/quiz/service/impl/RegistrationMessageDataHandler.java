//package com.quiz.service.impl;
//
//
//import com.quiz.dao.IUserDao;
//import com.quiz.entities.User;
//import java.util.Locale;
//import java.util.Map;
//import com.quiz.mail.IMessageDataHandler;
//import com.quiz.mail.MessageData;
//import org.springframework.context.MessageSource;
//import org.springframework.context.MessageSourceAware;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//
///**
// * This class is responsible for fetching all the required data for the mails PasswordRecovery,
// * MailInvitation and SponsorInvitation
// * 
// * 
// */
//public class RegistrationMessageDataHandler implements MessageSourceAware, IMessageDataHandler {
//
//	private MessageSource messageSource;
//	private final IUserDao userDao;
//	private final UrlBuilder urlBuilder;
//
//	public RegistrationMessageDataHandler(IUserDao userDao, UrlBuilder urlBuilder) {
//		this.userDao = userDao;
//		this.urlBuilder = urlBuilder;
//	}
//
//	@Override
//	public MessageSource getMessageSource() {
//		return messageSource;
//	}
//
//	@Override
//	public void setMessageSource(MessageSource messageSource) {
//		this.messageSource = messageSource;
//	}
//
//	// --------------------- Interface IMessageDataHandler ---------------------
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public MessageData getData(String templateName, String emailAddress, Map<String, String> params) {
//
//		User user = userDao.findUserByEmailAddress(emailAddress);
//
//		MessageData data = new MessageData();
//
//		data.setRecipientName(user.getDisplayName());
//
//		data.setSenderName(urlBuilder.getWebHostWithoutProtocol());
//		data.getObjects().put("webHost", urlBuilder.getWebHost());
//		data.getObjects().put("recipient", user);
//		data.getObjects().put("recipientName", user.getDisplayName());
//
//		//todo
//		data.setLocale(Locale.ENGLISH);
//
////		if (MailTemplates.ACTVATE_ACCOUNT.equals(templateName)) {
////			data.getObjects().put("activationUrl", urlBuilder.getActivateUrl(user.getTicket().getTicketHash()));
////		} else if (MailTemplates.PASSWORDRECOVERY.equals(templateName)) {
////			data.getObjects().put("recoveryUrl", urlBuilder.getRecoveryUrl(user.getTicket().getTicketHash()));
////			data.getObjects().put("ticketExpiration", user.getTicket().getExpiration());
////		}
//
//		return data;
//	}
//
//	@Override
//	public String[] getSupportedTemplates() {
////		return new String[] { MailTemplates.ACTVATE_ACCOUNT, MailTemplates.PASSWORDRECOVERY };
//            return null;
//	}
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public void messageSent(String templateName, String emailAddress, Map<String, String> properties) {
//	}
//
//	@Override
//	public void messageError(String templateName, String emailAddress, Map<String, String> properties, Exception ex) {
//	}
//}

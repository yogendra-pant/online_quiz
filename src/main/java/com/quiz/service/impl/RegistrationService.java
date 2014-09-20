//package com.quiz.service.impl;
//
//import com.quiz.authentication.AuthenticationException;
//import com.quiz.dao.IUserDao;
//import com.quiz.entities.User;
//import com.quiz.service.IRegistrationService;
//import com.quiz.service.RegistrationModel;
//import java.util.Calendar;
//import java.util.Locale;
//import com.quiz.mail.IMailJobService;
//
//
//
//
//public class RegistrationService implements IRegistrationService {
//
//	private final IMailJobService mailJobService;
//	private final IUserDao userDao;
////	private final IPasswordEncoder passwordEncoder;
//
//	public RegistrationService(IUserDao userDao, IMailJobService mailJobService) {
//		this.userDao = userDao;
//		this.mailJobService = mailJobService;
////		this.passwordEncoder = passwordEncoder;
//	}
//
//	@Override
//	public void registerUser(RegistrationModel registrationModel) throws AuthenticationException {
//
//		User user = (User) userDao.findUserByName(registrationModel.getUserName());
//		if (user != null) {
//			throw new AuthenticationException("Duplicate.registrationModel.userName");
//		}
//
//		if (registrationModel.getEmail() != null && registrationModel.getEmail() != "") {
//			user = userDao.findUserByEmailAddress(registrationModel.getEmail());
//			if (user != null) {
//				throw new AuthenticationException("Duplicate.registrationModel.email");
//			}
//		}
//
//		user = new User();
//		user.setName(registrationModel.getUserName());
////		user.setPassword(passwordEncoder.encodePassword(registrationModel.getUserName(), registrationModel.getPassword()));
////		user.setEmailAddress(registrationModel.getEmail());
////		user.setAuthority(Authorities.Authenticated);
////		user.setLocale(new Locale("de_AT"));
//		userDao.store(user);
//
//	}
//
//	@Override
//	public void activateAccount(String uuid) throws AuthenticationException {
////		User user = userDao.getUserByTicket(uuid);
////		if (user == null) {
////			throw new AuthenticationException("activation.user.unknown");
////		}
////		user.setTicket(null);
////		user.setDisabled(false);
////		userDao.store(user);
//	}
//
//	@Override
//	public void recoverPassword(String newPassword, String ticket) throws AuthenticationException {
////		User user = userDao.getUserByTicket(ticket);
////		if (user == null) {
////			throw new AuthenticationException("passwordreminder.user.unknown");
////		} else if (user.isDisabled()) {
////			throw new AuthenticationException("authentication.failed.user.disabled");
////		} else if (!user.isEditable()) {
////			throw new AuthenticationException("error.notEditable");
////		}
//////		user.setPassword(passwordEncoder.encodePassword(user.getUsername(), newPassword));
////		userDao.store(user);
//
//	}
//
//	@Override
//	public void sendPasswordReminder(String emailAddress) throws AuthenticationException {
//		User user = userDao.findUserByEmailAddress(emailAddress);
//		if (user == null) {
//			throw new AuthenticationException("passwordreminder.user.unknown");
//		} else if (user.isDisabled()) {
//			throw new AuthenticationException("authentication.failed.user.disabled");
//		} else if (!user.isEditable()) {
//			throw new AuthenticationException("error.notEditable");
//		}
//
////		user.setTicket(Ticket.getInstance(Calendar.HOUR, 240));
//		userDao.store(user);
////		mailJobService.scheduleMail(MailTemplates.PASSWORDRECOVERY, emailAddress, null, null);
//	}
//}

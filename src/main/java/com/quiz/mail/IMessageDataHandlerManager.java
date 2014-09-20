package com.quiz.mail;


public interface IMessageDataHandlerManager {
	IMessageDataHandler getHandler(String template);
}

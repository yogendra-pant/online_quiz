package com.quiz.service;

import com.quiz.shared.entities.ChangePasswordResult;



public interface ISettingsService {

	UserProfile getUserProfile();

	UserProfile updateUserProfile(UserProfile profile);

	ChangePasswordResult changePassword(String newPassword, String oldPassword);

}

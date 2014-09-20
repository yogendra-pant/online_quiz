package com.quiz.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IAdminService {

	void trainingContestStarter();

	String installGame(MultipartFile file, String fileName, String rootdir);

	String deleteGame(String gameName);

	Resource downloadCodingLanguage(String downloadDirectory, String folderName, String userName);
}

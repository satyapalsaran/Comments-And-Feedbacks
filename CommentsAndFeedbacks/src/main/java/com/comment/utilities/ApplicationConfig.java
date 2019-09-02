package com.comment.utilities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

	private final String badWordsFile;
	private final Boolean isLocalStorageMode;

	public ApplicationConfig(@Value("${data.bad-words-file:data/bad-words.txt}") String badWordsFile,
			@Value("${data.is-local-storage-mode:true}") Boolean isLocalStorageMode) {
		this.badWordsFile = badWordsFile;
		this.isLocalStorageMode = isLocalStorageMode;
	}

	

	public boolean isValidate(String comments) {
		Path filePath = null;
		Stream<String> lines = null;
		if (Boolean.TRUE.equals(this.isLocalStorageMode)) {

			try {
				filePath = Paths.get(this.badWordsFile).toFile().exists() ? Paths.get(this.badWordsFile)
						: Paths.get(getClass().getClassLoader().getResource("bad-words.txt").toURI());

				

				String[] words = comments.split(" ");
				for (int i = 0; i < words.length; i++) {
					String str = words[i];
					lines = Files.lines(filePath);
					Optional<String> hasPassword = lines.filter(s -> s.contains(str)).findFirst();
					if (hasPassword.isPresent()) {
						
						return true;
					}
				}
				lines.close();

			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

}

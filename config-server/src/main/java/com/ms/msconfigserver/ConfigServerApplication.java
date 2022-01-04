package com.ms.msconfigserver;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(ConfigServerApplication.class);

	@Value("${spring.cloud.config.server.git.username}")
	private String gitUserName;
	@Value("${spring.cloud.config.server.git.password}")
	private String gitPassWord;
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("GITHUB_USER: {}", gitUserName);
		logger.info("GITHUB_PWD:{}", Objects.nonNull(gitPassWord));

	}

}

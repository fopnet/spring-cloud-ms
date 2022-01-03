package com.ms.msconfigserver;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication implements CommandLineRunner {

	@Value("${spring.cloud.config.server.git.username}")
	private String gitUserName;
	@Value("${spring.cloud.config.server.git.password}")
	private String gitPassWord;
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("GITHUB_USER:" + gitUserName);
		System.out.println("GITHUB_PWD:" + StringUtils.isNotBlank(gitPassWord));

	}

}

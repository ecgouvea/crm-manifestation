package br.com.crm.manifestation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
//
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DavidBen
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		loadApplication();
	}

	private static void loadApplication() {
		try {
			String classPath = Application.class.getResource(Application.class.getSimpleName() + ".class").toString();
			String libPath = classPath.substring(0, classPath.lastIndexOf("/br"));
			String filePath = libPath + "/META-INF/MANIFEST.MF";
			Manifest manifest = new Manifest(new URL(filePath).openStream());
			Attributes attr = manifest.getMainAttributes();
			logger.info("============ Load information application ===== ============");
			logger.info("Implementation-Version: " + attr.getValue("Implementation-Version"));
			logger.info("Built-By: " + attr.getValue("Built-By"));
			logger.info("Build-Jdk: " + attr.getValue("Build-Jdk"));
			logger.info("=============================================================");
		} catch (MalformedURLException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
	}
	
}

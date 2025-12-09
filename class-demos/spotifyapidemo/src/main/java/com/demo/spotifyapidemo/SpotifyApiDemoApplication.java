package com.demo.spotifyapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  SpotifyApiDemoApplication is the main entry point for your Spring Boot app.
 * It's like the "main menu" of your project — when you hit 'Run', this is what launches first!
 */
@SpringBootApplication
public class SpotifyApiDemoApplication {

	/**
	 * 🎯 This is the standard Java `main()` method.
	 * It's what starts the entire Spring Boot application.
	 *
	 * `SpringApplication.run(...)` does 3 major things:
	 * 1. Bootstraps the Spring context (loads all beans, configs, etc.)
	 * 2. Starts the embedded web server (usually Tomcat on port 8080)
	 * 3. Begins listening for HTTP requests
	 *
	 * @param args optional command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpotifyApiDemoApplication.class, args);
	}
}

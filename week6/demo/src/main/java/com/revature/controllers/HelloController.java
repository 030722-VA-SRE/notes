package com.revature.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

	@Autowired
	private Environment env;
	
	@GetMapping("/hello")
	public String hello() throws UnknownHostException {
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("local.server.port");
		
		// Randomly generating logs, not great practice.
		log.info("/hello, generating info logs");
		if(Math.random() > .5) {
			log.warn("warn log generated");
			if(Math.random() > .5) {
				log.error("error log generated");
			}
		}
		
		return String.format("Hello(version: 4) from %s:%s", ipAddress, port);
	}
}

package com.revature.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Environment env;
	
	@GetMapping("/hello")
	public String hello() throws UnknownHostException {
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("local.server.port");
		
		return String.format("Hello(version: 2) from %s:%s", ipAddress, port);
	}
}

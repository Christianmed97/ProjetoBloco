package com.livro.conf;

import org.springframework.stereotype.Component;

import info.schnatterer.mobynamesgenerator.MobyNamesGenerator;
import jakarta.annotation.PostConstruct;

@Component
public class ApplicationCache {
	public String appName;
	@PostConstruct
	public void init() {
	this.appName=  MobyNamesGenerator.getRandomName();
}
}

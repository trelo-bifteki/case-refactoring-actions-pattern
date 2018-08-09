package com.trelobifteki.examples.strategypattern.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperatorService {

	public void disableById(final Long id) {
		log.info("disable operator by ID: {}", id);
	}
	
}

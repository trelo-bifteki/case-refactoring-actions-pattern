package com.trelobifteki.examples.strategypattern.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperatorService {

	public void disableById(@NonNull final Long id) {
		log.info("disable operator by ID: {}", id);
	}
	
}

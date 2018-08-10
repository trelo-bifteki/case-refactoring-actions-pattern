package com.trelobifteki.examples.strategypattern.service;

import org.springframework.stereotype.Service;

import com.trelobifteki.examples.strategypattern.model.Network;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NetworkService {

	public void disableById(final Long id) {
		log.info("Disabling network: {}", id);
	}
	
	public Network update(final Network network) {
		log.info("Updating: {}", network);
		
		return network;
	}
}

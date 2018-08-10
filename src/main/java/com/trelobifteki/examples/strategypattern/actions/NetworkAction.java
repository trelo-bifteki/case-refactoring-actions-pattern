package com.trelobifteki.examples.strategypattern.actions;

import org.springframework.lang.NonNull;

import com.trelobifteki.examples.strategypattern.model.Network;

public interface NetworkAction {
	
	boolean supports(@NonNull final Network network);
	
	void execute(@NonNull final Network network);
}

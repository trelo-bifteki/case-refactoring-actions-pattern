package com.trelobifteki.examples.strategypattern.actions;

import com.trelobifteki.examples.strategypattern.model.Network;

public interface NetworkAction {
	
	boolean supports(final Network network);
	
}

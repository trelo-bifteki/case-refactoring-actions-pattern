package com.trelobifteki.examples.strategypattern.actions;

import java.util.stream.Stream;

import com.trelobifteki.examples.strategypattern.model.Network;

public class ConditionBuilder {
	
	private final Network network; 
	private boolean result;
	
	private ConditionBuilder(final Network network) {
		this.network = network;
		this.result = true;
	}
	
	public boolean build() {
		return result;
	}
	
	public static ConditionBuilder create(final Network network) {
		return new ConditionBuilder(network);
	}

	public ConditionBuilder supportAll(final NetworkAction... actions) {
		final boolean condition = Stream.of(actions).allMatch(action -> action.supports(network));
		validate(condition);
		return this;
	}
	
	private void validate(final boolean condition) {
		result = result && condition;
	}
}

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
	
	public ConditionBuilder isValid() {
		return validate(network.getId() > 0);
	}

	public ConditionBuilder supportAll(final NetworkAction... actions) {
		final boolean allSupported = Stream.of(actions).allMatch(action -> action.supports(network));
		return validate(allSupported);
	}
	
	private ConditionBuilder validate(final boolean condition) {
		result = result && condition;
		return this;
	}
}

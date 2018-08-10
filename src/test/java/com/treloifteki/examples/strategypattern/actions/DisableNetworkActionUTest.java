package com.treloifteki.examples.strategypattern.actions;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.trelobifteki.examples.strategypattern.actions.DisableNetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;

public class DisableNetworkActionUTest {

	private final DisableNetworkAction disableNetworkAction = new DisableNetworkAction();
	
	@Test
	public void testSupportsWhenNetworkDisabledThenReturnFalse() {
		final Network network = new Network();
		network.setDisabled(true);

		boolean result = disableNetworkAction.supports(network);
		
		Assertions.assertThat(result).isFalse();
	}
	
	
	@Test
	public void testSupportsWhenNetworkNotDisabledThenReturnTrue() {
		final Network network = new Network();
		network.setDisabled(true);

		boolean result = disableNetworkAction.supports(network);
		
		Assertions.assertThat(result).isTrue();
	}
	
}

package com.treloifteki.examples.strategypattern.actions;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import com.trelobifteki.examples.strategypattern.actions.SetStatusClosedNetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.model.NetworkStatus;
import com.trelobifteki.examples.strategypattern.service.NetworkService;

public class SetStatusClosedNetworkActionUTest {
	
	private final NetworkService networkService = Mockito.mock(NetworkService.class);
	
	private final SetStatusClosedNetworkAction action = new SetStatusClosedNetworkAction(networkService);
	
	@After
	public void reset() {
		Mockito.verifyNoMoreInteractions(networkService);
		Mockito.reset(networkService);
	}
	
	@Test
	public void testSupportsWhenNetworkOpenThenReturnTrue() {
		final Network network = new Network();
		network.setNetworkStatus(NetworkStatus.OPEN);
		
		final boolean supported = action.supports(network);
		
		Assertions.assertThat(supported).isTrue();
	}

	@Test
	public void testSupportsWhenNetworkClosedThenReturnFalse() {
		final Network network = new Network();
		network.setNetworkStatus(NetworkStatus.CLOSED);
		
		final boolean supported = action.supports(network);
		
		Assertions.assertThat(supported).isFalse();
	}
	
	@Test
	public void testExecuteWhenNetworkOpen() {
		final Network network = new Network();
		network.setNetworkStatus(NetworkStatus.OPEN);
		
		action.execute(network);
		
		Mockito.verify(networkService).update(network);
	}
	
}

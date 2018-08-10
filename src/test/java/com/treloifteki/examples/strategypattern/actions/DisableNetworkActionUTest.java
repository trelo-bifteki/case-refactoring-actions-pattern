package com.treloifteki.examples.strategypattern.actions;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import com.trelobifteki.examples.strategypattern.actions.DisableNetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.service.NetworkService;

public class DisableNetworkActionUTest {
	
	private static final long NETWORK_ID = 1L;

	private final NetworkService networkService = Mockito.mock(NetworkService.class);
	
	private final DisableNetworkAction disableNetworkAction = new DisableNetworkAction(networkService);
	
	@After
	public void resetMocks() {
		Mockito.verifyNoMoreInteractions(networkService);
		Mockito.reset(networkService);
	}
	
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
		network.setDisabled(false);

		boolean result = disableNetworkAction.supports(network);
		
		Assertions.assertThat(result).isTrue();
	}
	
	@Test
	public void testExecuteWhenNetworNotDisabledThenVerifyNetworkServiceDisable() {
		final Network network = new Network(NETWORK_ID);
		network.setDisabled(false);
		
		disableNetworkAction.execute(network);
		
		Mockito.verify(networkService).disableById(NETWORK_ID);
	}
	
}

package com.treloifteki.examples.strategypattern.actions;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import com.trelobifteki.examples.strategypattern.actions.DisableNetworkAction;
import com.trelobifteki.examples.strategypattern.actions.SetStatusClosedNetworkAction;
import com.trelobifteki.examples.strategypattern.actions.ShutdownNetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;

public class ShutdownNetworkActionUTest {
	private static final Long NETWORK_ID = 1L;
	
	private final DisableNetworkAction disableNetworkAction = Mockito.mock(DisableNetworkAction.class);
	private final SetStatusClosedNetworkAction setStatusClosedNetworkAction = Mockito.mock(SetStatusClosedNetworkAction.class);
	
	private final ShutdownNetworkAction action = new ShutdownNetworkAction(setStatusClosedNetworkAction, disableNetworkAction);

	@After
	public void resest() {
		Mockito.verifyZeroInteractions(disableNetworkAction, setStatusClosedNetworkAction);
		Mockito.reset(disableNetworkAction, setStatusClosedNetworkAction);
	}
	
	@Test
	public void testSupportsWhenBothActionsSupportedThenReturnTrue() {
		final Network network = new Network(NETWORK_ID);
		
		Mockito.when(disableNetworkAction.supports(network)).thenReturn(true);
		Mockito.when(setStatusClosedNetworkAction.supports(network)).thenReturn(true);
		
		final boolean supported = action.supports(network);

		Mockito.verify(disableNetworkAction).supports(network);
		Mockito.verify(setStatusClosedNetworkAction).supports(network);
		
		Assertions.assertThat(supported).isTrue();
	}

	@Test
	public void testSupportsWhenOnActionSupportedThenReturnFalse() {
		final Network network = new Network(NETWORK_ID);
		
		Mockito.when(disableNetworkAction.supports(network)).thenReturn(false);
		Mockito.when(setStatusClosedNetworkAction.supports(network)).thenReturn(true);
		
		final boolean supported = action.supports(network);

		Mockito.verify(disableNetworkAction).supports(network);
		
		Assertions.assertThat(supported).isFalse();
	}
	
	
}

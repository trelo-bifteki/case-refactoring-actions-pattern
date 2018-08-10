package com.treloifteki.examples.strategypattern.actions;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import com.trelobifteki.examples.strategypattern.actions.NetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.service.NetworkActionService;

public class NetworkActionServiceUTest {
	
	private static final String ACTION_A = "action a";
	private final NetworkAction actionA = Mockito.mock(NetworkAction.class);
	private final NetworkAction actionB = Mockito.mock(NetworkAction.class);
	private final NetworkAction actionC = Mockito.mock(NetworkAction.class);
	
	private final NetworkActionService service = new NetworkActionService(Arrays.asList(actionA, actionB, actionC));
	
	@After
	public void reset() {
		Mockito.verifyNoMoreInteractions(actionA, actionB, actionC);
		Mockito.reset(actionA, actionB, actionC);
	}
	
	@Test
	public void testfindAvailableActionsByNetwork() {
		final Network network = new Network();
		
		Mockito.when(actionA.supports(network)).thenReturn(true);
		Mockito.when(actionA.getLabel()).thenReturn(ACTION_A);
		
		final List<String> labels = service.findAvailableActionLabelsByNetwork(network);

		Mockito.verify(actionA).supports(network);
		Mockito.verify(actionB).supports(network);
		Mockito.verify(actionC).supports(network);
		Mockito.verify(actionA).getLabel();
		
		Assertions.assertThat(labels).containsExactly(ACTION_A);
	}
}

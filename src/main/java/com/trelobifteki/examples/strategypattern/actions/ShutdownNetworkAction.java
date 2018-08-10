package com.trelobifteki.examples.strategypattern.actions;

import com.trelobifteki.examples.strategypattern.model.Network;

public class ShutdownNetworkAction implements NetworkAction {
	
	private final SetStatusClosedNetworkAction setStatusClosedNetworkAction;
	private final DisableNetworkAction disableNetworkAction;
	
	public ShutdownNetworkAction(final SetStatusClosedNetworkAction setStatusClosedNetworkAction, final DisableNetworkAction disableNetworkAction) {
		this.disableNetworkAction = disableNetworkAction;
		this.setStatusClosedNetworkAction = setStatusClosedNetworkAction;
	}

	@Override
	public String getLabel() {
		return "Shutdown network";
	}

	@Override
	public boolean supports(Network network) {
		return ConditionBuilder.create(network)
				.supportAll(disableNetworkAction, setStatusClosedNetworkAction)
				.build();
	}

	@Override
	public void execute(Network network) {
		setStatusClosedNetworkAction.execute(network);
		disableNetworkAction.execute(network);
	}

}
package com.trelobifteki.examples.strategypattern.actions;

import com.trelobifteki.examples.strategypattern.model.Network;
import org.springframework.beans.factory.annotation.Autowired;

public class ShutdownNetworkAction implements NetworkAction {

	private final SetStatusClosedNetworkAction setStatusClosedNetworkAction;
	private final DisableNetworkAction disableNetworkAction;

	@Autowired
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
				.isValid()
				.supportAll(disableNetworkAction, setStatusClosedNetworkAction)
				.build();
	}

	@Override
	public void execute(Network network) {
		setStatusClosedNetworkAction.execute(network);
		disableNetworkAction.execute(network);
	}

}

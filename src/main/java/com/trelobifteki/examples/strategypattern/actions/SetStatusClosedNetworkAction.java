package com.trelobifteki.examples.strategypattern.actions;

import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.model.NetworkStatus;
import com.trelobifteki.examples.strategypattern.service.NetworkService;

public class SetStatusClosedNetworkAction implements NetworkAction {

	private final NetworkService networkService;
	
	public SetStatusClosedNetworkAction(final NetworkService networkService) {
		this.networkService = networkService;
	}
	
	@Override
	public String getLabel() {
		return "Set status closed";
	}

	@Override
	public boolean supports(Network network) {
		return NetworkStatus.OPEN == network.getNetworkStatus();
	}

	@Override
	public void execute(Network network) {
		network.setNetworkStatus(NetworkStatus.CLOSED);
		networkService.update(network);
	}
}

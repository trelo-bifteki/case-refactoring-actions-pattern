package com.trelobifteki.examples.strategypattern.actions;

import org.springframework.stereotype.Component;

import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.service.NetworkService;

@Component
public class DisableNetworkAction implements NetworkAction {

	private final NetworkService networkService;
	
	@Override
	public String getLabel() {
		return "Disable network";
	}

	
	public DisableNetworkAction(final NetworkService networkService) {
		this.networkService = networkService;
	}
	
	@Override
	public boolean supports(final Network network) {
		return !network.isDisabled();
	}

	@Override
	public void execute(Network network) {
		networkService.disableById(network.getId());
	}

}

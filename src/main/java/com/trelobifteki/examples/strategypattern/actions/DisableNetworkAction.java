package com.trelobifteki.examples.strategypattern.actions;

import org.springframework.stereotype.Component;

import com.trelobifteki.examples.strategypattern.model.Network;

@Component
public class DisableNetworkAction implements NetworkAction{

	@Override
	public boolean supports(final Network network) {
		// TODO Auto-generated method stub
		return !network.isDisabled();
	}

}

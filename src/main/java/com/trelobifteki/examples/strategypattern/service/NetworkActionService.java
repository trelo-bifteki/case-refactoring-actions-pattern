package com.trelobifteki.examples.strategypattern.service;

import com.trelobifteki.examples.strategypattern.actions.NetworkAction;
import com.trelobifteki.examples.strategypattern.model.Network;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class NetworkActionService {

	private List<NetworkAction> networkActions;
	
	@Autowired
	public NetworkActionService(final List<NetworkAction> networkActions) {
		this.networkActions = networkActions;
	}
	
	@NonNull
	public List<String> findAvailableActionLabelsByNetwork(@NonNull final Network network) {
		return networkActions.stream()
				.filter(action -> action.supports(network))
				.map(NetworkAction::getLabel)
				.collect(Collectors.toList());
	}
}

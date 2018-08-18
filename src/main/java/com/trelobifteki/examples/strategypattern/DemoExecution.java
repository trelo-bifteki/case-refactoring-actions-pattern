package com.trelobifteki.examples.strategypattern;

import com.trelobifteki.examples.strategypattern.model.Network;
import com.trelobifteki.examples.strategypattern.model.NetworkStatus;
import com.trelobifteki.examples.strategypattern.service.NetworkActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lambros on 18.08.18.
 */
@Slf4j
@Component
public class DemoExecution implements ApplicationRunner {

    private final NetworkActionService networkActionService;

    @Autowired
    public DemoExecution(final NetworkActionService networkActionService) {
        this.networkActionService = networkActionService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        final Network network = new Network();
        network.setId(1L);
        network.setDisabled(false);
        network.setNetworkStatus(NetworkStatus.OPEN);

        final List<String> availableActions = networkActionService.findAvailableActionLabelsByNetwork(network);

        log.info("Found available actions: {}", availableActions);
    }
}

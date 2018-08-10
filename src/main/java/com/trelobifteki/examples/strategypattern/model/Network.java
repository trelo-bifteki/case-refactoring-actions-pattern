
package com.trelobifteki.examples.strategypattern.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Network {
	
	private Long id;
	private boolean disabled;
	private NetworkStatus networkStatus;

	public Network(final Long id) {
		this.id = id;
	}
	
}


package com.trelobifteki.examples.strategypattern.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Network {
	
	private Long id;
	private boolean disabled;

	public Network(final Long id) {
		this.id = id;
	}
	
}

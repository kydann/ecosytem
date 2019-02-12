package com.citibanamex.bne.tuxedoclient.component;

import com.citibanamex.bne.tuxedoclient.client.Tuxedo;
import com.citibanamex.bne.tuxedoclient.model.TuxedoRequest;

public class TuxedoFallback implements Tuxedo {
	@Override
	public String call(TuxedoRequest request) {
		return null;
	}
}

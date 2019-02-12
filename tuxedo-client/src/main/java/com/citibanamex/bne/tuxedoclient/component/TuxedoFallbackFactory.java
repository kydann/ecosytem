package com.citibanamex.bne.tuxedoclient.component;

import com.citibanamex.bne.tuxedoclient.client.Tuxedo;
import com.citibanamex.bne.tuxedoclient.model.TuxedoRequest;

import feign.hystrix.FallbackFactory;

public class TuxedoFallbackFactory implements FallbackFactory<Tuxedo> {
	@Override 
	public Tuxedo create(Throwable cause) {
		return new Tuxedo(){
            @Override
            public String call(TuxedoRequest request) {
                System.out.println("Fallback cause: " + cause.getMessage());
                
                return null;
            }            
        };
	}
}

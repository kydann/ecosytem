package com.citibanamex.bne.tuxedoclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citibanamex.bne.tuxedoclient.client.Tuxedo;
import com.citibanamex.bne.tuxedoclient.model.TuxedoRequest;

@Service
public class TuxedoServiceImp implements TuxedoService {
	@Autowired
	private Tuxedo tuxedo;
	
	@Override
	public String Call(TuxedoRequest request) {
		String response = "";
		
		response = tuxedo.call(request);
		
		return response;
	}

}

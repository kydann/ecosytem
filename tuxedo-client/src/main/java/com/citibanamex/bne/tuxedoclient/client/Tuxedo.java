package com.citibanamex.bne.tuxedoclient.client;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citibanamex.bne.tuxedoclient.model.TuxedoRequest;

@RefreshScope
@FeignClient(name = "${tuxedo.name:tuxedo-connector}", url = "${tuxedo.url:}")
public interface Tuxedo {
	 @RequestMapping(value = "${tuxedo.path:/v1/tuxedo}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 public String call(TuxedoRequest request);	 
}

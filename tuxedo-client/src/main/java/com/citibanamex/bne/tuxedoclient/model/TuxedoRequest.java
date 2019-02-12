package com.citibanamex.bne.tuxedoclient.model;

import org.springframework.beans.factory.annotation.Value;

public class TuxedoRequest {
	private String serviceName;
	private Channel channel;
	
	@Value("${tuxedo.destination}")
	private Destination destination;
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public Destination getDestination() {
		return destination;
	}
	
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}

package com.citibanamex.bne.services;

import java.util.List;
import java.util.Map;

public interface ProxyService {		
	public Map<String, Object> queryToMap(List<Object[]> params);
 }

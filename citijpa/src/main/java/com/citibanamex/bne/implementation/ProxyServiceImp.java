package com.citibanamex.bne.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.citibanamex.bne.services.ProxyService;

@Service
public class ProxyServiceImp implements ProxyService {
	@Override
	public Map<String, Object> queryToMap(List<Object[]> params) {
		Map<String, Object> mapper = new HashMap<>();
		
		int index = 1;
		
		for (Object[] param : params) {
			mapper.put("row" + index++, param);
		}		
		
		return mapper;
	}
}

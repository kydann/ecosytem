package com.citibanamex.bne.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;

import com.citibanamex.bne.jdbcclient.model.SqlStatementRequest;
import com.citibanamex.bne.jdbcclient.model.SqlStatementResponse;
import com.citibanamex.bne.modelo.Usuario;

public interface ApiService {
	public SqlStatementResponse directRawQuery(SqlStatementRequest request);
	public Map<String, Object> proxyQueryToMap();
	public Usuario porpersona(RequestEntity<Object> request);
	public String insertar(Usuario usuario);
	public List<Usuario> obtenerTodo();
}

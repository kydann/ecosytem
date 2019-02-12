package com.citibanamex.bne.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;

import com.citibanamex.bne.modelo.Usuario;

@Repository
@Transactional
public class ApiRepository {

	
	@Autowired
	EntityManager em;
	
	
	public Usuario findById(RequestEntity<Object> request) {
		Map<String, Object> mapBody;
		mapBody=(Map<String, Object>) request.getBody();
		Query query= em.createQuery("from Usuario where id=:id").setParameter("id", mapBody.get("id").toString());
		return (Usuario) query.getSingleResult();
		
	}
	
	
	public String guardar(Usuario usuario) {
		em.persist(usuario);
		return "Guardado";
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerTodo(){
		// clase query para realizar consulta a base de datos
		Query query = em.createQuery("select u from Usuario u");
		//JPQL trabaja atraves de nuestra clase entity y debe coincidir el nombre en este caso Usuario
		//List<Usuario> usuarios = query.getResultList();CSQ
		return query.getResultList();//usuarios CSQ
	}
}

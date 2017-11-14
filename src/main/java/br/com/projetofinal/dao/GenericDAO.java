package br.com.projetofinal.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.com.projetofinal.model.GenericModel;

@SuppressWarnings("serial")
public class GenericDAO<Entidade extends GenericModel> implements Serializable {
	
	private EntityManager entityManager;

	private final Class<Entidade> entidade;

	public GenericDAO(EntityManager entityManager, Class<Entidade> entidade) {
		this.entityManager = entityManager;
		this.entidade = entidade;
	}

	public void salvar(Entidade entidade) {
		entityManager.persist(entidade);
	}

	public void editar(Entidade entidade) {
		entityManager.merge(entidade);
	}

	public void ativar(Entidade entidade) {
		entityManager.merge(entidade);
	}

	public void inativar(Entidade entidade) {
		entityManager.merge(entidade);
	}

	public Entidade buscaPorId(Long id) {
		Entidade instancia = entityManager.find(entidade, id);
		return instancia;
	}

}

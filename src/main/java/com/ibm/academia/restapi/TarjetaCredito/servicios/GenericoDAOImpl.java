package com.ibm.academia.restapi.TarjetaCredito.servicios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericoDAOImpl <E, R extends CrudRepository<E, Long>> implements GenericoDAO<E>  
{
	protected final R repository;
	
	public GenericoDAOImpl(R repository) 
	{
		this.repository = repository;
	}

	@Override
	public Optional<E> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public E guardar(E entidad) {

		return repository.save(entidad);
	}

	@Override
	public Iterable<E> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public void eliminarPorId(Long id) {
		
		repository.deleteById(id);
		
	}

}

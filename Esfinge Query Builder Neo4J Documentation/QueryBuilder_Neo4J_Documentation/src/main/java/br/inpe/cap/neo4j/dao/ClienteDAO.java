package br.inpe.cap.neo4j.dao;

import java.util.Collection;

import org.esfinge.querybuilder.Repository;
import org.esfinge.querybuilder.annotation.QueryBuilder;

import br.inpe.cap.neo4j.domain.Cliente;

@QueryBuilder
public interface ClienteDAO extends Repository<Cliente> {
	
	public Collection<Cliente> getCliente();
	public Collection<Cliente> getClienteByNome(String nome);
	public Collection<Cliente> getClienteByNomeDesc(String nome);

}


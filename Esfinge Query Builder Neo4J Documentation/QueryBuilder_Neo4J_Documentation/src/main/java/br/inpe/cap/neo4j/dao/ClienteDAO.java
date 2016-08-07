package br.inpe.cap.neo4j.dao;

import java.util.Collection;

import org.esfinge.querybuilder.Repository;

import br.inpe.cap.neo4j.domain.Cliente;

public interface ClienteDAO extends Repository<Cliente> {
	
	public Collection<Cliente> getCliente();
	public Collection<Cliente> getClienteByNome(String nome);
	public Collection<Cliente> getClienteByNomeDesc(String nome);

}

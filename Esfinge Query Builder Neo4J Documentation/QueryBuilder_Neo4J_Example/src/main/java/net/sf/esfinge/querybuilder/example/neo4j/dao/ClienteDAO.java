package net.sf.esfinge.querybuilder.example.neo4j.dao;

import java.util.Collection;

import net.sf.esfinge.querybuilder.Repository;
import net.sf.esfinge.querybuilder.annotation.QueryBuilder;
import net.sf.esfinge.querybuilder.example.neo4j.domain.Cliente;

@QueryBuilder
public interface ClienteDAO extends Repository<Cliente> {
	
	public Collection<Cliente> getCliente();
	public Collection<Cliente> getClienteByNome(String nome);
	public Collection<Cliente> getClienteByNomeDesc(String nome);

}


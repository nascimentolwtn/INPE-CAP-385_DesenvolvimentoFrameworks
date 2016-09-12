package br.inpe.cap.neo4j.dao;

import java.util.Collection;

import br.inpe.cap.neo4j.domain.Cliente;
import net.sf.esfinge.querybuilder.Repository;
import net.sf.esfinge.querybuilder.annotation.QueryBuilder;

@QueryBuilder
public interface ClienteDAO extends Repository<Cliente> {
	
	public Collection<Cliente> getCliente();
	public Collection<Cliente> getClienteByNome(String nome);
	public Collection<Cliente> getClienteByNomeDesc(String nome);

}


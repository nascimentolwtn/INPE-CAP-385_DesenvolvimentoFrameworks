package br.inpe.cap.neo4j;

import java.util.List;

import org.esfinge.querybuilder.methodparser.ComparisonType;
import org.esfinge.querybuilder.neo4j.oomapper.Condition;
import org.esfinge.querybuilder.neo4j.oomapper.Neo4J;
import org.esfinge.querybuilder.neo4j.oomapper.Query;

import br.inpe.cap.neo4j.domain.Cliente;

public class Exemplos {
	
	private Neo4J neo;

	public List<Cliente> exemploQuery() {
		Query<Cliente> q = neo.query(Cliente.class);
		q.or(new Condition("idade", 14, ComparisonType.GREATER), new Condition("nome", "Amaral"));
		return q.asList();
	}
	
}

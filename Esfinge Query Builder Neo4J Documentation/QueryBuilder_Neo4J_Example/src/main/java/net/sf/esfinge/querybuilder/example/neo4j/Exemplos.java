package net.sf.esfinge.querybuilder.example.neo4j;

import java.util.List;

import net.sf.esfinge.querybuilder.example.neo4j.domain.Cliente;
import net.sf.esfinge.querybuilder.methodparser.ComparisonType;
import net.sf.esfinge.querybuilder.neo4j.oomapper.Condition;
import net.sf.esfinge.querybuilder.neo4j.oomapper.Neo4J;
import net.sf.esfinge.querybuilder.neo4j.oomapper.Query;

public class Exemplos {
	
	private Neo4J neo;

	public List<Cliente> exemploQuery() {
		Query<Cliente> q = neo.query(Cliente.class);
		q.or(new Condition("idade", 14, ComparisonType.GREATER), new Condition("nome", "Amaral"));
		return q.asList();
	}
	
}

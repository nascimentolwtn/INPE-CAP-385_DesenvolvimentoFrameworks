package br.inpe.cap.neo4j;

import org.esfinge.querybuilder.neo4j.oomapper.Condition;
import org.esfinge.querybuilder.neo4j.oomapper.Neo4J;
import org.esfinge.querybuilder.neo4j.oomapper.Query;

import br.inpe.cap.neo4j.domain.Cachorro;
import br.inpe.cap.neo4j.domain.Cliente;
import br.inpe.cap.neo4j.domain.Pagamento;

public class Principal {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Luiz Wagner");
		
		Cachorro cachorro = new Cachorro();
		cachorro.setNome("Gaia");
		cachorro.setRaca("Cocker Spaniel");
		cliente.add(cachorro);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setValor(50);
		pagamento.setData("30/07/2016");
		cliente.add(pagamento);
		
		Neo4J neo = new Neo4JDatastoreProvider().getDatastore();
		neo.save(cliente);
		
		Query<Cliente> query = neo.query(Cliente.class);
		query.or(new Condition("nome", "Luiz*"));
		
		System.out.println(query.asList());
		
	}

}

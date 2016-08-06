package br.inpe.cap.neo4j;

import org.esfinge.querybuilder.annotation.ServicePriority;
import org.esfinge.querybuilder.neo4j.DatastoreProvider;
import org.esfinge.querybuilder.neo4j.oomapper.Neo4J;

import br.inpe.cap.neo4j.domain.Cachorro;
import br.inpe.cap.neo4j.domain.Cliente;
import br.inpe.cap.neo4j.domain.Pagamento;

@ServicePriority(1)
public class Neo4JDatastoreProvider implements DatastoreProvider {
	
//	private static final Neo4J neo4j = new Neo4J();
	private static final Neo4J neo4j = new Neo4J("cap385-frameworks");
	
	public Neo4JDatastoreProvider(){
		this.mapEntities();
	}

	public void clear(){
		neo4j.clearDB();
		this.mapEntities();
	}

	private void mapEntities() {
		neo4j.map(Cliente.class);
		neo4j.map(Pagamento.class);
		neo4j.map(Cachorro.class);
	}
	
	@Override
	public Neo4J getDatastore() {
		return neo4j;
	}
}
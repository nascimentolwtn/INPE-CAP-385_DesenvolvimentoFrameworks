package br.inpe.cap.neo4j;

import org.esfinge.querybuilder.QueryBuilder;

import br.inpe.cap.neo4j.dao.ClienteDAO;
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
		
		ClienteDAO dao = QueryBuilder.create(ClienteDAO.class);
		dao.save(cliente);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Luiz Amaral");
		cliente2.setMatricula(1);
		dao.save(cliente2);
		
		System.out.println(dao.getById(0));
		System.out.println(dao.getCliente());
		
	}

}

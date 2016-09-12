package net.sf.esfinge.querybuilder.example.neo4j;

import net.sf.esfinge.querybuilder.QueryBuilder;
import net.sf.esfinge.querybuilder.example.neo4j.dao.ClienteDAO;
import net.sf.esfinge.querybuilder.example.neo4j.domain.Cachorro;
import net.sf.esfinge.querybuilder.example.neo4j.domain.Cliente;
import net.sf.esfinge.querybuilder.example.neo4j.domain.Pagamento;

public class Principal {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("William");
		
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
		cliente2.setNome("Amaral");
		cliente2.setMatricula(1);
		dao.save(cliente2);
		
		System.out.println(dao.getById(0));
		System.out.println(dao.getClienteByNome("Amaral"));
		System.out.println(dao.getCliente());
		
	}

}

package net.sf.esfinge.querybuilder.example.neo4j.domain;

import java.util.HashSet;
import java.util.Set;

import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.Id;
import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.Indexed;
import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.NodeEntity;
import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.RelatedTo;

@NodeEntity
public class Cliente {
	
	@Id
	private int matricula;
	
	@Indexed
	private String nome;
	
	@RelatedTo(targetClass = Cachorro.class)
	private Set<Cachorro> cachorros = new HashSet<Cachorro>();
	
	@RelatedTo(targetClass = Pagamento.class)
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>();
	
	public Cliente() {
		cachorros = new HashSet<Cachorro>();
		pagamentos = new HashSet<Pagamento>();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Cachorro> getCachorros() {
		return cachorros;
	}

	public void setCachorros(Set<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}

	public Set<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public void add(Cachorro cachorro) {
		this.cachorros.add(cachorro);
	}
	
	public void add(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
	}
	
	@Override
	public String toString() {
		return this.nome 
				+ ": cachorros="
				+ this.cachorros
				+ ", pagamentos="
				+ this.pagamentos
				;
	}
	
}

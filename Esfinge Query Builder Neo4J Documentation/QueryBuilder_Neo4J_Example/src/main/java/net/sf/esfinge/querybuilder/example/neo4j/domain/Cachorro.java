package net.sf.esfinge.querybuilder.example.neo4j.domain;

import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.Id;
import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.NodeEntity;

@NodeEntity
public class Cachorro {

	@Id
	private String nome;
	
	private String raca;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	@Override
	public String toString() {
		return this.nome + "(" + this.raca + ")";
	}
	
}

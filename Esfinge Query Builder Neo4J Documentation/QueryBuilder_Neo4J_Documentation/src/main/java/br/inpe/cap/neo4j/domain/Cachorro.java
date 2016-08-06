package br.inpe.cap.neo4j.domain;

import org.esfinge.querybuilder.neo4j.oomapper.annotations.Id;
import org.esfinge.querybuilder.neo4j.oomapper.annotations.NodeEntity;

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

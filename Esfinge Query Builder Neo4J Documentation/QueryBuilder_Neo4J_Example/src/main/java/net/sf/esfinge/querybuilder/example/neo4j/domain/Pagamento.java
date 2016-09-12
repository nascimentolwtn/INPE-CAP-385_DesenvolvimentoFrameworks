package net.sf.esfinge.querybuilder.example.neo4j.domain;

import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.Id;
import net.sf.esfinge.querybuilder.neo4j.oomapper.annotations.NodeEntity;

@NodeEntity
public class Pagamento {
	
	@Id
	private int id;
	
	private float valor;
	
	private String data;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + "=" + this.valor;
	}

}

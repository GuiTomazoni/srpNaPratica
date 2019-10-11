package br.com.fundatec.pedido;

public class Lanche {

	private String nome;
	private Double preco;

	public Lanche(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}
}

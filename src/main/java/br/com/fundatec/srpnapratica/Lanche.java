package br.com.fundatec.srpnapratica;

import br.com.fundatec.tabeladeentrega.TabelaDeEntrega;

public class Lanche {

	private String nome;
	private Double preco;
	private Bairro bairro;
	private boolean desconto;

	public Lanche(String nome, Double preco, Bairro bairro, boolean desconto) {
		this.nome = nome;
		this.preco = preco;
		this.bairro = bairro;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public Bairro getBairro() {
		return bairro;
	}
	
	public boolean getDesconto() {
		return desconto;
	}

	public Double aplicaDesconto() {
		if (desconto) {
			return this.preco - (this.preco * 0.1);
		} else {
			return 0.0;
		}
	}

	public Double calculaTotal(Lanche lanche) {
		TabelaDeEntrega tabelaDeEntrega = new TabelaDeEntrega();
		Double valorTotal = 0.0;
		Double valorEntrega = 0.0;
		Bairro bairro = lanche.getBairro();

		valorEntrega = tabelaDeEntrega.para(bairro);
		valorTotal = lanche.getPreco() + valorEntrega;

		if (lanche.desconto) {
			return valorTotal - lanche.aplicaDesconto();
		}

		return valorTotal;
	}

}

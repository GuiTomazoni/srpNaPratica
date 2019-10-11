package br.com.fundatec.pedido;

import br.com.fundatec.tabeladeentrega.TabelaDeEntrega;

public class Lanche {

	private String nome;
	private Double preco;
	private Bairro bairro;
	private Desconto desconto;

	public Lanche(String nome, Double preco, Bairro bairro, Desconto desconto) {
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
	
	public Desconto getDesconto() {
		return desconto;
	}

	public Double calculaTotal(Lanche lanche) {
		TabelaDeEntrega tabelaDeEntrega = new TabelaDeEntrega();
		Double valorTotal = 0.0;
		Double valorEntrega = 0.0;
		Bairro bairro = lanche.getBairro();

		valorEntrega = tabelaDeEntrega.para(bairro);
		valorTotal = lanche.getPreco() + valorEntrega;

		if (lanche.getDesconto().getDesconto()) {
			return valorTotal - desconto.aplicaDesconto();
		}

		return valorTotal;
	}

}

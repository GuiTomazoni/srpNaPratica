package br.com.fundatec.pedido;

public class Pedido {

	private Lanche lanche;
	private Desconto desconto;
	private Bairro bairro;

	public Pedido(Lanche lanche, Desconto desconto, Bairro bairro) {
		this.lanche = lanche;
		this.desconto = desconto;
		this.bairro = bairro;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	public boolean possuiDesconto() {
		return desconto.getDesconto();
	}
	
	public Desconto getDesconto() {
		return desconto;
	}

	public Bairro getBairro() {
		return bairro;
	}

}

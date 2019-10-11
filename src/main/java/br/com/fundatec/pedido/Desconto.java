package br.com.fundatec.pedido;

public class Desconto {
	
	private boolean desconto;
	private Lanche lanche;
	
	
	
	public Desconto(boolean desconto) {
		this.desconto = desconto;
	}

	public boolean getDesconto() {
		return desconto;
	}

	public Double aplicaDesconto() {
		if (desconto) {
			return lanche.getPreco() - (lanche.getPreco() * 0.1);
		} else {
			return 0.0;
		}
	}
	
}

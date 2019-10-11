package br.com.fundatec.pedido;

public class Desconto {
	
	private boolean desconto;
	private boolean aplicado = false;

	public Desconto(boolean desconto) {
		this.desconto = desconto;
	}
	
	public Desconto() {
		
	}

	public boolean getDesconto() {
		return desconto;
	}
	
	public boolean getAplicado() {
		return aplicado;
	}
	
	public double aplicar(Pedido pedido) {
		double valorFinal = 0.0;
		if(pedido.getDesconto() && !aplicado) {
			aplicado = true;
			valorFinal = (pedido.getLanche().getPreco() - 10.0);
			return valorFinal;
		}else {
			return valorFinal = pedido.getLanche().getPreco();
		}
	}
	
}

package br.ce.wcaquino.desconto;

public abstract class CalcularDesconto {
	
	private CalcularDesconto proximo;
	
	public CalcularDesconto(CalcularDesconto proximo) {
		this.proximo = proximo;
	}

	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if(desconto == -1) {
			return proximo.desconto(valorTotal);
			
		}
		return desconto;
		
	}
	
	protected abstract double calcular (double valorToral);
	
}
 
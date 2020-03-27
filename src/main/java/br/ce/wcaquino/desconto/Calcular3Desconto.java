package br.ce.wcaquino.desconto;

public class Calcular3Desconto extends CalcularDesconto {

	public Calcular3Desconto(CalcularDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal >= 1000.0) {
			return valorTotal * 0.08;
		
		}
		return -1;

	}
	
}
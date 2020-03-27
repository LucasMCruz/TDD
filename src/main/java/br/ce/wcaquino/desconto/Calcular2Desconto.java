package br.ce.wcaquino.desconto;

public class Calcular2Desconto extends CalcularDesconto {

	public Calcular2Desconto(CalcularDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal >= 800.0 && valorTotal < 1000) {
			return valorTotal * 0.06;
		
		}
		return -1;

	}
}
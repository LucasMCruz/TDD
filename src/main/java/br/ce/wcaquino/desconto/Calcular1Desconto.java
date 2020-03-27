package br.ce.wcaquino.desconto;

public class Calcular1Desconto extends CalcularDesconto{
	
	public Calcular1Desconto(CalcularDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal >= 300.0 && valorTotal < 800) {
			return valorTotal * 0.04;
		}
		
		return -1;

	}
}



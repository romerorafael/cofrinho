package uninter;

import java.text.DecimalFormat;

public class Real extends Moeda
{
	public Real(double valor) {
		super(valor);
	}

	//Função que mostra as informações específicas da moeda
	@Override
	public void Info() 
	{
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println( "R$" + df.format(valor) );
	}
	
	//Função que recebe a Moeda como parametro e retorna o valor em Real dela
	@Override
	public double Converter(Moeda moeda)
	{
		return moeda.valor;
	}
}

package uninter;

import java.text.DecimalFormat;

public class Euro extends Moeda{

	public Euro(double valor) {
		super(valor);
	}

	//Função que mostra as informações específicas da moeda
	@Override
	public void Info() 
	{
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println( "UU$" + df.format(valor) );
	}
	
	//Função que recebe a Moeda como parametro e retorna o valor em Real dela
	@Override
	public double Converter(Moeda moeda)
	{
		return moeda.valor * 7;
	}
	
}

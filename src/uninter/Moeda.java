package uninter;

//Classe abstrata que, utilizando as Heranças e Polimorfismos, servirá de base para todas as outros tipos de moedas
//Suas classes não são definidas porque sofrerão um sobreposição especifica para cada tipo de moeda
public abstract class Moeda {

	double valor;
	int id;
	
	public Moeda( double valor) 
	{
		this.valor = valor;
	}
	
	public abstract void Info();
	public abstract double Converter(Moeda moeda); 
	
	//Função sem retorno que printa na tela qual o Id da moeda e o seu valor.
	//Assim facilita a remoção da moeda certa ao utilizar a função RemoverMoeda(id) da classe Cofrinho.
	//Se utiliza da função Info() das classes filhas
	public void ShowAddInfo()
	{
		System.out.print("Moeda com id " + id + " e valor ");
		this.Info();
	}
	
}

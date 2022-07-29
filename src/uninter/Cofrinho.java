package uninter;

import java.util.ArrayList;

public class Cofrinho {

		int id = 1;
		
		//Cria um Array com a classe abstrata Moeda, assim podemos colocar qualquer uma das suas variações dentro do mesmo array.
		public ArrayList<Moeda> listaMoeda = new ArrayList<Moeda>();
		
		//Função que recebe uma Moeda (e suas variações) e adiciona ao cofrinho (array de moedas)
		public void AdicionarMoedas(Moeda moeda)
		{
			moeda.id = id++;
			
			listaMoeda.add(moeda);
			moeda.ShowAddInfo();
		}
		
		//Função que recebe um id de uma Moeda (e suas variações) especifica que é retirada do cofrinho (array de moedas)
		public void RemoverMoeda(int id)
		{
			Moeda moedaEncontrada = null;
			
			for(Moeda moeda : listaMoeda)
			{
				if(moeda.id == id)
				{
					moedaEncontrada = moeda;
					break;
				}
			}
			
			if(moedaEncontrada != null)
			{
				listaMoeda.remove(moedaEncontrada);
			}
			else
			{
				System.out.println("Nenhuma moeda corresponde a esse ID.");
			}
			
		}
		
		//Função simples que printa todas as moedas disponíveis dentro do cofrinho
		public void ListarMoedas()
		{
			for(Moeda moeda : listaMoeda)
			{
				System.out.print(moeda.id + " - ");
				moeda.Info();
			}
		}
		
		//Função que utiliza a função dentro da entidades filhas para fazer a conversão do valor para o Real e mostrar o valor total das moedas que estão no cofrinho (array de moedas).
		public double TotalConvertido()
		{
			double total = 0;
			
			for(Moeda moeda : listaMoeda)
			{
				total += moeda.Converter(moeda);
			}
			
			return total;
		}
}

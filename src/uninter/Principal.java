package uninter;

import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;

public class Principal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Scanner teclado = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00"); //Serve para manter a formatação dos numeros sempre com duas casas decimais, assim como o valor da moeda na vida real.
		
		Cofrinho cofrinho = new Cofrinho();
		int option = -1;
		int id;
		double valor;
		Moeda moeda;
		
		//Um loop que somente se encerra quando a opção "Sair" do Menu é selecionada
		//Dentro do loop também estão as chamadas para todas as ações pertinentes ao cofre.
		while (option != 7)
		{
			option = Menu(teclado);
			
			switch(option)
			{
				case 1:
					System.out.println("Quantos dolares?");
					valor = teclado.nextDouble();
					moeda = new Dolar(valor);
					cofrinho.AdicionarMoedas(moeda);
					break;
				case 2:
					System.out.println("Quantos reais?");
					valor = teclado.nextDouble();
					moeda = new Real(valor);
					cofrinho.AdicionarMoedas(moeda);
					break;
				case 3:
					System.out.println("Quantos euros?");
					valor = teclado.nextDouble();
					moeda = new Euro(valor);
					cofrinho.AdicionarMoedas(moeda);
					break;
				case 4:
					System.out.println("Qual o Id da moeda a ser retirada?");
					id = teclado.nextInt();
					cofrinho.RemoverMoeda(id);
					break;
				case 5:
					cofrinho.ListarMoedas();
					break;
				case 6:
					System.out.println("No cofrinho temos R$" + df.format(cofrinho.TotalConvertido()));
					break;
				case 7:
					System.out.println("Muito obrigado por usar nosso sistema.");
			}			
			teclado.nextLine();
		}
			
		teclado.close();
	}
	
	//Uma função que printa o Menu, limpa a tela e verifica se a opção escolhida é válida para os itens descritos.
	private static int Menu(Scanner teclado) throws InterruptedException, IOException
	{
		int option;
		
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Adicionar Dolar");
		System.out.println("2 - Adicionar Real");
		System.out.println("3 - Adicionar Euro");
		System.out.println("4 - Remover moeda pelo id");
		System.out.println("5 - Listar todas as moedas");
		System.out.println("6 - Total convertido em real");
		System.out.println("7 - Sair");
		
		try {
			option = teclado.nextInt();
		}catch(Exception  e)
		{
			System.out.println("Digite apenas números");
			ClearBuffer(teclado);
			option = teclado.nextInt();
		}
		
		
		if(option < 1 || option > 7)
		{
			System.out.println("Opção inválida, tente novamente");
			
			Menu(teclado);
		}

		return option;

	}
	
	//Função para limpar o Buffer do teclado, impedindo erros de sobreposição de caracteres, principalmente a tecla "Enter"
    private static void ClearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}

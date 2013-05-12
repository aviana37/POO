import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class DataManager
{
	private List <Usuario> Usuarios;
	private List <Produto> Produtos;
	private List <Servico> Servicos;
	private Scanner s;
	private String temp;
	
	public DataManager(Scanner scanner)
	{
		Usuarios = new ArrayList <Usuario>();
		Produtos = new ArrayList <Produto>();
		Servicos = new ArrayList <Servico>();
		s = scanner;		
	}
		
	public void cadastrarUsuario()
	{
		String name, cpf, email;
		Data today;
		Endereco address;

		temp = s.nextLine();
		System.out.print("--CADASTRAR USUARIO--\nEntre com o nome do usuario: ");
		name = s.nextLine();
		
		System.out.print("Entre com o CPF do usuario: ");
		cpf = s.nextLine();
		
		System.out.print("Entre com o email do usuario: ");
		email = s.nextLine();

		System.out.println("Entre com a data de hoje: ");
		{
			System.out.print("Dia: ");
			int day = s.nextInt();
			System.out.print("Mes: ");
			int month = s.nextInt();
			System.out.print("Ano: ");
			int year = s.nextInt();

			today = new Data(day, month, year);
		}

		System.out.println("Entre com o endereco do usuario: ");
		{
			temp = s.nextLine();
			System.out.print("Rua: ");
			String street = s.nextLine();
			System.out.print("Numero: ");
			int number = s.nextInt();
			System.out.print("Complemento: ");
			temp = s.nextLine();
			String apt = s.nextLine();
			System.out.print("Bairro: ");
			String district = s.nextLine();
			System.out.print("Cidade: ");
			String city = s.nextLine();
			System.out.print("Estado: ");
			String state = s.nextLine();
			System.out.print("CEP: ");
			String zip = s.nextLine();

			address = new Endereco(street, number, apt, district, city, state, zip);
		}

		Usuario usr = new Usuario(name, cpf, email, today, address);
		System.out.println("Usuario cadastrado com sucesso:\n" + usr);
		Usuarios.add(usr);
	}
	
	public void cadastrarProduto()
	{
	  temp = s.nextLine();
	  System.out.print("--CADASTRAR PRODUTO--\nEntre com o titulo do produto: ");
	  String titulo = s.nextLine();
	  
	  System.out.print("Entre com a descricao do produto: ");
	  String descricao = s.nextLine();
	  
	  System.out.print("Entre com o id do anunciante: ");
	  int user_id = s.nextInt();
	  
	  System.out.print("Entre com valor de venda: ");
	  float valor = s.nextFloat();
	  
	  temp = s.nextLine();
	  System.out.print("O produto e novo? s/n ");
	  char op = s.nextLine().charAt(0);
	  boolean novo;
	  if (op == 's' || op == 'S')
	   novo = true;
	  else novo = false;
	  
	  System.out.print("O produto possui nota fiscal? s/n ");
	  op = s.nextLine().charAt(0);
	  boolean nf;
	  if (op == 's' || op == 'S')
	   nf = true;
	  else nf = false;
	  
	  System.out.print("Entre com a quantidade de dias de garantia: ");
	  int garantia = s.nextInt();
	  
	  Produto pr = new Produto(user_id, titulo, descricao, valor, novo, nf, garantia);
	  Produtos.add(pr);
	  System.out.println("Produto cadastrado com sucesso:\n" + pr);
	}
	
	public void cadastrarServico()
	{
		temp = s.nextLine();
		System.out.print("--CADASTRAR SERVICO--\nEntre com o titulo do servico: ");
		String titulo = s.nextLine();
		  
		System.out.print("Entre com a descricao do servico: ");
		String descricao = s.nextLine();
		
		System.out.print("Entre com o id do anunciante: ");
		int user_id = s.nextInt();
		  
		System.out.print("Entre com valor de venda: ");
		float valor = s.nextFloat();
		  
		System.out.print("Entre com a data inicial:\nDia: ");
		int diaI = s.nextInt();
		System.out.print("Mes: ");
		int mesI = s.nextInt();
		System.out.print("Ano: ");
		int anoI = s.nextInt();
		
		System.out.print("Entre com a data final:\nDia: ");
		int diaF = s.nextInt();
		System.out.print("Mes: ");
		int mesF = s.nextInt();
		System.out.print("Ano: ");
		int anoF = s.nextInt();

		Servico serv = new Servico(user_id, titulo, descricao, valor, new Data(diaI, mesI, anoI), new Data(diaF, mesF, anoF));
		Servicos.add(serv);
		System.out.println("Servico cadastrado com sucesso:\n" + serv);
	}
	
	public boolean isUsuariosEmpty(){return Usuarios.isEmpty();}
	public boolean isProdutosEmpty(){return Produtos.isEmpty();}
	public boolean isServicosEmpty(){return Servicos.isEmpty();}
	public int usuariosSize(){return Usuarios.size();}
	public int produtosSize(){return Produtos.size();}
	public int servicosSize(){return Servicos.size();}
	
	public void exibirUsuarios()
	{
		if(isUsuariosEmpty())
		{
			System.out.println("Nao ha nenhum usuario cadastrado.");
			return;
		}
		System.out.println("---USUARIOS CADASTRADOS---");
		for(Usuario u : Usuarios)
		{
			System.out.println(u);
			System.out.println();
		}
	}
	
	public void exibirProdutos()
	{
		if(isProdutosEmpty())
		{
			System.out.println("Nao ha nenhum produto cadastrado.");
			return;
		}
		
		System.out.println("---ANUNCIOS DE PRODUTOS---");
		for(Produto p : Produtos)
		{
			System.out.println(p);
		}
	}
	public void exibirServicos()
	{
		if(isServicosEmpty())
		{
			System.out.println("Nao ha nenhum servico cadastrado.");
			return;
		}
		
		System.out.println("---ANUNCIOS DE SERVICOS---");
		for(Servico s : Servicos)
		{
			System.out.println(s);
		}
	}
	public void comprarAnuncio()
	{
		System.out.print("---COMPRAS DE ANUNCIOS---\n1 - Comprar um produto\n2 - Comprar um servico" 
				+ "\n0 - Voltar.");
		int op = s.nextInt();
		
		if (op == 0)
			return;
		else if (op == 1)
		{
			System.out.print("Entre com a ID do comprador: ");
			int id = s.nextInt();
			
			int count = 0;
			for (Usuario u: Usuarios)
			{
				if (u.getID() == id) count++;
			}
			if(count == 0)
			{
				System.out.print("Usuario inexistente.");
				return;
			}
			else count = 0;
			
			System.out.print("Entre com a ID do produto: ");
			int idP = s.nextInt();
			System.out.print("Pesquisando... ");
			
			for (Produto p : Produtos)
			{
				if (p.getId() == idP)
				{
					count++;
					System.out.print("\nProduto encontrado...");
					if (p.isAvailable())
					{
						System.out.print(" Efetuando compra...");
						p.setComprador(id);
						p.setIndisponivel();
						System.out.print(" Compra realizada com sucesso.\nProduto: " + p
										+ "\nPertence ao usuario de ID " + id + "\n");
					}
					
					else
						System.out.print(" Produto indisponivel.");
				}
			}
			
			if (count == 0)
				System.out.print("Produto nao encontrado.");
		}
		else if (op == 2)
		{
			System.out.print("Entre com a ID do comprador: ");
			int id = s.nextInt();
			
			int count = 0;
			for (Usuario u: Usuarios)
			{
				if (u.getID() == id) count++;
			}
			if(count == 0)
			{
				System.out.print("Usuario inexistente.");
				return;
			}
			else count = 0;
			
			System.out.print("Entre com a ID do servico: ");
			int idS = s.nextInt();
			System.out.print("Pesquisando... ");
			
			for (Servico p : Servicos)
			{
				if (p.getId() == idS)
				{
					count++;
					System.out.print("\nProduto encontrado...");

					System.out.print(" Efetuando compra...");
					p.adicionarComprador(id);
					System.out.print(" Compra realizada com sucesso.\nServico: " + p
										+ "\nContratado ao usuario de ID " + id + "\n");
				}
			}
			
			if (count == 0)
				System.out.print("Servico nao encontrado.");
		}
		
		else System.out.println("Opcao invalida!");
	}

	public void mostraRelatorio()
	{
		int option, usr;
		System.out.println("-- RELATORIOS --");
		do
		{
			System.out.println("1. Anuncios em andamento de todos os usuarios\n" +
							   "2. Anuncios em andamento de um usuario\n" +
							   "3. Anuncios vendidos por um usuario\n" +
							   "4. Anuncios comprados por um usuario\n" +
							   "5. Balanco de negociacoes de um usuario\n" +
							   "6. Informacoes pessoais de um usuario\n" +
							   "7. Voltar\n");
			System.out.print("Opcao >> ");
			option = s.nextInt();
			temp = s.nextLine();

			switch(option)
			{
				case 1:
				System.out.println("Produtos:");
				for(Produto p : Produtos)
					if(p.isAvailable()) System.out.println(p);
				System.out.println("Servicos:");
				for(Servico serv : Servicos)
					System.out.println(serv);
				break;

				case 2:
				System.out.print("Insira a ID do usuario >> ");
				usr = s.nextInt();
				temp = s.nextLine();

				System.out.println("Produtos:");
				for(Produto p : Produtos)
					if(p.getOwner() == usr && p.isAvailable())
						System.out.println(p);

				System.out.println("Servicos:");
				for(Servico serv : Servicos)
					if(serv.getOwner() == usr)
						System.out.println(serv);
				break;

				case 3:
				System.out.print("Insira a ID do usuario >> ");
				usr = s.nextInt();
				temp = s.nextLine();

				System.out.println("Produtos vendidos:");
				for(Produto p : Produtos)
					if(p.getOwner() == usr && !p.isAvailable())
						System.out.println(p);

				System.out.println("Servicos vendidos:");
				for(Servico serv : Servicos)
					if(serv.getOwner() == usr && serv.getCompradoresSize() > 0)
						System.out.println(serv);

				break;

				case 4:
				System.out.print("Insira a ID do usuario >> ");
				usr = s.nextInt();
				temp = s.nextLine();

				System.out.println("Produtos comprados:");
				for(Produto p : Produtos)
					if(p.getComprador() == usr)
						System.out.println(p);

				System.out.println("Servicos comprados:");
				for(Servico serv : Servicos)
					if(serv.isComprador(usr))
						System.out.println(serv);
				break;

				case 5:
				System.out.print("Insira a ID do usuario >> ");
				usr = s.nextInt();
				temp = s.nextLine();

				System.out.println("Produtos anunciados pelo usuario:");
				for(Produto p : Produtos)
					if(p.getOwner() == usr)
						System.out.println(p);
				System.out.println("Produtos adquiridos pelo usuario:");
				for(Produto p : Produtos)
					if(p.getComprador() == usr)
						System.out.println(p);

				System.out.println("Servicos anunciados pelo usuario:");
				for(Servico serv : Servicos)
					if(serv.getOwner() == usr)
						System.out.println(serv);
				System.out.println("Servicos adquiridos pelo usuario:");
				for(Servico serv : Servicos)
					if(serv.isComprador(usr))
						System.out.println(serv);
				break;

				case 6:
				System.out.print("Insira a ID do usuario >> ");
				usr = s.nextInt();
				temp = s.nextLine();

				for(Usuario u : Usuarios)
					if(u.getID() == usr)
					{
						System.out.println(u);
						break;
					}

				break;
			}
		}
		while(option != 7);
	}
	
}
class Program
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int op = -1;
		DataManager l = new DataManager(s);
		
		while (op!=0)
		{
			//Imprimir menu principal
				System.out.print("----MENU PRINCIPAL----\n"
						+ "\n1 - Cadastrar usuarios.");
			
				if (!l.isUsuariosEmpty())
				{
					System.out.print("\n2 - Cadastrar anuncios.");
				
					if (l.usuariosSize() > 1)
						if(l.produtosSize() > 0 ||l.servicosSize() > 0)
							System.out.print("\n3 - Realizar compras.");
					
					System.out.print("\n4 - Exibir Relatorios");
				}
				
				System.out.print("\n0 - Sair.\n");
				
				op = s.nextInt();
			
			//Executar de acordo com o input do usuario	
				if(op == 1)//Cadastrar Usuario
				{
					l.cadastrarUsuario();
				}

				else if (op == 2)//Cadastrar Anuncio
				{
					if (!l.isUsuariosEmpty())
					{
					//Selecionar o tipo de anuncio
					System.out.print("--CADASTRO DE ANUNCIOS--\n1 - Cadastrar um produto.\n2 - Cadastrar um servico."
							+ "\n0 - Voltar.");
					op = s.nextInt();
					
					if (op == 0)
						op = -1;
					
					else if (op == 1)//Cadastrar anuncio de um produto
						l.cadastrarProduto();
					
					else if (op == 2)//Cadastrar anuncio de um servico
						l.cadastrarServico();
					
					else 
						System.out.println("Opcao invalida!");
					
					}
				}
				else if (op == 3) //Realizar Compras
				{ 
					if (l.usuariosSize() > 1)
						if(l.produtosSize() > 0 ||l.servicosSize() > 0)
							l.comprarAnuncio();
				}
				else if (op == 4) //Exibir relatorios
				{
					if (l.isUsuariosEmpty())
						System.out.println("Nenhum usuario cadastrado!");
					else
						l.mostraRelatorio();
				}
				
				else if (op == 5) //Exibir Anuncios
				{
					System.out.println("---EXIBICAO DE ANUNCIOS---\n1 - Todos.\n2 - Somente produtos.\n3 - Somente servicos."
							+ "\n0 - Voltar.");
					op = s.nextInt();
					
					if (op == 0)
						op = -1;
					
					else if (op == 1)
					{
						l.exibirProdutos();
						l.exibirServicos();
					}
					
					else if (op == 2) { l.exibirProdutos();}
					else if (op == 3) { l.exibirServicos();}
					else System.out.println("Opcao invalida!");
				}
				else if (op == 0) //Sair do programa
				{}
				
				else 
					System.out.println("Opcao invalida!");
			}
		
		s.close();
	}
}




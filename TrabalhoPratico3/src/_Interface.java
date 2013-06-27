//ECO030 - TP3
//Andre Viana 25037
import java.util.InputMismatchException;
import java.util.Scanner;

public class _Interface
{
	private Scanner ent;
	private Excecoes DenominadorInvalidoException;
	private Excecoes ListaVaziaException;
	private Excecoes CancelException;
	private Almoxarifado Almo;
	
	public _Interface()
	{
		ent = new Scanner(System.in);
		Almo = new Almoxarifado();
		DenominadorInvalidoException = new Excecoes("-->Denominador invalido!");
		ListaVaziaException = new Excecoes("-->Nenhum numero desse tipo foi utilizado recentemente.");
		CancelException = new Excecoes("-->CANCELAR.");
	}
	public int nextInt()
	{
		int rtrn = 0;
		boolean err = false;
		do{
			try
			{
				rtrn = ent.nextInt();
				err = false;
			}catch(InputMismatchException e)
			{
				System.out.print("ERRO! Entre com um valor numerico inteiro.\n--> ");
				ent.next();
				err = true;
			}
		}while(err);
		
		return rtrn;
	}
	public Fracao nextFracao()
	{
		boolean err = false;
		int numerador, denominador = 1;
		
		System.out.print("Entre com o numerador: ");
		numerador = nextInt();
		
		do
		{
			try
			{
				System.out.print("Entre com o denominador: ");
				denominador = nextInt();
				
				if(denominador == 0)
					throw DenominadorInvalidoException;
				else 	
					err = false;
			}catch(Excecoes e)
			{
				err = true;
				System.out.println(e);
			}
		}while(err);
		
		return new Fracao(numerador, denominador);
	}
	public NumeroComplexo nextNC()
	{
		int a,b;
		boolean err = false;
		
		do
		{
			System.out.print("Entre com o valor de a: ");
			a = nextInt();
			System.out.print("Entre com o valor de b: ");
			b = nextInt();
			
			if((a+b)==0)
			{
				System.out.println("Valor nulo!");
				err = true;
			}
			else
				err = false;
		}while(err);
		
		return new NumeroComplexo(a,b);
	}

	private void submenu1()//Menu para adicao de um numero complexo na lista de numeros recentes.
	{
		System.out.println("--- Adicionar um numero complexo ---");
		Almo.addNumeroComplexo(nextNC());
		System.out.print("\n");
	}
	private void submenu2()//Menu para adicao de uma fracao na lista de numeros recentes.
	{
		System.out.println("--- Adicionar uma fracao ---");
		Almo.addFracao(nextFracao());
		System.out.print("\n");
	}
	private void submenu31(int operacao)//Submenu responsavel por executar e mostrar os resultados das operacoes na tela.
	{
		int op = -1;
		boolean pass;
		TipoNumerico termo[] = new TipoNumerico[3];
		
		try
		{
			do
			{
				switch(operacao)//Seleciona o header adequado.
				{
					case 1:
						System.out.println("\t--- Adicao ---");
						break;
					case 2:
						System.out.println("\t--- Subtracao ---");
						break;
					case 3:
						System.out.println("\t--- Multiplicacao ---");
						break;
					case 4:
						System.out.println("\t--- Divisao ---");
						break;
					default:
						System.out.println("Operacao invalida.");
						break;
				}
				
				//Menu primario.
				System.out.print("01 - Inserir novo primeiro termo.\n" +
						 		 "02 - Inserir numero ja adicionado.\n"+
						 		 "03 - Listar numeros recentes.\n" +
						 		 "00 - Cancelar.\n--> ");
				op = nextInt();
		
				
				switch(op)
				{
					case 1://Inserir um novo primeiro termo.
						do
						{
							System.out.print("--- Inserir primeiro termo ---\n" +
											 "01 - Fracao.\n" +
											 "02 - Numero Complexo.\n" +
											 "00 - Cancelar.\n--> ");
							op = nextInt();
							
							pass = true;
							switch(op)
							{
								case 1:
									termo[0] = nextFracao();
									Almo.addFracao((Fracao)termo[0]);
									break;
								case 2:
									termo[0] = nextNC();
									Almo.addNumeroComplexo((NumeroComplexo)termo[0]);
									break;
								case 0:
									throw CancelException;
								default:
									pass = false;
									System.out.println("-->Opcao invalida!");
							}
						}while(!pass);
						break;
					case 2://Utilizar um termo da lista de numeros recentes.
						do
						{
							System.out.print("--- Inserir primeiro termo ---\n" +
											 "01 - Fracao.\n" +
											 "02 - Numero Complexo.\n" +
											 "00 - Cancelar.\n--> ");
							op = nextInt();
							pass = true;
							
							switch(op)
							{
								case 1:
									if(Almo.isListaFracaoEmpty())
										throw ListaVaziaException;
									else
									{
										System.out.print("Entre com a id do numero. " +
														 "(Use a opcao listar em caso de " +
														 "duvidas ou 0 para cancelar)\n--> ");
										op = nextInt();
										
										if(op>Almo.Fracoes() || op < 0)
										{
											pass = false;
											System.out.println("-->Id invalida!");
										}
										else if(op == 0) 
											throw CancelException;
										else
										{	
											termo[0]=Almo.buscaFracao(op-1);
											System.out.print("--> " + termo[0] + "\n");
											pass = true;
										}
									}
									break;
								case 2:
									if(Almo.isListaNumeroComplexoEmpty())
										throw ListaVaziaException;
									else
									{
										System.out.print("Entre com a id do numero. " +
													 	 "(Use a opcao listar em caso de " +
													 	 "duvidas ou 0 para cancelar)\n--> ");
										op = nextInt();
									
										if(op>Almo.NumerosComplexos() || op < 0)
										{
											pass = false;
											System.out.println("-->Id invalida!");
										}
										else if(op == 0)
											throw CancelException;
										else
										{	
											termo[0]=Almo.buscaNumeroComplexo(op-1);
											System.out.print("--> " + termo[0] + "\n");
											pass = true;
										}
									}
									break;
								case 0:
									throw CancelException;
								default:
									pass = false;
									System.out.println("-->Opcao invalida!");
							}
						}while(!pass);
						break;
					case 3:
						submenu5();
						pass = false;
						break;
					case 0:
						throw CancelException;
					default:
						pass = false;
						System.out.println("-->Opcao invalida!");
				}
			}while(!pass);
			
			do//Insercao do segundo termo.
			{
				System.out.print("01 - Inserir novo segundo termo.\n"+
								 "02 - Inserir numero ja adicionado.\n"+
								 "03 - Listar numeros recentes.\n" +
								 "00 - Cancelar.\n--> ");
				op = nextInt();
				
				switch(op)
				{
					case 1://Inserir um novo numero.
						do
						{
							System.out.print("--- Inserir segundo termo ---\n" +
											 "01 - Fracao.\n" +
											 "02 - Numero Complexo.\n" +
											 "00 - Cancelar.\n--> ");
							op = nextInt();
							
							pass = true;
							switch(op)
							{
								case 1:
									termo[1] = nextFracao();
									Almo.addFracao((Fracao)termo[1]);
									break;
								case 2:
									termo[1] = nextNC();
									Almo.addNumeroComplexo((NumeroComplexo)termo[1]);
									break;
								case 0:
									throw CancelException;
								default:
									pass = false;
									System.out.println("-->Opcao invalida!");
							}
						}while(!pass);
						break;
					case 2://Inserir um numero recente
						do
						{
							System.out.print("--- Inserir segundo termo ---\n" +
											 "01 - Fracao.\n" +
											 "02 - Numero Complexo.\n" +
											 "00 - Cancelar.\n--> ");
							op = nextInt();
							pass = true;
							
							switch(op)
							{
								case 1:
									if(Almo.isListaFracaoEmpty())
										throw ListaVaziaException;
									else
									{
										System.out.print("Entre com a id do numero. " +
														 "(Use a opcao listar em caso de " +
														 "duvidas ou 0 para cancelar)\n--> ");
										op = nextInt();
										
										if(op>Almo.Fracoes() || op < 0)
											pass = false;
										else if(op == 0)
											throw CancelException;
										else
										{	
											termo[1]=Almo.buscaFracao(op-1);
											System.out.print("--> " + termo[1] + "\n");
											pass = true;
										}
									}
									break;
								case 2:
									if(Almo.isListaNumeroComplexoEmpty())
										throw ListaVaziaException;
									else
									{
										System.out.print("Entre com a id do numero. " +
													 	 "(Use a opcao listar em caso de " +
														 "duvidas ou 0 para cancelar)\n--> ");
										op = nextInt();
									
										if(op>Almo.NumerosComplexos() || op < 0)
											pass = false;
										else if(op == 0)
											throw CancelException;
										else
										{	
											termo[1]=Almo.buscaNumeroComplexo(op-1);
											pass = true;
										}
									}
									break;
								case 0:
									throw CancelException;
								default:
									pass = false;
									System.out.println("Opcao invalida!");
							}
					}while(!pass);
					break;
				case 3:
					submenu5();
					pass = false;
					break;
				case 0:
					throw CancelException;
				default:
					pass = false;
					System.out.println("-->Opcao invalida!");
			}
			}while(!pass);
		
			System.out.print("-->CALCULANDO...\n-->");
			
			switch(operacao)//SELECIONA A OPERACAO DE ACORDO COM O QUE FOI SELECIONADO NO MENU
			{
				case 1://Adicao
					System.out.print(termo[0]+ " + " + termo[1] + " = ");
					
					if(termo[0] instanceof Fracao && termo[1] instanceof Fracao)
						termo[2] = termo[0].Adicao((Fracao)termo[1]);
					
					else if (termo[0] instanceof Fracao)
						termo[2] = termo[0].Adicao((NumeroComplexo)termo[1]);
					
					else if(termo[1] instanceof Fracao)
						termo[2] = termo[0]._Adicao((Fracao)termo[1]);
					
					else
						termo[2] = termo[0].Adicao((NumeroComplexo)termo[1]);
			
					break;
				case 2://Subtracao
					System.out.print(termo[0]+ " - " + termo[1] + " = ");
					
					if(termo[0] instanceof Fracao && termo[1] instanceof Fracao)
						termo[2] = termo[0].Subtracao((Fracao)termo[1]);
					
					else if (termo[0] instanceof Fracao)
						termo[2] = termo[0].Subtracao((NumeroComplexo)termo[1]);
					
					else if(termo[1] instanceof Fracao)
						termo[2] = termo[0]._Subtracao((Fracao)termo[1]);
					
					else
						termo[2] = termo[0].Subtracao((NumeroComplexo)termo[1]);
					
					break;
				case 3://Multiplicacao
					System.out.print(termo[0]+ " * " + termo[1] + " = ");
					
					if(termo[0] instanceof Fracao && termo[1] instanceof Fracao)
						termo[2] = termo[0].Multiplicacao((Fracao)termo[1]);
					
					else if (termo[0] instanceof Fracao)
						termo[2] = termo[0].Multiplicacao((NumeroComplexo)termo[1]);
					
					else if(termo[1] instanceof Fracao)
						termo[2] = termo[0]._Multiplicacao((Fracao)termo[1]);
					
					else
						termo[2] = termo[0].Multiplicacao((NumeroComplexo)termo[1]);
					break;
				case 4://Divisao
					System.out.print(termo[0]+ " / " + termo[1] + " = ");
					
					if(termo[0] instanceof Fracao && termo[1] instanceof Fracao)
						termo[2] = termo[0].Divisao((Fracao)termo[1]);
					
					else if (termo[0] instanceof Fracao)
						termo[2] = termo[0].Divisao((NumeroComplexo)termo[1]);
					
					else if(termo[1] instanceof Fracao)
						termo[2] = termo[0]._Divisao((Fracao)termo[1]);
					
					else
						termo[2] = termo[0].Divisao((NumeroComplexo)termo[1]);
					break;
			}
			
			if(termo[2] instanceof Fracao)
				Almo.addFracao((Fracao)termo[2]);
			else if(termo[2]instanceof NumeroComplexo)
				Almo.addNumeroComplexo((NumeroComplexo)termo[2]);
			
			System.out.print(termo[2]+"\n");
			
		}catch(Excecoes e)//O método para imediatamente caso algum erro aconteca.
		{
			System.out.println(e);
		}
		System.out.print("\n");
	}
	private void submenu3()//menu de operacoes(seleciona a operacao para o menu secundario executar)
	{
		int op = -1;
		boolean pass;
		try
		{
			do
			{
				System.out.print("--- Operacoes entre numeros ---\n" +
								 "01 - Adicao.\n" +
								 "02 - Subtracao.\n" +
								 "03 - Multiplicacao.\n" +
								 "04 - Divisao.\n" +
								 "00 - Cancelar\n--> ");
				op = nextInt();
				pass = true;
				switch(op)
				{
					case 1:
						submenu31(1);
						break;
					case 2:
						submenu31(2);
						break;
					case 3:
						submenu31(3);
						break;
					case 4:
						submenu31(4);
						break;
					case 0:
						throw CancelException;
					default:
						System.out.println("-->Opcao invalida.");
						pass = false;
						break;
				}
			}while(!pass);
		}catch(Excecoes e)
		{
			System.out.println(e);
		}
	}
	private void submenu4()//Menu de ordenacao
	{
		int op = -1;
		boolean pass;
		try
		{
			do
			{
				System.out.print("--- Ordenar numeros ---\n" + 
								 "01 - Numeros Complexos.\n" +
								 "02 - Fracoes.\n" +
								 "03 - Todos.\n00 - Cancelar\n--> ");
				op = nextInt();
				pass = true;
				switch(op)
				{
					case 1:
						System.out.print("-->Ordenando numeros complexos...\n");
						Almo.sortNumeroComplexo();
						break;	
					case 2:
						System.out.print("-->Ordenando fracoes...\n");
						Almo.sortFracao();
						break;
					case 3:
						System.out.print("-->Ordenando todos os numeros...\n");
						Almo.sortFracao();
						Almo.sortNumeroComplexo();
						break;
					case 0:
						throw CancelException;
					default:
						System.out.println("-->Opcao invalida.");
						pass = false;
						break;
				}
			}while(!pass);
		}catch(Excecoes e){	System.out.println(e);}
	}
	private void submenu5()//Menu de listas
	{
		int op = -1;
		boolean pass;
		
		try
		{
			do
			{
				System.out.print("--- Listar elementos ---\n" +
								 "01 - Somente numeros complexos.\n" +
								 "02 - Somente numeros fracionarios.\n" +
								 "03 - Todos.\n00 - Cancelar.\n--> ");
				op = nextInt();
				pass = true;
				
				switch(op)
				{
					case 1:
						Almo.listarNumeroComplexo();
						System.out.println("\t\t-");
						break;
					case 2:
						Almo.listarFracao();
						System.out.println("\t\t-");
						break;
					case 3:
						Almo.listarNumeroComplexo();
						System.out.print("\t\t\t-\n");
						Almo.listarFracao();
						break;
					case 0:
						throw CancelException;				
					default:
						System.out.println("-->Opcao invalida.");
						pass = false;
						break;
				}
			}while(!pass);
		}catch(Excecoes e){ System.out.println(e);}
	}
	
	
	public void menu()//Menu principal.
	{
		int op = -1;
		
		do
		{
			System.out.print("\t--MENU PRINCIPAL--\n" +
							 "01 - Inserir um numero complexo.\n" +
							 "02 - Inserir uma fracao.\n" +
							 "03 - Operar dois numeros.\n" +
							 "04 - Ordenar os numeros.\n" +
							 "05 - Listar os numeros.\n" +
							 "00 - Sair.\n--> ");
			op = nextInt();
			
			switch(op)
			{
				case 1:
					submenu1();
					break;
				case 2:
					submenu2();
					break;
				case 3:
					submenu3();
					break;
				case 4:
					submenu4();
					break;
				case 5:
					submenu5();
					break;
				case 0:
					System.out.println("-->SAIR...");
					break;
				default:
					System.out.println("-->Opcao invalida.");
					break;
			}
		}while(op!=0);
	}
}

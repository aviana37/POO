//ECO030 - TP3
//Andre Viana 25037
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Almoxarifado
{
	private List<Fracao> ListaFracao;
	private List<NumeroComplexo> ListaNumeroComplexo;
	
	public Almoxarifado()
	{
		ListaFracao = new ArrayList<Fracao>();
		ListaNumeroComplexo = new ArrayList<NumeroComplexo>();
	}
	public boolean isListaFracaoEmpty(){	return ListaFracao.isEmpty();}
	public boolean isListaNumeroComplexoEmpty(){	return ListaNumeroComplexo.isEmpty();}
	public int Fracoes(){	return ListaFracao.size();}
	public int NumerosComplexos(){	return ListaNumeroComplexo.size();}
	public void addFracao(Fracao a){	ListaFracao.add(a);}
	public void addNumeroComplexo(NumeroComplexo a){	ListaNumeroComplexo.add(a);}
	public Fracao buscaFracao(int index){	return ListaFracao.get(index);}
	public NumeroComplexo buscaNumeroComplexo(int index){	return ListaNumeroComplexo.get(index);}
	
	public void sortFracao()
	{
		FracaoComparator comparador = new FracaoComparator();
		Collections.sort(ListaFracao, comparador);
	}
	public void sortNumeroComplexo()
	{
		NumeroComplexoComparator comparador = new NumeroComplexoComparator();
		Collections.sort(ListaNumeroComplexo, comparador);
	}
	public void listarFracao()
	{
		if(!ListaFracao.isEmpty())
		{
			int i = 1;
			System.out.print("\t--- Fracoes ---\n");
			for(Fracao f : ListaFracao)
			{
				System.out.print(i + "-> " + f + "\t");
				i++;
			}
			System.out.print("\n");
		}
		else
			System.out.println("Nenhuma fracao foi utilizada recentemente.");
	}
	public void listarNumeroComplexo()
	{
		if(!ListaNumeroComplexo.isEmpty())
		{
			int i = 1;
			System.out.print("\t--- Numeros Complexos ---\n");
			for(NumeroComplexo nc : ListaNumeroComplexo)
			{
				System.out.print(i + "-> " + nc + "\t");
				i++;
			}
			System.out.print("\n");
		}
		else
			System.out.println("Nenhum numero complexo foi utilizado recentemente.");
	}
}

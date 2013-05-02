import java.util.List;
import java.util.ArrayList;

class Anuncio
{
	protected int    id, user_id;
	protected String titulo, descricao;
	protected float  valor;

	protected Anuncio(int id, int user_id, String titulo, String descricao, float valor)
	{
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getOwner() { return user_id; }
	public int getId(){return id;}
}

class Produto extends Anuncio
{
	private static int instances;
	private boolean    novo, nfiscal, disponivel;
	private int userWhoBought, garantia;

	public Produto(int Usuario, String titulo, String descricao, float valor, boolean novo, boolean nfiscal, int garantia)
	{
		super(++instances, Usuario, titulo, descricao, valor);

		this.novo = novo;
		this.nfiscal = nfiscal;
		this.garantia = garantia;
		disponivel = true;
	}

	public boolean isAvailable() { return disponivel; }
	public void setIndisponivel() { disponivel = false; }
	public void setComprador(int id) { userWhoBought = id; }
	public int  getComprador() { if(!disponivel) return userWhoBought; else return -1; }
	public String toString()
	{
		String ret;
		ret = "Titulo: " + titulo + "\tID: " + id + "\tAnunciante: " + user_id + "\nDescricao: " + descricao 
				+ "\nPreco: R$" + valor + "\tEstado: ";
		
		if (novo) ret += "Novo";
		else ret += "Usado";
		
		ret+= "\tNota Fiscal: ";
		
		if (nfiscal) ret +="Sim";
		else ret += "Nao";
		
		if (disponivel) ret+="\tDISPONIVEL.";
		else ret+="\tProduto indisponivel.";
		
		ret+="\nDias de garantia: " + garantia;
		return ret;
	}
}

class Servico extends Anuncio
{
	private static int instances;
	private Data comeco, fim;
	private List <Integer> compradores;
	
	public Servico(int Usuario, String titulo, String descricao, float valor, Data comeco, Data fim)
	{
		super(++instances, Usuario, titulo, descricao, valor);

		this.comeco = comeco;
		this.fim = fim;
		compradores = new ArrayList<Integer>();
	}
	public String toString()
	{
		return "Titulo: " + titulo + "\tID: " + id + "\tAnunciante: " + user_id + "\nDescricao: " + descricao 
				+ "\nPreco: R$" + valor + "\tData inicial: " + comeco +  "\tData termino" + fim;
	}
	public void adicionarComprador(int comprador)
	{
		compradores.add(comprador);
	}
	public int getCompradoresSize()
	{
		return compradores.size();
	}
	public void exibirCompradores()
	{
		System.out.println("#" + compradores.size() + " Compradores.");
		for (Integer i : compradores)
		{
			System.out.println("ID: " + i);
		}
	}
}



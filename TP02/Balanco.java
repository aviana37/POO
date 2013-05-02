// APAGAR!

class Balanco
{
	private int[] compras;
	private int[] vendas;
	private int[] anuncios;
	
	private void add(int[] array, int num)
	{
		if(array == null)
		{
			array = new int[1];
			array[0] = num;
			return;
		}
		
		int[] aux = new int[array.length + 1];
		
		for(int i = 0; i < array.length; i++)
			aux[i] = array[i];
		
		aux[array.length] = num;
		array = aux;
	}
	
	public void AddCompra(int id)
	{
		add(compras, id);
	}
	
	public void AddVenda(int id)
	{
		add(vendas, id);
	}
	
	public void AddAnuncio(int id)
	{
		add(anuncios, id);
	}
	
	public int getCompra(int index)
	{
		if(compras == null) return -1;
		return compras[index];
	}
	
	public int getVenda(int index)
	{
		if(vendas == null) return -1;
		return vendas[index];
	}
	
	public int getAnuncio(int index)
	{
		if(anuncios == null) return -1;
		return anuncios[index];
	}
	
	public int nCompras()
	{
		if(compras == null) return 0;
		return compras.length;
	}
	public int nVendas()
	{
		if(vendas == null) return 0;
		return vendas.length;
	}
	public int nAnuncios()
	{
		if(anuncios == null) return 0;
		return anuncios.length;
	}
}

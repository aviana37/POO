//ECO030 - TP3
//Andre Viana 25037
public class Excecoes extends Throwable
{
	String rtrn;
	
	public Excecoes(String retorno)
	{
		rtrn = retorno;
	}
	public String toString()
	{
		return rtrn;
	}
}

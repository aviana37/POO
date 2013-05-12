// Trabalho de ECO030 - TP02
// Andre Viana  - 25037
// Lucas Vieira - 24072

public class Data 
{
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano)
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia(){return dia;}
	public int getMes(){return mes;}
	public int getAno(){return ano;}
	public static boolean IsValid(Data d)
	{
		if (d.getDia() < 1 || d.getMes() < 1 || d.getAno() < 1)
			return false;
		else
		{
			if (d.getDia() > 31) {return false;}
			else if (d.getMes() > 12) {return false;}
			else if (d.getMes() == 2 || d.getMes() == 4 || d.getMes() == 6
					|| d.getMes() == 9 || d.getMes() == 11)
			{
				if(d.getMes() == 2 && d.getDia() > 29) {return false;}
				else if (d.getDia() == 31) {return false;}
			}
		}
		return true;
	}
	public String toString()
	{
		return dia + "/" + mes + "/" + ano;
	}
}

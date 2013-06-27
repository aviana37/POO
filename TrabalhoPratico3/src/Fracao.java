//ECO030 - TP3
//Andre Viana 25037
import java.util.Comparator;

class FracaoComparator implements Comparator<Fracao>
{
	public int compare(Fracao a, Fracao b)
	{
		if(a.Decimal() > b.Decimal())
			return +1;
		else if(a.Decimal() < b.Decimal())
			return -1;
		return 0;
	}
	
}

class Fracao extends TipoNumerico
{
	private int _Numerador, _Denominador;
	public String toString()
	{
		if(_Denominador == 1)
			return _Numerador+"";
		
		return _Numerador + "/" + _Denominador;
	}
	public static int MMC(int a, int b)
	{
		if(b % a == 0 && a!=b)
			return a;
		else if(a % b == 0 && b!=a)
			return b;
	
		return a*b;
	}
	public static Fracao Converter(int a){	return new Fracao(a, 1);}
	
	public Fracao(int numerador, int denominador)
	{
		_Numerador = numerador;
		_Denominador = denominador;
	}
	public int Numerador(){	return _Numerador;}
	public int Denominador(){	return _Denominador;}
	public float Decimal(){	return (float)_Numerador/_Denominador;}
	
	
	public Fracao Adicao(Fracao b)
	{
		if(_Denominador == b.Denominador())
			return new Fracao((_Numerador+b.Numerador()), _Denominador);
		
		int mmc = Fracao.MMC(_Denominador, b.Denominador());
		return new Fracao(((mmc/_Denominador)*_Numerador)+((mmc/b.Denominador())*b.Numerador()), mmc);
	}
	public Fracao Subtracao(Fracao b)
	{
		if(_Denominador == b.Denominador())
			return new Fracao((_Numerador-b.Numerador()), _Denominador);
		
		int mmc = Fracao.MMC(_Denominador, b.Denominador());
		return new Fracao(((mmc/_Denominador)*_Numerador)-((mmc/b.Denominador())*b.Numerador()), mmc);
	}
	public Fracao Multiplicacao(Fracao b){	return new Fracao(_Numerador*b.Numerador(), _Denominador*b.Denominador());}
	public Fracao Divisao(Fracao b){	return new Fracao(_Numerador*b.Denominador(), _Denominador*b.Numerador());}
	
	
	public NumeroComplexo Adicao(NumeroComplexo b)
	{
		return new NumeroComplexo(b.a().Adicao(new Fracao(_Numerador,_Denominador)), b.b());
	}
	public NumeroComplexo Subtracao(NumeroComplexo b)
	{
		return new NumeroComplexo(b.a().Subtracao(new Fracao(_Numerador,_Denominador)), b.b());
	}
	public NumeroComplexo Multiplicacao(NumeroComplexo b)
	{
		return new NumeroComplexo(new Fracao(_Numerador, _Denominador).Multiplicacao(b.a()),
								  new Fracao(_Numerador, _Denominador).Multiplicacao(b.b()));
	}
	public NumeroComplexo Divisao(NumeroComplexo b)
	{
		return new NumeroComplexo(new Fracao(_Numerador, _Denominador).Divisao(b.a()),
								  new Fracao(_Numerador, _Denominador).Divisao(b.b()));
	}
}

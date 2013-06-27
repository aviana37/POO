//ECO030 - TP3
//Andre Viana 25037
import java.util.Comparator;

class NumeroComplexoComparator implements Comparator<NumeroComplexo>
{
	public int compare(NumeroComplexo a, NumeroComplexo b)
	{
		float _a = (float) Math.sqrt(Math.pow(a.a().Decimal(), 2)+Math.pow(a.a().Decimal(), 2));
		float _b = (float) Math.sqrt(Math.pow(b.a().Decimal(), 2)+Math.pow(b.a().Decimal(), 2));
		
		if(_a > _b)
			return +1;
		else if(_a < _b)
			return -1;
		return 0;
	}
}

class NumeroComplexo extends TipoNumerico
{
	private Fracao _a, _b;
	public String toString()
	{
		if (_a.Decimal() == 0 && _b.Decimal()==1)
			return "i";
		if (_a.Decimal() == 0)
			return _b + "i";
		if (_b.Decimal() == 1)
			return _a + " + i";
		return _a + " + " + _b + "i";
	}

	public NumeroComplexo(Fracao a, Fracao b)
	{
		_a = a;
		_b = b;
	}
	public NumeroComplexo(int a, int b)
	{
		_a = Fracao.Converter(a);
		_b = Fracao.Converter(b);
	}
	public Fracao a(){return _a;}
	public Fracao b(){return _b;}
	
	
	public NumeroComplexo Adicao(NumeroComplexo b){	return new NumeroComplexo(_a.Adicao(b.a()), _b.Adicao(b.b()));}
	public NumeroComplexo Subtracao(NumeroComplexo b){	return new NumeroComplexo(_a.Subtracao(b.a()), _b.Subtracao(b.b()));}
	public NumeroComplexo Multiplicacao(NumeroComplexo b)
	{
		return new NumeroComplexo((_a.Multiplicacao(b.a()).Adicao((_b.Multiplicacao(b.b())))),
								  (_a.Multiplicacao(b.b()).Adicao((_b.Multiplicacao(b.a())))));
	}
	public NumeroComplexo Divisao(NumeroComplexo b)
	{
		Fracao Denominador = b.a().Multiplicacao(b.a()).Adicao(b.b().Multiplicacao(b.b()));
		
		return new NumeroComplexo(_a.Multiplicacao(b.a()).Adicao(_b.Multiplicacao(b.b())).Divisao(Denominador),
								  b.a().Multiplicacao(_b).Subtracao(_a.Multiplicacao(b.b())).Divisao(Denominador));
	}
	
	
	public NumeroComplexo _Adicao(Fracao b){	return new NumeroComplexo(_a.Adicao(b), _b);}
	public NumeroComplexo _Subtracao(Fracao b){	return new NumeroComplexo(_a.Subtracao(b), _b);}
	public NumeroComplexo _Multiplicacao(Fracao b){	return new NumeroComplexo(_a.Multiplicacao(b), _b.Multiplicacao(b));}
	public NumeroComplexo _Divisao(Fracao b){	return new NumeroComplexo(_a.Divisao(b),_b.Divisao(b));}
}

//ECO030 - TP3
//Andre Viana 25037

public abstract class TipoNumerico
{
	public Fracao Adicao(Fracao b){ return new Fracao(0,0); }
	public Fracao Subtracao(Fracao b){ return new Fracao(0,0);}
	public Fracao Multiplicacao(Fracao b){ return new Fracao(0,0);}
	public Fracao Divisao(Fracao b){ return new Fracao(0,0);}
	
	public NumeroComplexo Adicao(NumeroComplexo b){return new NumeroComplexo(0,0);}
	public NumeroComplexo Subtracao(NumeroComplexo b){return new NumeroComplexo(0,0);}
	public NumeroComplexo Multiplicacao(NumeroComplexo b){return new NumeroComplexo(0,0);}
	public NumeroComplexo Divisao(NumeroComplexo b){return new NumeroComplexo(0,0);}
	
	public NumeroComplexo _Adicao(Fracao b){return new NumeroComplexo(0,0);}
	public NumeroComplexo _Subtracao(Fracao b){return new NumeroComplexo(0,0);}
	public NumeroComplexo _Multiplicacao(Fracao b){return new NumeroComplexo(0,0);}
	public NumeroComplexo _Divisao(Fracao b){return new NumeroComplexo(0,0);}
	
}

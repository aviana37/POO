// Trabalho de ECO030 - TP02
// Andre Viana  - 25037
// Lucas Vieira - 24072

class Endereco
{
    private String Rua, Complemento, Bairro,
                  Cidade, Estado, CEP;
    private int Numero;

	public Endereco(String rua, int numero, String complemento, String bairro, String cidade, String estado, String cep)
	{
		Rua = rua;       Numero = numero; Complemento = complemento; Bairro = bairro;
		Cidade = cidade; Estado = estado; CEP = cep;
	}
    
    public String toString()
    {
    	return ("Rua " + Rua + " " + Numero + " " + Complemento + "\n" +
    		   Bairro + ", " + Cidade + ", " + Estado + " - " + CEP); 
    }
}

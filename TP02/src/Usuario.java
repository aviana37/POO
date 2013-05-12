// Trabalho de ECO030 - TP02
// Andre Viana  - 25037
// Lucas Vieira - 24072

class Usuario
{
	private static int instances;
	private int id;
	private String nome, cpf, email;
	private Data data;
	private Endereco endereco;
	
	public Usuario(String Nome, String CPF, String Email, Data data, Endereco endereco)
	{
		nome = Nome; cpf = CPF; email = Email; this.data = data;
		this.endereco = endereco;
		id = ++instances;
	}

	public int getID() { return id; }

	public String toString()
	{
		return nome + " - ID " + id + "\n" +
		       email + " CPF: " + cpf + "\n" +
		       "Cadastrado em " + data + "\n" +
		       "Endereco:\n" + endereco;
	}
}


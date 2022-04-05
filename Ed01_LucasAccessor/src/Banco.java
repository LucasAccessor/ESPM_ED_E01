
public class Banco {
	String nome, cpf;
	double saldo;

	
	public Banco(String nome, String cpf, double saldo) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Banco aux = (Banco) obj;
		if(aux.cpf == cpf) {
			return true;
		} else {
			return false;
		}	
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += "CPF: " + cpf + "\n";
		aux += "Nome: " + nome + "\n";
		aux += "Saldo: " + saldo + "\n";
		return aux;
	}
}

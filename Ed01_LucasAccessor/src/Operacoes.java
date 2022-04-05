import javax.swing.JOptionPane;

public class Operacoes {
	static Lista<Banco> lista = new Lista<Banco>();
	
	
	public static void abertura() {
		String nome, cpf;
		double saldo;
		boolean found = false;
		
		cpf = JOptionPane.showInputDialog("Informe o CPF: ");
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		saldo = 0;
		
		No<Banco> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.cpf.equals(cpf)) {
				found = true;
			}
			aux = aux.dir;
		}
		
		if(found == true) {
			JOptionPane.showMessageDialog(null, "Erro, conta já cadastrada");
		} else {
			Banco contaOK = new Banco(nome, cpf, saldo);
			lista.inserir(contaOK);
		}
	}
	
	public static void relatar() {
		No<Banco> aux = lista.com;
		String impressao = "";
		while(aux != null) {
			impressao += aux.dado.toString();
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, impressao);
	}
	
	public static void encerramento() {
		String cpf;
		boolean found = false;
		
		cpf = JOptionPane.showInputDialog("Uma pena te ver partir  ): \n Digite o cpf: ");
		
		Banco contaBusca = new Banco(null, cpf, 0);
		
		No<Banco> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.cpf.equals(cpf)) {
				found = true;
				contaBusca = aux.dado;
				break;
			}
			aux = aux.dir;
		}
		
		if(found == false) {
			JOptionPane.showMessageDialog(null, "Não encontramos nenhuma conta com este CPF. \n Por favor, verifique os dados e tente novamente");
		} else {
			lista.remover(contaBusca);
			JOptionPane.showMessageDialog(null, "Conta excluida com sucesso \n Obrigado por utilizar nossos serviços e até mais (:");
		}
		
	}
	
	public static void saque() {
		String cpf;
		boolean found = false;
		double valor;
		
		cpf = JOptionPane.showInputDialog("Saque de fundos [$}---(°u°) \n Digite o cpf: ");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Saque de fundos [$}---(°u°) \n Digite o valor desejado para o saque: "));
		Banco contaBusca = new Banco(null, cpf, 0);
		
		No<Banco> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.cpf.equals(cpf)) {
				found = true;
				contaBusca = aux.dado;
				break;
			}
			aux = aux.dir;
		}
		
		if(found == false) {
			JOptionPane.showMessageDialog(null, "Não encontramos nenhuma conta com este CPF. \n Por favor, verifique os dados e tente novamente");
		} else if (contaBusca.saldo < valor) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para o saque. \n Seu saldo atual é de: R$" + contaBusca.saldo + "\nPor favor, verifique os dados e tente novamente");
		} else {
			aux.dado.saldo -= valor;
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! [$}---(°u°) \n Seu saldo atual é de: R$" + contaBusca.saldo);
		}
	}
	
	public static void deposito() {
		String cpf;
		boolean found = false;
		double valor;
		
		cpf = JOptionPane.showInputDialog("Depósito de fundos |$|  [}-(°-°) \n Digite o cpf: ");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Depósito de fundos |$|  [}-(°-°) \n Digite o valor desejado para depósito: "));
		Banco contaBusca = new Banco(null, cpf, 0);
		
		No<Banco> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.cpf.equals(cpf)) {
				found = true;
				contaBusca = aux.dado;
				break;
			}
			aux = aux.dir;
		}
		
		if(found == false) {
			JOptionPane.showMessageDialog(null, "Não encontramos nenhuma conta com este CPF. \n Por favor, verifique os dados e tente novamente");
		} else {
			aux.dado.saldo += valor;
			JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso! |$|  [}-(°-°) \n Seu saldo atual é de: R$" + contaBusca.saldo);
		}
	}
	
	
}

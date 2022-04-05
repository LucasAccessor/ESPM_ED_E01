import javax.swing.JOptionPane;

public class Main {

	// exercicio 01 - feito por lucas accessor - 177350 (:
	
	public static void main(String[] args) {

		int sel = 0;
		
		do {
			sel = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			if (sel < 1 || sel > 6) {
				JOptionPane.showMessageDialog(null, "Opção inválida ):");
			} else {
				switch(sel) {
				case 1: // abre conta
					Operacoes.abertura();
					break;
				case 2: // realiza saque relatorio contas
					Operacoes.saque();
					break;
				case 3: // realiza depósito Encerrar sua Conta
					Operacoes.deposito();
					break;
				case 4: // relatório contas
					Operacoes.relatar();
					break;
				case 5: // encerramento
					Operacoes.encerramento();
					break;
				case 6: // fim
					break;
				}
			}
			
		} while (sel != 6);
		
		
	}

	
	//menu de opções 
	public static String menu() {
		String mensagemMenu = "Banco Local do Dinheiro ($< $) \n";
		mensagemMenu += "Escolha um opção: \n";
		mensagemMenu += "1. Abrir uma Conta \n";
		mensagemMenu += "2. Realizar um Saque \n";
		mensagemMenu += "3. Realizar um Depósito \n";
		mensagemMenu += "4. Relatório de Contas \n";
		mensagemMenu += "5. Encerrar sua Conta \n";
		mensagemMenu += "6. Encerrar a aplicação \n";
		return mensagemMenu;
	}
	

}

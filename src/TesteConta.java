import java.util.Scanner;

public class TesteConta {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do titular da conta: ");
		String nomeTitular = scanner.nextLine();

		System.out.println("Digite o CPF do titular da conta: ");
		String cpfTitular = scanner.nextLine();

		Cliente titular = new Cliente(nomeTitular, cpfTitular);

		ContaCorrente cc = new ContaCorrente(titular);
		ContaPoupanca poupanca = new ContaPoupanca(titular);

		int opcao = 0;
		do {
			System.out.println("\n=========================");
			System.out.println("Digite a opção desejada: ");
			System.out.println("1 - Extrato ");
			System.out.println("2 - Saque ");
			System.out.println("3 - Depósito ");
			System.out.println("4 - Transferência ");
			System.out.println("5 - Sair ");
			System.out.println("=========================");

			opcao = scanner.nextInt();

			switch (opcao) {

			case 1:
				cc.imprimirExtrato();
				poupanca.imprimirExtrato();
				break;

			case 2:
				System.out.println("Digite de qual conta deseja sacar: 1 - Conta Corrente / 2 - Poupança ");
				int contaSaque = scanner.nextInt();

				System.out.println("Digite o valor: ");
				double valorSaque = scanner.nextDouble();

				if (contaSaque == 1 && cc.saldo >= valorSaque) {
					cc.sacar(valorSaque);
				} else if (contaSaque == 2 && poupanca.saldo >= valorSaque) {
					poupanca.sacar(valorSaque);
				} else {
					System.out.println("Opção inválida ou saldo insuficiente");
				}

				break;

			case 3:
				System.out.println("Digite para qual conta deseja depositar: 1 - Conta Corrente / 2 - Poupança ");
				int contaDeposito = scanner.nextInt();

				System.out.println("Digite o valor: ");
				double valorDeposito = scanner.nextDouble();

				if (contaDeposito == 1) {
					cc.depositar(valorDeposito);
				} else if (contaDeposito == 2) {
					poupanca.depositar(valorDeposito);
				} else {
					System.out.println("Opção inválida");
				}

				break;

			case 4:

				System.out.println("Digite para qual conta deseja transferir: 1 - Conta Corrente / 2 - Poupança ");
				int contaTransferencia = scanner.nextInt();

				System.out.println("Digite o valor: ");
				double valorTransferencia = scanner.nextDouble();

				if (contaTransferencia == 1 && poupanca.saldo >= valorTransferencia) {
					poupanca.transferir(valorTransferencia, cc);
				} else if (contaTransferencia == 2 && cc.saldo >= valorTransferencia) {
					cc.transferir(valorTransferencia, poupanca);
				} else {
					System.out.println("Opção inválida ou saldo insuficiente");
				}
				break;

			case 5:
				System.out.println("Sistema Finalizado");
				break;

			}

		} while (opcao != 5);

		scanner.close();
	}

}

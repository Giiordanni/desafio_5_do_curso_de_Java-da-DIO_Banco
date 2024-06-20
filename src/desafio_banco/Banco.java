package desafio_banco;

import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		boolean sair = false;
		
		while(!sair) {
        	System.out.println("1- Criar conta\n2- Entrar na conta\n3- Sair");
        	int op = sc.nextInt();
        	
        	switch(op) {
        	case 1: 
        		criarConta(sc, cliente);
        		break;
        	case 2:
        		acessarConta(sc, cliente);
        		break;
        	case 3: 
        		sair = true;
        		System.out.println("Saindo...");
        		break;
        	default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        	}
		}
		sc.close();
	}

	static void criarConta(Scanner scann, Cliente clienteBanco) {
	
		System.out.println("Informe seu nome: ");
		String nome = scann.nextLine();
		scann.nextLine();
		
		System.out.println("CPF: ");
		String cpf = scann.nextLine();
		
		System.out.println("Sexo (M/F): ");
		char sexo = scann.next().charAt(0);

		System.out.println("Senha: ");
		String senha = scann.next();
		
		
		clienteBanco.adicionarCliente(nome, cpf, sexo, senha);
		
		System.out.println("Conta Criada com sucesso!");
		
	}
	
	public static void acessarConta(Scanner scan, Cliente clienteBanco) {
		System.out.println("CPF: ");
		String cpf = scan.next();
		
		
		if(clienteBanco.verificarExistencia(cpf)) {
			System.out.println("Digite sua senha: ");
			String senha = scan.next();
			
			if(clienteBanco.verificarSenha(cpf, senha)) {
				System.out.println("Bem vindo(a) ");
				System.out.println("1- Conta corrente\n2- Conta Poupança");
				int op = scan.nextInt();
				Conta conta;
				
				if (op == 1) {
					conta = new ContaCorrente(cpf);
				}else if (op == 2) {
					conta = new ContaPoupanca(cpf);
				}else {
					System.out.println("Valor inválido!");
					return;
				}
				boolean sair = false;
				
				while(!sair) {
				
					System.out.println("1- Consultar o Saldo\n2- Sacar\n3- Depositar\n4- Verificar histórico\n5- Transferir da conta corrente para a poupanca\n6- Sair");
					int consulta = scan.nextInt();
					
					switch(consulta) {
					case 1:
						saldo(conta);
						break;
					case 2:
						sacar(conta, scan);
						break;
					case 3:
						Depositar(conta, scan);
						break;
					case 4:
						VerificarHistórico(conta);
						break;
					case 5:
						System.out.println("Infome o cpf da conta Destino: ");
						scan.nextLine();
						String cpfDestino = scan.nextLine();
						Conta outraConta = op == 1 ? new ContaPoupanca(cpfDestino) : new ContaCorrente(cpfDestino);
						transferir(conta, outraConta, scan);
						break;
					case 6:
						sair = true;
						break;
					default:
						System.out.println("Valor inválido!");
						break;
					}
				}
			}else {
				System.out.println("Senha incorreta");
			}
		}else {
			System.out.println("CPF não encontrado!");
		}
	}
	
	public static void saldo(Conta tipo) {
		System.out.println("Saldo: " + tipo.getSaldo());
	}	
	
	public static void Depositar(Conta conta, Scanner sc) {
		System.out.println("Valor de deposito: ");
		double valor = sc.nextDouble();
		
		if(valor <= 0) {
			System.out.println("Valor inválido para depositar");
		}else {
			conta.depositar(valor);
			System.out.println("Depósito realizado com sucesso!");
		}
		
	}
	
	public static void sacar(Conta conta, Scanner sc) {
		System.out.println("Valor de saque: ");
		double valor = sc.nextDouble();
		conta.sacar(valor);
	}
	
	public static void VerificarHistórico(Conta conta) {
		conta.imprimirExtrato();
	}

	public static void transferir(Conta conta1, Conta conta2, Scanner sc) {
		System.out.println("Valor à transferir: ");
		double valor = sc.nextDouble();
		
		if(valor >= 20) {
			conta1.transferir(valor, conta2);
			System.out.println("Transferência realizada com sucesso!");
		}else {
			System.out.println("O Valor mínimo de transferenccia é de 20,00 R$");
		}
		
	}

}





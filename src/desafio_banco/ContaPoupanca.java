package desafio_banco;

public class ContaPoupanca extends Conta{

	ContaPoupanca(String cpf) {
		super(cpf);
	}

	
	public void imprimirExtrato() {
		System.out.println("--- Extrato Conta corrente ---");
		super.exibirDados();
	}
}

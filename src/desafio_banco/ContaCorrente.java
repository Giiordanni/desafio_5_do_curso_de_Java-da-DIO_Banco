package desafio_banco;

public class ContaCorrente extends Conta{

	ContaCorrente(String cpf) {
		super(cpf);
	}
	
	public void imprimirExtrato(){
		System.out.println("--- Extrato Conta corrente ---");
		super.exibirDados();
	}

}

package desafio_banco;

public abstract class Conta implements InterConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private String cpf;
	private Cliente cliente;


	Conta(String cpf){
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public double sacar(double valor) {
		if(valor > this.saldo) {
			System.out.println("Saldo insuficiente para saque!");
		}else if (valor < 20) {
			System.out.println("O valor mínimo para saque é de 10,00 R$");
		}else{
			this.saldo -= valor;
		}
		return valor;
	}

	@Override
	public double depositar(double valor) {
		return saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(saldo > valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}else {
			throw new RuntimeException("Saldo insuficiente para transferir");
		}
	}
	
	
	protected void exibirDados() {
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

}

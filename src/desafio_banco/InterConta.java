package desafio_banco;

public interface InterConta {
	
	double sacar(double valor);
	double depositar(double valor);
	void transferir(double valor, Conta contaDestino);
	void imprimirExtrato();

}

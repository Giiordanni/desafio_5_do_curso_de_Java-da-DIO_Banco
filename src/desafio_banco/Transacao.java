package desafio_banco;

import java.time.LocalDate;

public class Transacao {
	
	private String tipo;
	private double valor;
	private LocalDate data_da_transacao;
	private Conta contaOrigem;
	private Conta contaDestino;
	
	public Transacao(String tipo, double valor, LocalDate data, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.data_da_transacao = data;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public LocalDate getData_da_transacao() {
		return data_da_transacao;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}
}

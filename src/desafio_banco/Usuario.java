package desafio_banco;


public class Usuario implements Comparable<Usuario>{
	private String nome;
	private String cpf;
	private char sexo;
	private String senha;
	
	Usuario(String nome, String cpf, char sexo, String senha){
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "Cliente{"
				+ "Nome: " + this.nome + ", "
				+ "CPF: " + cpf 
				+ ", Sexo: " + sexo
				+ "}";
	}

	@Override
	public int compareTo(Usuario outraSenha) {
		return this.senha.compareTo(outraSenha.getSenha());
	}
	
	public boolean verificarSenha(String senha) {
        return this.senha.equalsIgnoreCase(senha);
    }

}

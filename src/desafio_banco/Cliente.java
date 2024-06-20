package desafio_banco;


import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private List<Usuario> contas;
	
	Cliente(){
		contas = new ArrayList<>();
	}
	
	public void adicionarCliente(String nome, String cpf, char sexo, String senha) {
		if(!verificarExistencia(cpf)) {
			contas.add(new Usuario(nome, cpf, sexo, senha));
		}else {
			System.out.println("Usuário já existente!");
		}
	}
	
	public void removerConta(String cpf) {
		Usuario remover = BuscarporCPF(cpf);
		if(!contas.isEmpty()) {
			if(remover != null ) {
				contas.remove(remover);
				System.out.println("Cliente removido com sucesso!");
			}else {
				System.out.println("Cliente não encontrado!");
			}
		}else {
			throw new RuntimeException("Sem usuários cadastrados!");
		}
	}
	
	public Usuario pesquisarCliente(String nome) {
		if(!contas.isEmpty()) {
			for(Usuario c : contas) {
				if(c.getNome().equalsIgnoreCase(nome)) {
					return c;
				}
			}
		}
		throw new RuntimeException("Sem usuários cadastrados!");
		
	}
	
	public Usuario BuscarporCPF(String cpf) {
		for(Usuario c : contas) {
			if(c.getCpf().equalsIgnoreCase(cpf)) {
				return c;
			}
		}
		return null;
	}

	public boolean verificarExistencia(String cpf) {
		for(Usuario c : contas) {
			if(c.getCpf().equalsIgnoreCase(cpf)) {
				return true;
			}
		}
		return false;
		
	}

	public boolean verificarSenha(String cpf, String senha) {
		Usuario cliente = BuscarporCPF(cpf);
		if(cliente != null) {
			return cliente.verificarSenha(senha);
		}
		return false;
	}
	
	
}

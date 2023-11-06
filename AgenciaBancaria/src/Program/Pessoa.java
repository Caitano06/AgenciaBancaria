package Program;

public class Pessoa {
	
	private static int contador = 1; // incrementa sempre que uma nova instancia 'Pessoa' é criada.
	
	private String name;
	private String cpf;
	private String email;
	
	
	public Pessoa(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		
		contador += 1; // contador de clientes a cada vez que uma conta for criada
	}
	
	//métodos para acessar e modificar os atributos.
	//Os getters permitem recuperar os valores
	//Os setters permitem definir novos valores para os atributos.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//retorna uma string formatada que contém o nome, CPF e email da pessoa
	public String toString() {
		return "\nNome: " + this.getName() +
				"\nCPF: " + this.getCpf() +
				"\nEmail: " + this.getEmail();
	}


}

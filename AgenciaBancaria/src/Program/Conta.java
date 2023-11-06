package Program;

import utilitarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1; //rastrear o número de contas criadas.
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	public Double valor;
	
	
	public Conta(Pessoa pessoa) {
		super();
		this.numeroConta = contadorDeContas; //cada nova conta recebe um número de conta único, que é incrementado a cada criação de conta.
		this.pessoa = pessoa;
		contadorDeContas += 1; //incrementado em +1, a cada vez que uma nova conta é criada
	
	}

	//modificacao e acesso aos atributos
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "\nNumero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.pessoa.getName() +
				"\nCPF: " + this.pessoa.getCpf() +
				"\nEmail: " + this.pessoa.getEmail() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
				"\n";
	}

	public void depositar(Double valorDeposito) {
		
	}


	public void sacar(Double valorSaque) {
		
	}


	public void transferir(Conta contaDestinatario, Double valor) {
		
	}

}

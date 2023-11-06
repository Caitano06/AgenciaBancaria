package entities;

import Program.Conta;
import Program.Pessoa;

public class ContaCorrente extends Conta {
    public ContaCorrente(Pessoa pessoa) {
        super(pessoa);
    }

    //antes dos métodos depositar, sacar e transferir indica que esses métodos estão sendo sobrescritos da classe pai Conta.
    @Override
    public void depositar(Double valor) {
    	
    	// verifica se o valor do deposito é maior que 0, se for valido, incremente o saldo da conta corrente com o valor do depósito
    	if (valor > 0) {
    		super.setSaldo(super.getSaldo() + valor);
     
        } else {
            System.out.println("Valor de depósito inválido.");
            System.out.println("");
        }
    }	
	
    @Override
	public void sacar (Double valor) {
		//precisamos validar e saber se o valor é maior que zero e se o valor é maior que 0
		if(valor > 0 && this.getSaldo() >= valor) {
			super.setSaldo(super.getSaldo() - valor);
			System.out.println("Seu saque foi realizado com sucesso!");
			System.out.println("");
			
		}else {
            System.out.println("Não foi possivel realizar o saque no momento.");
        }
		
	}
	@Override
	public void transferir (Conta contaParaDeposito, Double valor) {
		
		//  se o valor da transferência é maior que zero e se o saldo da conta corrente é suficiente para cobrir a transferência.
		if (valor > 0 && this.getSaldo() >= valor) {
			
			super.setSaldo(super.getSaldo() - valor); // Satisfazendo a condição acima, será feito a subtração da conta para transferencia
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor); // a conta para deposito vai receber o valor que deseja transferir. Sendo assim, pegando o valor que consta na conta e somar com o valor transferido 
			
			System.out.println("Sua transferencia foi realizada com sucesso!");
			System.out.println("");
		
		}else {
            System.out.println("Não foi possivel realizar a transferencia no momento.");
            System.out.println("");
        }
		
	}
	
}

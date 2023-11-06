package Program;

import java.util.ArrayList;
import java.util.Scanner;

import entities.ContaCorrente;

public class AgenciaBancaria {
	
	static Scanner input = new Scanner (System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes(); //permite a seleção de uma ação e chama o método correspondente com base na escolha.
	}
	
	public static void operacoes() {
		
		System.out.println("-----------------------------------------------------\n" +
                "------------- Bem Vindo a nossa Agencia -------------\n" +
                "-----------------------------------------------------\n" +
                "------------ Selecione uma opcao do MENU ------------\n" +
                "-----------------------------------------------------\n\n" +
                "" +
                "         |     Opcao 1 - Criar Conta      |\n" +
                "         |     Opcao 2 - Depositar        |\n" +
                "         |     Opcao 3 - Sacar            |\n" +
                "         |     Opcao 4 - Transferir       |\n" +
                "         |     Opcao 5 - Listar Contas    |\n" +
                "         |     Opcao 6 - Sair             |\n");

        System.out.print("Escolha uma opção: ");
        
        int operacoes = input.nextInt();
        
        switch (operacoes) {
        case 1:
            criarConta();
            break;
        case 2:
            depositar();
            break;
        case 3:
            sacar();
            break;
        case 4:
            transferir();
            break;
        case 5:
            listarContas();
            break;
        case 6:
            System.out.println("Obrigado por fazer parte da nossa Agencia. Volte sempre!");
            System.exit(0);
            
        default:
            System.out.println("Opção inválida.");
            operacoes();
            break;
        }
	}  
	
	//criaccao da conta do usuario, e adicionada á lista de contas bancarias
	public static void criarConta() {
		
		System.out.println("Nome: ");
		String nome = input.next();
		
		System.out.println("CPF: ");
		String cpf = input.next();
		
		System.out.println("Email: ");
		String email = input.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		ContaCorrente conta = new ContaCorrente(pessoa);
		
		
		contasBancarias.add(conta);
		System.out.println("Sua Conta foi criada com sucesso!");
		System.out.println("");
		operacoes();
	}

	//verificação da existencia da conta bancaria fornecida pelo usuario
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		
		//precisamos conferir se a conta existe, a mesma precisa ser maior que 0
		if(contasBancarias.size() > 0) {
			
			//Se exitir contas, iremos percorrer a cada conta se o numero que o usuario digitou CONFERE
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) { // Se existir uma conta conforme digitou o usuario, no lugar de 'null', ela receberá 'c' 
				conta = c;
				}				
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.print("Numero da conta: ");
		System.out.println("");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta); //localiza a conta com o numero informado pelo usuario
		
		if(conta != null) {
			System.out.print("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			System.out.println("Seu deposito realizado com sucesso!");
			System.out.println("");
			
			conta.depositar(valorDeposito);
		}else {
			System.out.println("Conta não localizada!");
			System.out.println("");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.print("Numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			
		}else {
			System.out.println("Conta não localizada!");
			System.out.println("");
		}
		operacoes();
	}
	public static void transferir() {
		System.out.print("Numero da conta do remetente: ");
		int numeroContaRemetente = input.nextInt(); //armazenamento do numero da conta do remetente
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente); //localiza a conta do remetente 
		
		// se a conta do remetente for diferente de null, ela é localizada e processegue com o programa
		if (contaRemetente != null) {
			System.out.print("Numero da conta do destinatario: ");
			int numeroContaDestinatario = input.nextInt(); //armazenamento do numero da conta ddo usuario
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			//se a conta do destinatario for localizada (diferente de 'null', é dado prosseguimento no programa)
			if(contaDestinatario != null) {
				System.out.println("valor da transferencia: ");
				Double valor = input.nextDouble(); //valor a ser transferido
				
				
				contaRemetente.transferir(contaDestinatario, valor); // metodo de transferencia da conta do remetente para a conta do destinatario
				
			}else {
				System.out.println("A conta para deposito nao foi localizada."); // apresenta essa mensagem, caso não exista outra conta inserida
				System.out.println("");
			}
		}else {
			System.out.println("Conta para transferencia não localizada."); // se a conta do remetente for igual a null, é apresentado essa mensagem
			System.out.println(""); 
		}
		operacoes();
	}
	
	public static void listarContas() {
		// se existir contas criadas, será executado o primeiro bloco
		if(contasBancarias.size() > 0) {
			
			//percorre todas as contas criadas e armazenadas
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não há contas cadastradas."); // se não existir contas ainda, seráapresentado essa mensagem
			System.out.println("");
		}
		operacoes();
		
	}
	
}

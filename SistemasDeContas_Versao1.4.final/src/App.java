import java.util.ArrayList;
import java.util.Scanner;
//Pedro H.Godoi Rezende
//Samuel Souto
/*
Criação de conta
Saque de uma conta
Transferência entre contas 
Consulta de saldo
Empréstimo
Busca de conta por conta
Sair do programa
*/
public class App {
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        Scanner scan = new Scanner(System.in);
        String nomeCorrentista="";
        int telefone=0, agenciaBanco=0;
        Double valorDep=0.0;
        ArrayList<Contas> contas = new ArrayList<>(100);
       
        Contas Contas = new Contas(nomeCorrentista, telefone, agenciaBanco, valorDep);
        
        

            System.out.println("_______________________");
			System.out.println("|  Entrar no Banco  |  ");
			System.out.println("|______________________|\n");
			System.out.println("|[1]Entrar|\n|[7]Sair|\n");
            opcao = scan.nextInt();
         
		while (opcao!=7) {
			System.out.println("______________");
			System.out.println("|  CADASTRO  |  ");
			System.out.println("|____________|\n");
	        System.out.println("Escolha uma opção:  "+
                  "|\n[1] Criação de conta          "+
                  "|\n[2] Saque de uma conta        "+
                  "|\n[3] Transferência entre contas"+
                  "|\n[4] Consulta de saldo         "+
                  "|\n[5] Empréstimo                "+
                  "|\n[6] Busca de conta por conta  "+
                  "|\n[7] Sair do programa         |");
	               opcao = scan.nextInt();
            
                   
            switch (opcao) {
            case 1:
            System.out.println("Qual tipo de conta dejesa criar?\n Pessoa física[1]\n Pessoa jurídica[2]\n Pessoa assalariado[3]");
            int respTipoConta = scan.nextInt();
                if (respTipoConta==1) {Contas.criarContaFisica(contas);}
                if (respTipoConta==2) {Contas.criarContaJuridica(contas);}
                if (respTipoConta==3) {Contas.criarContaSal(contas);}
                break;
               
            case 2:
            Contas.sacar(contas);
                break;

            case 3:
                Contas.transferirEntreContas(contas);
                break;
            case 4:
                Contas.colsultaSaldo(contas);
                break;
            case 5:
                Contas.emprestimo(contas);
                break;
            case 6:
                Contas.buscaConta(contas);
                break;
            case 7:
            System.out.println("\nFim do programa.");
                break;
            default:
                System.out.println("\nOpção inválida");
            }
                
                    
        }
                        
    }
}

        
        
    
    

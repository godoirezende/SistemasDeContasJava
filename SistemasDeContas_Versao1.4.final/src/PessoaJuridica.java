import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PessoaJuridica extends Contas{
    protected String cnpj;
    protected double patrimonio, credito, saldo;

    Locale localeBR = new Locale("pt","BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
    protected ArrayList<Contas> contas = new ArrayList<>();
    Scanner scan = new Scanner (System.in);

    public PessoaJuridica( String cnpj, double patrimonio, double credito,
        String nomeCorrentista, int telefone, int agenciaBanco, Double valorDep, Double saldo){
        super(nomeCorrentista, telefone, agenciaBanco, valorDep);
            this.cnpj = cnpj;
            this.patrimonio = patrimonio;
            this.credito = credito;
            

     }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    public void verificarPatri(double patrimonio){
        if(patrimonio <= 1000000.0){
            CreditoMenor(patrimonio);
        }if(patrimonio > 1000000.0){
            CreditoMaior(patrimonio);
        }
    }

    public void CreditoMaior(double credito){
        
        System.out.println("Digite um valor para o Empréstimo (até R$500.000,00): ");
        credito = scan.nextDouble();

        if(credito>500000.0){
            System.out.println("Não foi possivel realizar o Empréstimo: ");
        }
        else{
            System.out.println("Empréstimo no valor de "+dinheiro.format(credito)+" realizado!");
            saldo =+credito;
        }
    }
    
    public void CreditoMenor(double credito){
        
        System.out.println("Digite um valor para o Empréstimo (até R$100.000,00): ");
        credito = scan.nextDouble();

        if(credito>100000.0){
            System.out.println("Não foi possivel realizar o Empréstimo: ");
        }
        else{
            System.out.println("Empréstimo no valor de "+dinheiro.format(credito)+" realizado!");
            saldo = saldo+credito;
        }
    }

    public  Double saquePj(int place, ArrayList<Contas> contas){
    
        Double valorSaque = scan.nextDouble();

        
        valorDep = contas.get(place).getValorDep();
        Double patrimonio = valorDep;

        if(valorSaque>patrimonio)
        { 
            System.out.println("\nSaque realizado com sucesso!! \n Valor disponível nessa conta é insuficiente para o saque, faça um emprestimo para conseguir sacar.");        
        }

        if(valorSaque<patrimonio){
            patrimonio=patrimonio-valorSaque;
            System.out.println("\nSaque de R$" + valorSaque+" realizado com sucesso!! \n O saldo atual disponível na conta é: " + patrimonio);
            System.out.print("\nSua conta: "+contas.get(place));
        }
        
        return 0.0;
            
    }  
    
    public void transContPj(){

        System.out.print("\nQuanto você quer transferir desta conta para a outra conta?");
                Double valorTransf= scan.nextDouble();
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
        for (int i = 0; i <contas.size() ; i++) {
            if(contas.get(i).getClass() == PessoaJuridica.class){
            
                if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                    int place =i;
                    Double saldo=contas.get(place).getValorDep(); 
                    if (valorTransf<saldo) {
                        saldo=-valorTransf;   
                        contas.get(place).setValorDep(saldo);
                        System.out.print("Transferência ocorrida com sucesso!\nSeu saldo atual é de: "+saldo);
                    }
                    else{
                        System.out.println("Saldo insuficiente.");
                    }

                }  
            }
        }
       
        
        System.out.println("Qual é o tipo da conta que receberá o valor transferido? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                  
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
                for (int i = 0; i <contas.size() ; i++) {
                    if(contas.get(i).getClass() == PessoaFisica.class){
                   
                        if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                            int place = i;
                            Double saldo=contas.get(place).getValorDep();
                            saldo =+valorTransf;
                            contas.get(place).setValorDep(saldo);
                            System.out.print("Transferência ocorrida com sucesso!\nSeu saldo atual é de: "+saldo);
                            
                        }  
                    }
                }

                break;

            case 2:
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == Salario.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        int place = i;
                        Double saldo=contas.get(place).getValorDep();
                        saldo =+valorTransf;
                        contas.get(place).setValorDep(saldo);
                        System.out.print("Transferência ocorrida com sucesso!\nSeu saldo atual é de: "+saldo);
                    }
                }
            }
                break;    
        
            case 3:
                
            System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == Salario.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        int place = i;
                        Double saldo=contas.get(place).getValorDep();
                        saldo =+valorTransf;
                        contas.get(place).setValorDep(saldo);
                        System.out.print("Transferência ocorrida com sucesso!\nSeu saldo atual é de: "+saldo);
                    }
                }
            }
                break;    
        
            default:
                break;
        }
    }   
    @Override
    public String toString() {
        
        return "\nNome do dono: "+nomeCorrentista+"\nTelefone: "+telefone+"\nCnpj: "+cnpj+"\nAgência bancária: "+agenciaBanco+"\nValor depositado: "+dinheiro.format(valorDep) +"\nPatrimônio: "+dinheiro.format(patrimonio)+"\nCrédito: "+dinheiro.format(credito)+"\n";
      
    }

    public String imprimeSaldoPj(int place, ArrayList<Contas> contas){
        saldo=contas.get(place).getValorDep();
        nomeCorrentista=contas.get(place).getNomeCorrentista();
            
        return "\nSaldo da conta atual do "+ nomeCorrentista+" é de: "+dinheiro.format(saldo)+"\n";
   
       
    }

}

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;


public class Salario extends Contas{
    protected int cpf;
    protected Double salario, valorSaque, saldo, valorConsumidoCheque, taxa, limiteCheque;
    
    protected ArrayList<Contas> contas = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    
    Locale localeBR = new Locale("pt","BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

    public Salario(int cpf, Double salario, Double valorSaque, Double saldo, String nomeCorrentista, int telefone, int agenciaBanco, Double valorDep, int codigoConta) {
        super(nomeCorrentista, telefone, agenciaBanco, valorDep);
        
        
        this.cpf = cpf;
        this.salario = Double.valueOf(salario);
        this.valorSaque = valorSaque;
        this.saldo = saldo;
        
      
       
    
    }

    public int getcpf() {
        return cpf;
    }

    public void setcpf(int cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(Double valorSaque) {
        this.valorSaque = valorSaque;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getValorConsumidoCheque() {
        return valorConsumidoCheque;
    }

    public void setValorConsumidoCheque(Double valorConsumidoCheque) {
        this.valorConsumidoCheque = valorConsumidoCheque;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }



    public  Double getLimiteCheque() {
        return limiteCheque;
    }



    public void setLimiteCheque(Double limiteCheque) {
        this.limiteCheque = limiteCheque;
    }

     
    public  Double saquePa(int place, ArrayList<Contas> contas){
        
        valorSaque = scan.nextDouble();

        taxa = (valorSaque * 0.0001);
        saldo = valorDep - taxa ;
        limiteCheque=2*getSalario();
        valorDep = contas.get(place).getValorDep();
       

        if(valorSaque>saldo)
        { 
            saldo=saldo-valorSaque;
            Double valorConsumidoCheque=limiteCheque-saldo;

            saldo=0.0;

            System.out.println("\nSaque realizado com sucesso!! \n Valor disponível do cheque especial: "+valorConsumidoCheque );
            System.out.print("\nSua conta: "+contas.get(place));
           
        }

        if(valorSaque<saldo){
           saldo=saldo-valorSaque;
           System.out.println("\nSaque de R$" + valorSaque+" realizado com sucesso!! \n O saldo atual disponível na conta é: " + saldo);
           System.out.print("\nSua conta: "+contas.get(place));
           
        }
       
        return 0.0;
          
    }

    
     
   
  
    public  void chequeEspecial(int place, ArrayList<Contas> contas){
        saldo=contas.get(place).getValorDep();
        limiteCheque=2*getSalario();
        System.out.println("Você pode fazer um emprestimo de até "+limiteCheque+"\nQual seria o valor do empréstimo?");
        Double emprestimoCheque = scan.nextDouble();
        if (emprestimoCheque>limiteCheque) {
            saldo=-emprestimoCheque;
            System.out.println("Seu empréstimo foi de: "+emprestimoCheque+"\nSeu saldo atual é de: "+saldo);

        }
        else{
            System.out.println("O valor do seu empréstimo ultrapassou o limete do cheque.");
        }
        

    }   

    public void transContPa(){

        System.out.print("\nQuanto você quer transferir desta conta para a outra conta?");
                Double valorTransf= scan.nextDouble();
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
        for (int i = 0; i <contas.size() ; i++) {
            if(contas.get(i).getClass() ==Salario.class){
            
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
        return "\nNome: "+nomeCorrentista+"\nTelefone: "+telefone+"\nCpf: "+cpf+"\nAgência bancária: "+agenciaBanco+"\nValor depositado: "+dinheiro.format(valorDep) +"\nSalário: "+dinheiro.format(salario)+"\nSaldo atual: "+dinheiro.format(saldo)+"\n";
    }

    public String imprimeSaldoSal(int place, ArrayList<Contas> contas){
        saldo=contas.get(place).getValorDep();
        nomeCorrentista=contas.get(place).getNomeCorrentista();
            
            return "\nSaldo da conta atual do "+ nomeCorrentista+" é de: "+dinheiro.format(saldo)+"\n";
       
       
    }
}

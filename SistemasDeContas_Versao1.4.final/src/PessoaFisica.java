import java.util.ArrayList;

public class PessoaFisica extends Contas{
    protected int cpf;
    
    protected boolean nomeSerasa;
    protected ArrayList<Contas> contas = new ArrayList<>();

    public PessoaFisica(int cpf, String nomeCorrentista, int telefone, int agenciaBanco, Double valorDep, 
             boolean nomeSerasa) {
        super(nomeCorrentista, telefone, agenciaBanco, valorDep);
        this.cpf = cpf;
        
        
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public boolean isNomeSerasa() {
        return nomeSerasa;
    }

    public void setNomeSerasa(boolean nomeSerasa) {
        this.nomeSerasa = nomeSerasa;
    }

    public void booleanEmprestimoPF(){
        
        if(isNomeSerasa() == true){
        System.out.println("Não foi possível realizar o empréstimo!");

        }
        if(isNomeSerasa() == false){
        System.out.println("É possível realizar empréstimo!");
        int place=0;
        emprestimoPF(place, contas);

        }
    }
    
    
   
    public ArrayList<Contas> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Contas> contas) {
        this.contas = contas;
    }

    public  Double saquePf(int place, ArrayList<Contas> contas){
        
        Double valorSaque = scan.nextDouble();

       
        valorDep = contas.get(place).getValorDep();
        Double saldo = valorDep;

        if(valorSaque>saldo)
        { 
            System.out.println("\nSaque realizado com sucesso!! \n Valor disponível sua conta é insuficiente para o saque, faça um emprestimo para conseguir sacar.");        
        }

        if(valorSaque<saldo){
           saldo=saldo-valorSaque;
           System.out.println("\nSaque de R$" + valorSaque+" realizado com sucesso!! \n O saldo atual disponível na conta é: " + saldo);
           System.out.print("\nSua conta: "+contas.get(place));
        }
       
        return 0.0;
          
    }
   
    public Double emprestimoPF(int place, ArrayList<Contas> contas ){
       System.out.println("Qual é o valor do seu empréstimo? ");
        Double valorEmprestimo = scan.nextDouble();
        valorDep = contas.get(place).getValorDep();
        Double saldo = valorDep;
        saldo=-valorEmprestimo;
        System.out.println("\nEmpréstimo de: "+saldo+" realizado com sucesso!\nSeu saldo atual é de: "+saldo);

        
       
        return 0.0;
    }

    public void transContPf(){

        System.out.print("\nQuanto você quer transferir desta conta para a outra conta?");
                Double valorTransf= scan.nextDouble();
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
        for (int i = 0; i <contas.size() ; i++) {
            if(contas.get(i).getClass() == PessoaFisica.class){
            
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
        
        return "\nNome: "+nomeCorrentista+"\nTelefone: "+telefone+"\nCpf: "+cpf+"\nAgência bancária: "+agenciaBanco+"\nValor depositado: "+valorDep+"\n";
      
    }
    
    public String imprimeSaldoPf(int place, ArrayList<Contas> contas){

        Double saldo=contas.get(place).getValorDep();
        nomeCorrentista=contas.get(place).getNomeCorrentista();
            
        return "\nSaldo da conta atual do "+ nomeCorrentista+" é de: "+dinheiro.format(saldo)+"\n";
   
       
    }
    
}

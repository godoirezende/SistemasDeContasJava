import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Contas {
    protected String nomeCorrentista;
    protected int telefone, agenciaBanco;
    protected Double valorDep;

    
    Locale localeBR = new Locale("pt","BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
    Scanner scan = new Scanner(System.in);
    ArrayList<Contas> contas = new ArrayList<>(100);
    
   
    
    public Contas(String nomeCorrentista, int telefone, int agenciaBanco, Double valorDep) {
        this.nomeCorrentista = nomeCorrentista;
        this.telefone = telefone;
        this.agenciaBanco = agenciaBanco;
        this.valorDep = valorDep;
        
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getAgenciaBanco() {
        return agenciaBanco;
    }

    public void setAgenciaBanco(int agenciaBanco) {
        this.agenciaBanco = agenciaBanco;
    }

    public Double getValorDep() {
        return valorDep;
    }

    public void setValorDep(Double valorDep) {
        this.valorDep = valorDep;
    }

   
   

    //Feito
    public void criarContaFisica(ArrayList<Contas> contas) {
         
        System.out.println("Insira o seu nome: ");
        String nomeCorrentista = scan.next();
        
        System.out.println("Insira o CPF: ");
        int cpf= scan.nextInt();
        
        System.out.println("Digite o número da sua agência bancária : ");
        int agenciaBanco = scan.nextInt();
        
        System.out.println("Insira o seu número de telefone : ");
        int telefone = scan.nextInt();

        System.out.println("Digite o seu deposito inicial : ");
        Double valorDep = scan.nextDouble();

        System.out.println("Você está com o nome limpo? Sim ou não(s/n)");
        String respostaNomeSerasa = scan.next();
        if (respostaNomeSerasa.equals("s")) {
            contas.add(new PessoaFisica(cpf, nomeCorrentista, telefone, agenciaBanco, valorDep,false )); 
        }
        if (respostaNomeSerasa.equals("n")) {
            contas.add(new PessoaFisica(cpf, nomeCorrentista, telefone, agenciaBanco, valorDep,true )); 
        }
        
    }
    //Feito
    public void criarContaSal( ArrayList<Contas> contas){
        
             
        System.out.println("Insira o seu nome: ");
        String nomeCorrentista = scan.next();
        
        System.out.println("Insira o CPF: ");
        int cpf= scan.nextInt();
        
        System.out.println("Digite o número da sua agência bancária : ");
        int agenciaBanco = scan.nextInt();
        
        System.out.println("Insira o seu número de telefone : ");
        int telefone = scan.nextInt();
        
        System.out.println("Informe o seu salário.");
        Double respostaValorSal =  scan.nextDouble();

        

        if (respostaValorSal>0) {
    
            System.out.println("Informe o seu deposito inicial.");
            Double depositoInicialSaldo = scan.nextDouble(); 
           
            contas.add(new Salario(cpf, depositoInicialSaldo, respostaValorSal, depositoInicialSaldo, nomeCorrentista, telefone, agenciaBanco, respostaValorSal, telefone));
            
        }
 
    }
    //Feito
    public void criarContaJuridica(ArrayList<Contas> contas) {
        
                    
        System.out.println("Insira o seu nome: ");
        String nomeCorrentista = scan.next();
        
        System.out.println("Insira o CNPJ: ");
        int cnpj= scan.nextInt();
        
        System.out.println("Digite o número da sua agência bancária : ");
        int agenciaBanco = scan.nextInt();
        
        System.out.println("Insira o seu número de telefone : ");
        int telefone = scan.nextInt();

        System.out.println("Qual o valor do seu patrimonio?");
        Double patrimonio = scan.nextDouble();

        contas.add(new PessoaJuridica(nomeCorrentista, cnpj, patrimonio, nomeCorrentista, telefone, agenciaBanco, valorDep, patrimonio));        
       
    }
    //Feito
    public void sacar(ArrayList<Contas> contas){
        Salario sal = new Salario(agenciaBanco, valorDep, valorDep, valorDep, nomeCorrentista, agenciaBanco, agenciaBanco, valorDep, agenciaBanco);
        PessoaFisica pf = new PessoaFisica(agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, false);
        PessoaJuridica pj = new PessoaJuridica(nomeCorrentista, agenciaBanco, agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, valorDep);
       
        System.out.println("Qual é o tipo da sua conta? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                  
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
                for (int i = 0; i <contas.size() ; i++) {
                    if(contas.get(i).getClass() == PessoaFisica.class){
                   
                        if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                            int place =i;
                            System.out.print("Quanto você quer sacar desta conta?");
                            contas.get(i).setValorDep(pf.saquePf(place,contas)); 
                        }  
                    }
                }

                break;

            case 2:
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == PessoaJuridica.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        
                        //((Salario) sal).saque(contas);
                        int place = i; 
                        System.out.println("Quanto você quer sacar desta conta?");
                        contas.get(i).setValorDep(pj.saquePj(place,contas));
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
                        
                        //((Salario) sal).saque(contas);
                        int place = i; 
                        System.out.println("Quanto você quer sacar desta conta?");
                        contas.get(i).setValorDep(sal.saquePa(place,contas));
                    }
                }
            }
                break;    
        
            default:
                break;
        }

    }
     //Inacabado  
    public void transferirEntreContas(ArrayList<Contas> contas){
        Salario sal = new Salario(agenciaBanco, valorDep, valorDep, valorDep, nomeCorrentista, agenciaBanco, agenciaBanco, valorDep, agenciaBanco);
        PessoaFisica pf = new PessoaFisica(agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, false);
        PessoaJuridica pj = new PessoaJuridica(nomeCorrentista, agenciaBanco, agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, valorDep);
       
        System.out.println("Qual é o tipo da sua conta? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
               pf.transContPf();
                    break;

            case 2:
               pj.transContPj();
                    break;

            case 3:
                sal.transContPa();
                    break;    
        
            default:
                    break;
        }
    }
    //Feito
    public void colsultaSaldo(ArrayList<Contas> contas){
        Salario sal = new Salario(agenciaBanco, valorDep, valorDep, valorDep, nomeCorrentista, agenciaBanco, agenciaBanco, valorDep, agenciaBanco);
        PessoaFisica pf = new PessoaFisica(agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, false);
        PessoaJuridica pj = new PessoaJuridica(nomeCorrentista, agenciaBanco, agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, valorDep);
       
        System.out.println("Qual é o tipo da sua conta? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                 
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
                for (int i = 0; i <contas.size() ; i++) {
                    if(contas.get(i).getClass() == PessoaFisica.class){
                   
                        if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                            int place =i;                            
                            System.out.print("\nSua conta: "+ pf.imprimeSaldoPf(place,contas) );
                        }  
                    }
                }

                break;

            case 2:
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == PessoaJuridica.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        int place = i; 
                        System.out.print("\nSua conta: "+pj.imprimeSaldoPj(place,contas) );
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
                        System.out.print("\nSua conta: "+sal.imprimeSaldoSal(place,contas) );
                       
                    }
                }
            }
                break;    
        
            default:
                break;
        }
    }
    //Feito
    public void emprestimo(ArrayList<Contas> contas){
        Salario sal = new Salario(agenciaBanco, valorDep, valorDep, valorDep, nomeCorrentista, agenciaBanco, agenciaBanco, valorDep, agenciaBanco);
        PessoaFisica pf = new PessoaFisica(agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, false);
        
        PessoaJuridica pj = new PessoaJuridica(nomeCorrentista, agenciaBanco, agenciaBanco, nomeCorrentista, telefone, agenciaBanco, valorDep, valorDep);
       
        System.out.println("Qual é o tipo da sua conta? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            //Feito
            case 1:
                  
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
                
                for (int i = 0; i <contas.size() ; i++) {
                    if(contas.get(i).getClass() == PessoaFisica.class){
                   
                        if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                               
                            pf.booleanEmprestimoPF();
               
                        }  
                    }
                }

                break;

           
            case 2:
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == PessoaJuridica.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        int place = i; 
                        sal.chequeEspecial(place, contas);
                        
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
                        Double patrimonio = contas.get(place).getValorDep();
                        pj.verificarPatri(patrimonio);
                       
                    }
                }
            }
                break;    
        
            default:
                break;
        }
    }
    //Feito
    public void buscaConta(ArrayList<Contas> contas){
        
        
        System.out.println("Qual é o tipo da sua conta? Pessoa física[1]. Pessoa juridica[2]. Pessoa assalariada[3]");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                   
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco = scan.nextInt();
                
                for (int i = 0; i <contas.size() ; i++) {
                    if(contas.get(i).getClass() == PessoaFisica.class){
                   
                        if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                            int place =i;                            
                            System.out.print("\nSua conta: "+contas.get(place));
                        }  
                    }
                }

                break;

            case 2:
                System.out.println("Digite número da sua agência bancária. ");
                agenciaBanco= scan.nextInt();
            for (int i = 0; i <contas.size() ; i++) {
                if(contas.get(i).getClass() == PessoaJuridica.class){
               
                    if (contas.get(i).getAgenciaBanco()==agenciaBanco) {
                        int place = i; 
                        System.out.print("\nSua conta: "+contas.get(place));
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
                        System.out.print("\nSua conta: "+contas.get(place));
                       
                    }
                }
            }
                break;    
        
            default:
                break;
        }
    }
    
   
}

